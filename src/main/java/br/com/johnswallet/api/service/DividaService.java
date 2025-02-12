package br.com.johnswallet.api.service;

import br.com.johnswallet.api.dto.DestinatarioDTO;
import br.com.johnswallet.api.dto.MensagemConteudoDTO;
import br.com.johnswallet.api.dto.MensagemDTO;
import br.com.johnswallet.api.dto.MetadadosDTO;
import br.com.johnswallet.api.entity.Divida;
import br.com.johnswallet.api.entity.Pessoa;
import br.com.johnswallet.api.enums.PagamentoStatusEnum;
import br.com.johnswallet.api.repository.CompraRepository;
import br.com.johnswallet.api.repository.DividaRepository;
import br.com.johnswallet.api.queue.MensagemProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DividaService extends DefaultCrudService<Divida, UUID> {

    protected final DividaRepository repository;
    protected final CompraRepository compraRepository;
    private final MensagemProducer mensagemProducer;

    @Override
    protected JpaRepository<Divida, UUID> getRepository() {
        return repository;
    }

    @Transactional
    public void iniciarCobrancas() {
        LocalDate ultimoDiaMes = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());

        List<Divida> dividasPendentes = repository.findAllByStatusAndDataVencimentoLessThanEqual(
                PagamentoStatusEnum.PENDENTE, ultimoDiaMes);

        Map<Pessoa, List<Divida>> dividasPorDevedor = dividasPendentes
                .stream()
                .collect(Collectors.groupingBy(Divida::getDevedor));

        dividasPorDevedor.forEach((pessoa, dividas) -> {
            String message = getResumoDividas(pessoa, dividas);

            DestinatarioDTO destinatarioDTO = new DestinatarioDTO(
                    pessoa.getNome(),
                    pessoa.getTelefone(),
                    pessoa.getEmail()
            );

            MensagemConteudoDTO mensagemConteudoDTO = new MensagemConteudoDTO(
                    "COBRANCA",
                    message,
                    null
            );

            MetadadosDTO metadadosDTO = new MetadadosDTO(
                    LocalDateTime.now(),
                    null
            );

            MensagemDTO mensagemDTO = new MensagemDTO(
                    UUID.randomUUID().toString(),
                    destinatarioDTO,
                    mensagemConteudoDTO,
                    List.of("EMAIL"),
                    metadadosDTO
            );

            mensagemProducer.enviarMensagem(mensagemDTO);
        });

    }

    protected String getResumoDividas(Pessoa devedor, List<Divida> dividas) {
        StringBuilder message = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        message.append("Olá ").append(devedor.getNome()).append(", ");
        message.append("você tem as seguintes pendências:\n\n");

        Pessoa credor = dividas.getFirst().getCredor();

        BigDecimal total = BigDecimal.ZERO;
        for (Divida it : dividas) {
            message.append("- ").append(it.getDescricao())
                    .append("\n  Estabelecimento: " + it.getEstabelecimento())
                    .append("\n  Data da Compra: " + it.getDataDivida().format(formatter))
                    .append("\n  Data da Vencimento: " + it.getDataVencimento().format(formatter))
                    .append("\n  Valor: " + it.getValor().setScale(2, BigDecimal.ROUND_HALF_UP))
                    .append("\n\n");
            total = total.add(it.getValor());
        }

        message.append("\nTotal devido: R$ ").append(total);
        message.append("\nEntre em contato com ").append(credor.getNome()).append(".");

        return message.toString();
    }

}

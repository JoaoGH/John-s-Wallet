package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.Divida;
import br.com.johnswallet.api.enums.PagamentoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DividaRepository extends JpaRepository<Divida, UUID> {

    List<Divida> findAllByStatusAndDataVencimentoLessThanEqual(PagamentoStatusEnum status, LocalDate dataVencimento);

}

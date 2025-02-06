package br.com.johnswallet.api.dto;

import java.util.List;

public record MensagemDTO(
        String id,
        DestinatarioDTO destinatario,
        MensagemConteudoDTO mensagem,
        List<String> metodoEnvio,
        MetadadosDTO metadados) {
}

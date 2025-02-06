package br.com.johnswallet.api.dto;

public record MensagemConteudoDTO(
        String tipo,
        String conteudo,
        String imagemUrl
) {
}

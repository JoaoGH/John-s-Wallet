package br.com.johnswallet.api.dto;

import java.time.LocalDateTime;

public record MetadadosDTO(
        LocalDateTime dataCriacao,
        String vencimento
) {
}

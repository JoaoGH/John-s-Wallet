package br.com.johnswallet.api.entity;

import br.com.johnswallet.api.enums.PagamentoStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "compras")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Compra extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_compra", nullable = false)
    private LocalDate dataCompra;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(nullable = false)
    private Integer parcelas;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private PagamentoStatusEnum status;

    @Column(nullable = false)
    private String estabelecimento;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false)
    private FormaPagamento formaPagamento;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

}

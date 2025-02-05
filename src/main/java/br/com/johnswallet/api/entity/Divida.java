package br.com.johnswallet.api.entity;

import br.com.johnswallet.api.enums.PagamentoStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "dividas")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Divida extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "devedor_id", nullable = false)
    private Pessoa devedor;

    @ManyToOne
    @JoinColumn(name = "credor_id", nullable = false)
    private Pessoa credor;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Lob
    @Column
    private String descricao;

    @Column
    private String estabelecimento;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private PagamentoStatusEnum status;

    @Column(name = "data_divida", nullable = false)
    private LocalDate dataDivida;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

}

package br.com.johnswallet.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "itens_compra")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ItemCompra extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name ="valor_unitario", precision = 10, scale = 2, nullable = false)
    private BigDecimal valorUnitario;

}

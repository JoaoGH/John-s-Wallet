package br.com.johnswallet.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "pessoas")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Pessoa extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

}

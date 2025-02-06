package br.com.johnswallet.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "formas_pagamento")
@Data
@EntityListeners(AuditingEntityListener.class)
public class FormaPagamento extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Lob
    @Column
    private String descricao;

}

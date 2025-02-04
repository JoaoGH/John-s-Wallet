package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, UUID> {
}

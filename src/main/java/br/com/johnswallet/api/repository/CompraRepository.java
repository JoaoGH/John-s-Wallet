package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompraRepository extends JpaRepository<Compra, UUID> {
}

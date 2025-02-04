package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, UUID> {
}

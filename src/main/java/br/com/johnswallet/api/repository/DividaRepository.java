package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DividaRepository extends JpaRepository<Divida, UUID> {
}

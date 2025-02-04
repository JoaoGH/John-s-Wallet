package br.com.johnswallet.api.repository;

import br.com.johnswallet.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}

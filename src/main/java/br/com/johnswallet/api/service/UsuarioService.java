package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService extends DefaultCrudService<Usuario, UUID> {

    protected UsuarioService(JpaRepository<Usuario, UUID> repository) {
        super(repository);
    }

}

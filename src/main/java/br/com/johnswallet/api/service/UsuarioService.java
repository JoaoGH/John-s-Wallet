package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Usuario;
import br.com.johnswallet.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService extends DefaultCrudService<Usuario, UUID> {

    protected final UsuarioRepository repository;

    @Override
    protected JpaRepository<Usuario, UUID> getRepository() {
        return repository;
    }

}

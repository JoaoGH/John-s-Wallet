package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Pessoa;
import br.com.johnswallet.api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaService extends DefaultCrudService<Pessoa, UUID> {

    protected final PessoaRepository repository;

    @Override
    protected JpaRepository<Pessoa, UUID> getRepository() {
        return repository;
    }

}

package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Pessoa;
import br.com.johnswallet.api.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService extends DefaultCrudService<Pessoa, UUID> {

    protected PessoaService(PessoaRepository repository) {
        super(repository);
    }

}

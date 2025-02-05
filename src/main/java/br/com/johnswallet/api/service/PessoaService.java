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

    private static final String REGEX_NUMERO_TELEFONE = "[^0-9+]";

    @Override
    protected JpaRepository<Pessoa, UUID> getRepository() {
        return repository;
    }

    @Override
    protected void beforeSave(Pessoa entity) {
        beforeSaveAndUpdate(entity);
        super.beforeSave(entity);
    }

    @Override
    protected void beforeUpdate(Pessoa entity) {
        beforeSaveAndUpdate(entity);
        super.beforeUpdate(entity);
    }

    protected void beforeSaveAndUpdate(Pessoa entity) {
        String telefone = entity.getTelefone();
        telefone = telefone.replaceAll(REGEX_NUMERO_TELEFONE, "");
        entity.setTelefone(telefone);
    }

}

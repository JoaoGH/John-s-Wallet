package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.FormaPagamento;
import br.com.johnswallet.api.repository.FormaPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormaPagamentoService extends DefaultCrudService<FormaPagamento, UUID> {

    protected final FormaPagamentoRepository repository;

    @Override
    protected JpaRepository<FormaPagamento, UUID> getRepository() {
        return repository;
    }

}

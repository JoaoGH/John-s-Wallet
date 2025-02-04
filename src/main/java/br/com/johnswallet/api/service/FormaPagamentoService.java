package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FormaPagamentoService extends DefaultCrudService<FormaPagamento, UUID> {

    protected FormaPagamentoService(JpaRepository<FormaPagamento, UUID> repository) {
        super(repository);
    }

}

package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Compra;
import br.com.johnswallet.api.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompraService extends DefaultCrudService<Compra, UUID> {

    protected CompraService(CompraRepository repository) {
        super(repository);
    }

}

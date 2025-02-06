package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Compra;
import br.com.johnswallet.api.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompraService extends DefaultCrudService<Compra, UUID> {

    private final CompraRepository repository;

    @Override
    protected JpaRepository<Compra, UUID> getRepository() {
        return repository;
    }

}

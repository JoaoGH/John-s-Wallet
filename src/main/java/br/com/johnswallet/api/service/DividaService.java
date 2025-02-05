package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Divida;
import br.com.johnswallet.api.repository.DividaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DividaService extends DefaultCrudService<Divida, UUID> {

    protected final DividaRepository repository;

    @Override
    protected JpaRepository<Divida, UUID> getRepository() {
        return repository;
    }

}

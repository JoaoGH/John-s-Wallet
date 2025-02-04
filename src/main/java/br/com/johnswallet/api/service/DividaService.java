package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DividaService extends DefaultCrudService<Divida, UUID> {

    protected DividaService(JpaRepository<Divida, UUID> repository) {
        super(repository);
    }

}

package br.com.johnswallet.api.service;

import br.com.johnswallet.api.entity.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemCompraService extends DefaultCrudService<ItemCompra, UUID> {

    protected ItemCompraService(JpaRepository<ItemCompra, UUID> repository) {
        super(repository);
    }

}

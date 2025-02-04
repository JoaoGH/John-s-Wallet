package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.ItemCompra;
import br.com.johnswallet.api.service.DefaultCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/item-compra")
public class ItemCompraController extends DefaultCrudController<ItemCompra, UUID> {

    protected ItemCompraController(DefaultCrudService<ItemCompra, UUID> service) {
        super(service);
    }

}

package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Divida;
import br.com.johnswallet.api.service.DefaultCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/divida")
public class DividaController extends DefaultCrudController<Divida, UUID> {

    protected DividaController(DefaultCrudService<Divida, UUID> service) {
        super(service);
    }

}

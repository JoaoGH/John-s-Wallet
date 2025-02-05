package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Divida;
import br.com.johnswallet.api.service.DefaultCrudService;
import br.com.johnswallet.api.service.DividaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/divida")
@RequiredArgsConstructor
public class DividaController extends DefaultCrudController<Divida, UUID> {

    protected final DividaService service;

    @Override
    protected DefaultCrudService<Divida, UUID> getService() {
        return service;
    }
}

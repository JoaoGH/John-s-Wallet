package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Compra;
import br.com.johnswallet.api.service.CompraService;
import br.com.johnswallet.api.service.DefaultCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController extends DefaultCrudController<Compra, UUID> {

    protected final CompraService service;

    @Override
    protected DefaultCrudService<Compra, UUID> getService() {
        return service;
    }

}

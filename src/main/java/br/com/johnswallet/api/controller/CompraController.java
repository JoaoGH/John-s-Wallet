package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Compra;
import br.com.johnswallet.api.service.CompraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/compra")
public class CompraController extends DefaultCrudController<Compra, UUID> {

    protected CompraController(CompraService service) {
        super(service);
    }

}

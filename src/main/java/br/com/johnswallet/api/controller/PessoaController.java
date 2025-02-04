package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Pessoa;
import br.com.johnswallet.api.service.PessoaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends DefaultCrudController<Pessoa, UUID> {

    protected PessoaController(PessoaService service) {
        super(service);
    }

}

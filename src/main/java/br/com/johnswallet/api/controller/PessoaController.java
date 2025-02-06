package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Pessoa;
import br.com.johnswallet.api.service.DefaultCrudService;
import br.com.johnswallet.api.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController extends DefaultCrudController<Pessoa, UUID> {

    protected final PessoaService service;

    @Override
    protected DefaultCrudService<Pessoa, UUID> getService() {
        return service;
    }
}

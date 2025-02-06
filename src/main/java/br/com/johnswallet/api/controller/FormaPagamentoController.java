package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.FormaPagamento;
import br.com.johnswallet.api.service.DefaultCrudService;
import br.com.johnswallet.api.service.FormaPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/forma-pagamento")
@RequiredArgsConstructor
public class FormaPagamentoController extends DefaultCrudController<FormaPagamento, UUID> {

    protected final FormaPagamentoService service;

    @Override
    protected DefaultCrudService<FormaPagamento, UUID> getService() {
        return service;
    }
}

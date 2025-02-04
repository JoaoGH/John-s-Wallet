package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.FormaPagamento;
import br.com.johnswallet.api.service.DefaultCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/forma-pagamento")
public class FormaPagamentoController extends DefaultCrudController<FormaPagamento, UUID> {

    protected FormaPagamentoController(DefaultCrudService<FormaPagamento, UUID> service) {
        super(service);
    }

}

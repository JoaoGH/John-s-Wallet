package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Usuario;
import br.com.johnswallet.api.service.DefaultCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends DefaultCrudController<Usuario, UUID> {

    protected UsuarioController(DefaultCrudService<Usuario, UUID> service) {
        super(service);
    }

}

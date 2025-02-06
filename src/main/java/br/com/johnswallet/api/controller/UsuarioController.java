package br.com.johnswallet.api.controller;

import br.com.johnswallet.api.entity.Usuario;
import br.com.johnswallet.api.service.DefaultCrudService;
import br.com.johnswallet.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController extends DefaultCrudController<Usuario, UUID> {

    protected final UsuarioService service;

    @Override
    protected DefaultCrudService<Usuario, UUID> getService() {
        return service;
    }
}

package com.manumarcos.lanceFree.Controller;


import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.PostUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;
import com.manumarcos.lanceFree.Service.IClienteService;
import com.manumarcos.lanceFree.Service.IUsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<GetUsuarioDto>> getAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    


}

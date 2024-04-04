package com.manumarcos.lanceFree.Controller;


import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.Dto.GetUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.PostUsuarioDto;
import com.manumarcos.lanceFree.Service.Dto.UsuarioDto;
import com.manumarcos.lanceFree.Service.IClienteService;
import com.manumarcos.lanceFree.Service.IUsuarioService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<GetUsuarioDto>> getAll(@RequestParam(required = false) String role){
        if(role == null){
            return ResponseEntity.ok(usuarioService.findAll());
        }
        else {
            return ResponseEntity.ok(usuarioService.findAllByRole(role));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUsuarioDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

}

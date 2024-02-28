package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.ComentarioDto;
import com.manumarcos.lanceFree.Service.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    @GetMapping
    public List<ComentarioDto> getAll(){
        return comentarioService.findAll();
    }

    @GetMapping("/cliente/{clienteId}/servicio/{servicioId}")
    public ResponseEntity<ComentarioDto> getById(@PathVariable Long clienteId, @PathVariable Long servicioId){
        return ResponseEntity.ok(comentarioService.findById(clienteId, servicioId));
    }

    @PostMapping
    public ResponseEntity<ComentarioDto> newComentario(@RequestBody ComentarioDto comentarioDto){
        return new ResponseEntity<>(comentarioService.save(comentarioDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/cliente/{clienteId}/servicio/{servicioId}")
    public ResponseEntity<String> deleteComentario(@PathVariable Long clienteId, @PathVariable Long servicioId){
        comentarioService.deleteById(clienteId, servicioId);
        String mensaje = "Comentario eliminado correctamente";
        return ResponseEntity.ok(mensaje);
    }




}

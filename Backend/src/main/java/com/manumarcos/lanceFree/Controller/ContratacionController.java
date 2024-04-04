package com.manumarcos.lanceFree.Controller;


import com.manumarcos.lanceFree.Model.Entity.Contratacion;
import com.manumarcos.lanceFree.Service.Dto.ContratacionDto;
import com.manumarcos.lanceFree.Service.IContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrataciones")
public class ContratacionController {

    @Autowired
    private IContratacionService contratacionService;

    @GetMapping
    public ResponseEntity<List<ContratacionDto>> getAll(){
        return ResponseEntity.ok(contratacionService.findAll());
    }

    @GetMapping("/cliente/{clienteId}/servicio/{servicioId}")
    public ResponseEntity<ContratacionDto> getById(@PathVariable Long clienteId, @PathVariable Long servicioId){
        return ResponseEntity.ok(contratacionService.findById(clienteId, servicioId));
    }

    @PostMapping
    public ResponseEntity<ContratacionDto> newContratacion(@RequestBody ContratacionDto contratacionDto){
        return new ResponseEntity<>(contratacionService.save(contratacionDto), HttpStatus.CREATED);
    }

    @PutMapping("/cliente/{clienteId}/servicio/{servicioId}")
    public ResponseEntity<ContratacionDto> updateContratacion(@PathVariable Long clienteId, @PathVariable Long servicioId, @RequestBody ContratacionDto contratacionDto){
        return ResponseEntity.ok(contratacionService.update(clienteId, servicioId, contratacionDto));
    }

    @DeleteMapping("/cliente/{clienteId}/servicio/{servicioId}")
    public ResponseEntity<String> deleteContratacion(@PathVariable Long clienteId, @PathVariable Long servicioId){
        contratacionService.deleteById(clienteId, servicioId);
        String mensaje = "Contratacion eliminada correctamente";
        return ResponseEntity.ok(mensaje);
    }



}

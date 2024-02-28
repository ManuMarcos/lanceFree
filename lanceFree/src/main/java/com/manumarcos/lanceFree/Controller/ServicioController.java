package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.ServicioDto;
import com.manumarcos.lanceFree.Service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<ServicioDto>> getAll(){
        return ResponseEntity.ok(servicioService.findAll());
    }

    @GetMapping("/{servicioId}")
    public ResponseEntity<ServicioDto> getById(@PathVariable Long servicioId){
        return ResponseEntity.ok(servicioService.findById(servicioId));
    }

    @PostMapping
    public ResponseEntity<ServicioDto> newServicio(@RequestBody ServicioDto servicioDto){
        return new ResponseEntity<>(servicioService.save(servicioDto), HttpStatus.CREATED);
    }

    @PutMapping("/{servicioId}")
    public ResponseEntity<ServicioDto> updateServicio(@PathVariable Long servicioId, @RequestBody ServicioDto servicioDto){
        return ResponseEntity.ok(servicioService.update(servicioId, servicioDto));
    }

    @DeleteMapping("/{servicioId}")
    public ResponseEntity<String> deleteServicio(@PathVariable Long servicioId){
        servicioService.deleteById(servicioId);
        String mensaje = String.format("Servicio con id: %d eliminado correctamente");
        return ResponseEntity.ok(mensaje);
    }


}

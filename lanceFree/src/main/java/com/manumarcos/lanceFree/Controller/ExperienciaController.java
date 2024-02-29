package com.manumarcos.lanceFree.Controller;


import com.manumarcos.lanceFree.Service.Dto.ExperienciaDto;
import com.manumarcos.lanceFree.Service.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping
    private ResponseEntity<List<ExperienciaDto>> getAll(){
        return ResponseEntity.ok(experienciaService.findAll());
    }

    @GetMapping("/{experienciaId}")
    private ResponseEntity<ExperienciaDto> getById(@PathVariable Long experienciaId){
        return ResponseEntity.ok(experienciaService.findById(experienciaId));
    }

    @PostMapping
    private ResponseEntity<ExperienciaDto> newExperiencia(@RequestBody ExperienciaDto experienciaDto){
        return new ResponseEntity<>(experienciaService.save(experienciaDto), HttpStatus.CREATED);
    }

    @PutMapping("/{experienciaId}")
    private ResponseEntity<ExperienciaDto> updateExperiencia(@PathVariable Long experienciaId
            , @RequestBody ExperienciaDto experienciaDto){
        return ResponseEntity.ok(experienciaService.update(experienciaId, experienciaDto));
    }

    @DeleteMapping("/{experienciaId}")
    private ResponseEntity<String> deleteById(@PathVariable Long experienciaId){
        experienciaService.deleteById(experienciaId);
        String mensaje = String.format("Experiencia con id: %d eliminada correctamente", experienciaId);
        return ResponseEntity.ok(mensaje);
    }


}

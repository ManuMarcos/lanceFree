package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.CategoriaDto;
import com.manumarcos.lanceFree.Service.ICategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDto> getAll(){
        return categoriaService.findAll();
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDto> getById(@PathVariable Long categoriaId){
        return ResponseEntity.ok(categoriaService.findById(categoriaId));
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> newCategoria(@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(categoriaService.save(categoriaDto), HttpStatus.CREATED);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDto> updateCategoria(@PathVariable Long categoriaId,@RequestBody CategoriaDto categoriaDto){
        return ResponseEntity.ok(categoriaService.update(categoriaId, categoriaDto));
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long categoriaId){
        categoriaService.deleteById(categoriaId);
        String mensaje = "Categoria con id: " + categoriaId + " eliminado correctamente";
        return ResponseEntity.ok(mensaje);
    }

}

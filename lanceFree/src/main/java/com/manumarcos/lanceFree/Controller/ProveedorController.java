package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.ProveedorDto;
import com.manumarcos.lanceFree.Service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorDto>> getAll(){
        return ResponseEntity.ok(proveedorService.findAll());
    }

    @GetMapping("/{proveedorId}")
    public ResponseEntity<ProveedorDto> getById(@PathVariable Long proveedorId){
        return ResponseEntity.ok(proveedorService.findById(proveedorId));
    }

    @PostMapping
    public ResponseEntity<ProveedorDto> newProveedor(ProveedorDto proveedorDto){
        return new ResponseEntity<>(proveedorService.save(proveedorDto), HttpStatus.CREATED);
    }

    @PutMapping("/{proveedorId}")
    public ResponseEntity<ProveedorDto> updateProveedor(@PathVariable Long proveedorId, @RequestBody ProveedorDto proveedorDto){
        return ResponseEntity.ok(proveedorService.update(proveedorId, proveedorDto));
    }

    @DeleteMapping("/{proveedorId}")
    public ResponseEntity<String> deleteProveedor(@PathVariable Long proveedorId){
        proveedorService.deleteById(proveedorId);
        String mensaje = String.format("Proveedor con id: %d eliminado correctamente", proveedorId);
        return ResponseEntity.ok(mensaje);
    }

}

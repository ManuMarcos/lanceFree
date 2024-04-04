package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<ClienteDto> getAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Long clienteId){
        return ResponseEntity.ok(clienteService.findById(clienteId));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> newCliente(@RequestBody ClienteDto clienteDto){
        return new ResponseEntity<>(clienteService.save(clienteDto), HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable Long clienteId, @RequestBody ClienteDto clienteDto){
        return ResponseEntity.ok(clienteService.update(clienteId, clienteDto));
    }
     */

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long clienteId){
        clienteService.deleteById(clienteId);
        String mensaje = "Cliente con id: " + clienteId + " eliminado correctamente";
        return ResponseEntity.ok(mensaje);
    }


}

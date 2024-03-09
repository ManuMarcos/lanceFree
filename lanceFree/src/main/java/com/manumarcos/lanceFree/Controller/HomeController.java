package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.Dto.SignUpRequestDto;
import com.manumarcos.lanceFree.Service.IClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/signup/cliente")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto){
        clienteService.save(signUpRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}

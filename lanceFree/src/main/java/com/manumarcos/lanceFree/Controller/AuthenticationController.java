package com.manumarcos.lanceFree.Controller;

import com.manumarcos.lanceFree.Service.Dto.Login.LoginRequestDto;
import com.manumarcos.lanceFree.Service.Dto.Login.LoginResponseDto;
import com.manumarcos.lanceFree.Service.Dto.SignUp.SignUpRequestDto;
import com.manumarcos.lanceFree.Service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDto> signUp(
            @RequestBody SignUpRequestDto signUpRequestDto
    ){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto loginRequestDto
    ){
        return ResponseEntity.ok(authenticationService.login(loginRequestDto));
    }

}

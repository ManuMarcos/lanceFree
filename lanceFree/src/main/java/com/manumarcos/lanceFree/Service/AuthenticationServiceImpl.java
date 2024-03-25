package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Dao.IUsuarioDao;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import com.manumarcos.lanceFree.Service.Dto.Login.LoginRequestDto;
import com.manumarcos.lanceFree.Service.Dto.Login.LoginResponseDto;
import com.manumarcos.lanceFree.Service.Dto.SignUp.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public LoginResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        var usuario = new Usuario(
                signUpRequestDto.getEmail()
                ,passwordEncoder.encode(signUpRequestDto.getPassword())
                ,Set.of(roleDao.findRoleByRoleAuthority(signUpRequestDto.getRole())));
        usuarioDao.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return LoginResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );
        var usuario = usuarioDao.findUsuarioByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new ItemNotFoundException("El usuario no existe"));
        var jwtToken = jwtService.generateToken(usuario);
        return LoginResponseDto.builder()
                .token(jwtToken)
                .build();
    }
}

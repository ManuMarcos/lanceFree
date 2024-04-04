package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Service.Dto.Login.LoginRequestDto;
import com.manumarcos.lanceFree.Service.Dto.Login.LoginResponseDto;
import com.manumarcos.lanceFree.Service.Dto.SignUp.SignUpRequestDto;

public interface IAuthenticationService {

    LoginResponseDto signUp(SignUpRequestDto signUpRequestDto);

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}

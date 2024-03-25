package com.manumarcos.lanceFree.Service.Dto.SignUp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {

    @Email(message = "Formato de email invalido")
    @NotBlank(message = "El email no puede estar en blanco")
    private String email;
    @NotBlank(message = "La contraseña no puede estar en blanco")
    @Size(min = 6, max = 20, message = "La contraseña debe contener entre 6 y 20 caracteres")
    private String password;
    private String role;
}

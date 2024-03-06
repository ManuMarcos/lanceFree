package com.manumarcos.lanceFree.Service.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequestDto(
        @NotBlank(message = "El nombre no puede estar en blanco")
        String nombre,

        @NotBlank(message = "El apellido no puede estar en blanco")
        String apellido,

        @Email(message = "Formato de email invalido")
        @NotBlank(message = "El email no puede estar en blanco")
        String email,
        @NotBlank(message = "La contraseña no puede estar en blanco")
        @Size(min = 6, max = 20, message = "La contraseña debe contener entre 6 y 20 caracteres")
        String password

) {





}

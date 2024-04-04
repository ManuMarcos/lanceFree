package com.manumarcos.lanceFree.Service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUsuarioDto {

    private String email;
    private String contrasena;
    private String rol;

}

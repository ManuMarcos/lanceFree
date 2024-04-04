package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String email;
    private String contrasena;

}

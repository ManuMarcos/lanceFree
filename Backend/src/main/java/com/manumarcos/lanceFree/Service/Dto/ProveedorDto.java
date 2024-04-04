package com.manumarcos.lanceFree.Service.Dto;

import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDto{

    private Long id;
    private UsuarioDto usuario;
    private String titulo;



}

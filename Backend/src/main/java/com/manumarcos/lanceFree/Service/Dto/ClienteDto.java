package com.manumarcos.lanceFree.Service.Dto;


import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Model.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto{

    private Long id;
    private UsuarioDto usuario;
    private String horarioContacto;
}

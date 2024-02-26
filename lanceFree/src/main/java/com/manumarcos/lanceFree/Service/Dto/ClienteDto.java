package com.manumarcos.lanceFree.Service.Dto;


import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Model.Entity.Usuario;

public class ClienteDto extends UsuarioDto{

    private String horarioContacto;

    public ClienteDto(Long id, String nombre, String apellido, String email, String telefono, String horarioContacto) {
        super(id, nombre, apellido, email, telefono);
        this.horarioContacto = horarioContacto;
    }

    public ClienteDto(Cliente cliente) {
        super(cliente);
        this.horarioContacto = cliente.getHorarioContacto();
    }

    public String getHorarioContacto() {
        return horarioContacto;
    }

    public void setHorarioContacto(String horarioContacto) {
        this.horarioContacto = horarioContacto;
    }
}

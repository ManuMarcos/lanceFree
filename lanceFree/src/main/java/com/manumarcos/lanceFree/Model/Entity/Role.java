package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity(name = "rol")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @NotNull(message = "No puede estar vacio")
    @Size(min = 4, max = 10, message = "Debe contener entre 4 y 10 caracteres")
    private String roleAuthority;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;


    public Role(String roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(String roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

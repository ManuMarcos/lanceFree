package com.manumarcos.lanceFree.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "No puede estar vacio")
    @Email(message = "Email invalido")
    @Column(unique = true)
    private String email;
    @NotNull(message = "No puede estar vacio")
    @Size(min = 6, message = "Debe contener un minimo de 6 caracteres")
    private String contrasena;

    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;
    @OneToOne(mappedBy = "usuario")
    private Proveedor proveedor;

    @CreatedDate
    private Date createdAt;

    @ManyToMany
    @JoinTable(
            name = "rol_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Role> roles;

    public Usuario(String email, String contrasena, Set<Role> roles) {
        this.email = email;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = new ArrayList<GrantedAuthority>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleAuthority())) );
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

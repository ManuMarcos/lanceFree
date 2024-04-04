package com.manumarcos.lanceFree.Model.Dao;

import com.manumarcos.lanceFree.Model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Long> {

    Role findRoleByRoleAuthority(String roleAuthority);
    boolean existsByRoleAuthority(String roleAuthority);
}

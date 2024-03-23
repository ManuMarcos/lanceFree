package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.InvalidValueException;
import com.manumarcos.lanceFree.Model.Dao.IRoleDao;
import com.manumarcos.lanceFree.Model.Entity.Role;
import com.manumarcos.lanceFree.Service.Dto.RoleDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleDao roleDao;


    @Override
    public List<RoleDto> findAll() {
        return roleDao.findAll().stream()
                .map(role -> new RoleDto(role.getIdRole(), role.getRoleAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        if(roleDao.existsByRoleAuthority(roleDto.getRoleAuthority())){
            throw new InvalidValueException("El role ingresado ya existe. Ingrese un nuevo role");
        }
        Role role = roleDao.save(new Role(roleDto.getRoleAuthority()));
        return new RoleDto(role.getIdRole(),role.getRoleAuthority());
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto roleDto) {
        //TODO:Falta implementar
        return null;
    }


    @Override
    public void delete(Long id) {
        roleDao.deleteById(id);
    }
}

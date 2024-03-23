package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Service.Dto.RoleDto;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface IRoleService {

    List<RoleDto> findAll();
    RoleDto save(RoleDto roleDto) throws BadRequestException;
    RoleDto updateRole(Long id, RoleDto roleDto);
    void delete(Long id);
}

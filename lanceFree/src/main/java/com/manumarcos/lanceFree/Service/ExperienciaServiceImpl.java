package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IExperienciaDao;
import com.manumarcos.lanceFree.Model.Dao.IProveedorDao;
import com.manumarcos.lanceFree.Model.Entity.Experiencia;
import com.manumarcos.lanceFree.Model.Entity.Proveedor;
import com.manumarcos.lanceFree.Service.Dto.ExperienciaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienciaServiceImpl implements IExperienciaService{

    @Autowired
    private IExperienciaDao experienciaDao;

    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    public List<ExperienciaDto> findAll() {
        List<Experiencia> experiencias = experienciaDao.findAll();
        List<ExperienciaDto> experienciaDtos = new ArrayList<>();
        for(Experiencia experiencia : experiencias){
            experienciaDtos.add(new ExperienciaDto(experiencia));
        }
        return experienciaDtos;
    }

    @Override
    public ExperienciaDto findById(Long id) {
        Experiencia experiencia = this.getExperiencia(id);
        return new ExperienciaDto(experiencia);
    }

    @Override
    public ExperienciaDto save(ExperienciaDto experienciaDto) {
        Proveedor proveedor = this.getProveedor(experienciaDto.getProveedorId());
        Experiencia experiencia = new Experiencia(experienciaDto.getFechaDesde(), experienciaDto.getFechaHasta(),
                experienciaDto.getDescripcion(),proveedor);
        return new ExperienciaDto(experienciaDao.save(experiencia));
    }

    @Override
    public ExperienciaDto update(Long id, ExperienciaDto experienciaDto) {
        Experiencia experienciaToUpdate = this.getExperiencia(id);

        experienciaToUpdate.setDescripcion(experienciaDto.getDescripcion());
        experienciaToUpdate.setFechaDesde(experienciaDto.getFechaDesde());
        experienciaToUpdate.setFechaHasta(experienciaDto.getFechaHasta());

        return new ExperienciaDto(experienciaDao.update(experienciaToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        if(this.getExperiencia(id) != null){
            experienciaDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("La experiencia con id %d no existe", id));
        }
    }
    private Experiencia getExperiencia(Long id){
        return experienciaDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("La experiencia con id %d no existe", id)));
    }

    private Proveedor getProveedor(Long id){
        return proveedorDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El proveedor con id: %d no existe", id)));
    }
}

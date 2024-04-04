package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.ContratacionDaoImpl;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Dao.IContratacionDao;
import com.manumarcos.lanceFree.Model.Dao.IServicioDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Model.Entity.Contratacion;
import com.manumarcos.lanceFree.Model.Entity.ContratacionKey;
import com.manumarcos.lanceFree.Model.Entity.Servicio;
import com.manumarcos.lanceFree.Model.Enums.EstadoContratacion;
import com.manumarcos.lanceFree.Service.Dto.ContratacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratacionServiceImpl implements IContratacionService{

    @Autowired
    private IContratacionDao contratacionDao;
    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IServicioDao servicioDao;



    @Override
    public List<ContratacionDto> findAll() {
        List<Contratacion> contrataciones = contratacionDao.findAll();
        List<ContratacionDto> contratacionesDto = new ArrayList<>();

        for (Contratacion contratacion : contrataciones){
            contratacionesDto.add(new ContratacionDto(contratacion));
        }
        return contratacionesDto;
    }

    @Override
    public ContratacionDto findById(Long clienteId, Long servicioId) {
        return new ContratacionDto(this.getContratacion(servicioId, clienteId));
    }

    @Override
    public ContratacionDto save(ContratacionDto contratacionDto) {
        Cliente cliente = this.getCliente(contratacionDto.getClienteId());
        Servicio servicio = this.getServicio(contratacionDto.getServicioId());
        Contratacion contratacion = new Contratacion(EstadoContratacion.findByName(contratacionDto.getEstado()), contratacionDto.getMotivo(),cliente, servicio);
        return new ContratacionDto(contratacionDao.save(contratacion));
    }

    @Override
    public ContratacionDto update(Long clienteId, Long servicioId, ContratacionDto contratacionDto) {
        Contratacion contratacionToUpdate = this.getContratacion(servicioId, clienteId);

        contratacionToUpdate.setEstado(contratacionToUpdate.getEstado());
        contratacionToUpdate.setMotivo(contratacionToUpdate.getMotivo());

        return new ContratacionDto(contratacionDao.update(contratacionToUpdate));
    }

    @Override
    public void deleteById(Long clienteId, Long servicioId) {
        if(this.getContratacion(servicioId, clienteId) != null){
            contratacionDao.deleteById(new ContratacionKey(clienteId, servicioId));
        }
    }

    private Cliente getCliente(Long id){
        return clienteDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El cliente con id: %d no existe", id)));
    }

    private Servicio getServicio(Long id){
        return servicioDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El servicio con id: %d no existe", id)));
    }

    private Contratacion getContratacion(Long servicioId, Long clienteId){
        Cliente cliente = this.getCliente(clienteId);
        Servicio servicio = this.getServicio(servicioId);
        return contratacionDao.findById(new ContratacionKey(cliente.getId(), servicio.getId()))
                .orElseThrow(() -> new ItemNotFoundException(String.format("No existe una contratacion del cliente con id: %d al servicio con id: %d",clienteId, servicioId )));
    }


}

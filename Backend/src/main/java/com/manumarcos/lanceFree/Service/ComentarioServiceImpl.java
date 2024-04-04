package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IClienteDao;
import com.manumarcos.lanceFree.Model.Dao.IComentarioDao;
import com.manumarcos.lanceFree.Model.Dao.IServicioDao;
import com.manumarcos.lanceFree.Model.Entity.Cliente;
import com.manumarcos.lanceFree.Model.Entity.Comentario;
import com.manumarcos.lanceFree.Model.Entity.ComentarioKey;
import com.manumarcos.lanceFree.Model.Entity.Servicio;
import com.manumarcos.lanceFree.Service.Dto.ClienteDto;
import com.manumarcos.lanceFree.Service.Dto.ComentarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComentarioServiceImpl implements IComentarioService{

    @Autowired
    private IComentarioDao comentarioDao;

    @Autowired
    private IServicioDao servicioDao;

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<ComentarioDto> findAll() {
        List<Comentario> comentarios = comentarioDao.findAll();
        List<ComentarioDto> comentarioDtos = new ArrayList<>();

        for(Comentario comentario : comentarios){
            comentarioDtos.add(new ComentarioDto(comentario));
        }
        return comentarioDtos;
    }
    @Override
    public ComentarioDto findById(Long clienteId, Long servicioId) {
        Comentario comentario = this.getComentario(clienteId, servicioId);
        return new ComentarioDto(comentario);
    }

    @Override
    public ComentarioDto save(ComentarioDto comentarioDto) {
        Cliente cliente = this.getCliente(comentarioDto.getClienteId());
        Servicio servicio = this.getServicio(comentarioDto.getServicioId());
        Comentario comentario = new Comentario(new ComentarioKey(comentarioDto.getServicioId(), comentarioDto.getClienteId()), comentarioDto.getFecha(),
                comentarioDto.getMensaje(), comentarioDto.getEstado(), comentarioDto.getPuntaje(), cliente, servicio);
        return new ComentarioDto(comentarioDao.save(comentario));
    }

    @Override
    public ComentarioDto update(Long clienteId,Long servicioId, ComentarioDto comentarioDto) {
        Comentario comentarioToUpdate = this.getComentario(clienteId, servicioId);

        comentarioToUpdate.setEstado(comentarioDto.getEstado());
        comentarioToUpdate.setMensaje(comentarioDto.getMensaje());
        comentarioToUpdate.setFecha(comentarioDto.getFecha());
        comentarioToUpdate.setPuntaje(comentarioDto.getPuntaje());

        return new ComentarioDto(comentarioDao.update(comentarioToUpdate));
    }

    @Override
    public void deleteById(Long clienteId, Long servicioId) {
        if(this.getComentario(clienteId,servicioId) != null){
            comentarioDao.deleteById(new ComentarioKey(clienteId, servicioId));
        }
    }

    private Comentario getComentario(Long clienteId, Long servicioId){
        Servicio servicio = this.getServicio(servicioId);
        Cliente cliente =   this.getCliente(clienteId);

        Comentario comentario = comentarioDao.findById(new ComentarioKey(servicio.getId(), cliente.getId()))
                .orElseThrow(() -> new ItemNotFoundException(String.format("No existe un comentario del cliente con id: %d en el servicio con id: %d", clienteId, servicioId)));

        return comentario;
    }

    private Servicio getServicio(Long id){
        Servicio servicio = servicioDao.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.format("El servicio con id: %d no existe", id)));
        return servicio;
    }

    private Cliente getCliente(Long id){
        Cliente cliente = clienteDao.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.format("El cliente con id: %d no existe", id)));
        return cliente;
    }

}

package com.manumarcos.lanceFree.Service;

import com.manumarcos.lanceFree.Exception.Exceptions.ItemNotFoundException;
import com.manumarcos.lanceFree.Model.Dao.IComentarioDao;
import com.manumarcos.lanceFree.Model.Entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements IComentarioService{

    @Autowired
    private IComentarioDao comentarioDao;

    @Override
    public List<Comentario> findAll() {
        return comentarioDao.findAll();
    }
    @Override
    public Comentario findById(Long id) {
        return comentarioDao.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("El comentario con el id %d no existe", id)));
    }

    @Override
    public Comentario save(Comentario comentario) {
        return comentarioDao.save(comentario);
    }

    @Override
    public Comentario update(Long id, Comentario comentario) {
        Comentario comentarioToUpdate = this.findById(id);

        comentarioToUpdate.setCliente(comentario.getCliente());
        comentarioToUpdate.setEstado(comentario.getEstado());
        comentarioToUpdate.setMensaje(comentario.getMensaje());
        comentarioToUpdate.setServicio(comentario.getServicio());
        comentarioToUpdate.setFecha(comentario.getFecha());
        comentarioToUpdate.setPuntaje(comentario.getPuntaje());

        return comentarioDao.update(comentarioToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(comentarioDao.findById(id).isPresent()){
            comentarioDao.deleteById(id);
        }
        else{
            throw new ItemNotFoundException(String.format("El comentario con id %d no existe", id));
        }
    }
}

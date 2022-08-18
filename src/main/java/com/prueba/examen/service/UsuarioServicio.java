//DAO se comunica con la BD
package com.prueba.examen.service;

import com.prueba.examen.models.Usuario;
import com.prueba.examen.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//registre contenedor de servicio
public class UsuarioServicio {
    @Autowired//para inyectar el repositorio
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listAll(String buscarPalabra){ //Listamos los usuarios
        if (buscarPalabra != null){ //si en buscar NO esta vacio
            return usuarioRepositorio.findAll(buscarPalabra);
        }
        return usuarioRepositorio.findAll(); //metodo
    }

    public void save(Usuario usuario){ //guardamos en BD
        usuarioRepositorio.save(usuario); //meodo guardar
    }

    public Usuario get(Long id){ //obtener un usuario por id
        return usuarioRepositorio.findById(id).get();
    }

    public void delete(Long id){ //eliminamos de la BD por id
        usuarioRepositorio.deleteById(id); //metodo eliminar por id, no devuelve nada
    }
}

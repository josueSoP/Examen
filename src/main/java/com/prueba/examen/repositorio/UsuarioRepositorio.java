package com.prueba.examen.repositorio;

import com.prueba.examen.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Query ("SELECT u FROM Usuario u WHERE u.telefono LIKE %?1%" //opcion LIKE para frase
            + "OR  u.nombre LIKE %?1%"
            + "OR  u.apellidoPaterno LIKE %?1%"
            + "OR  u.apellidoMaterno LIKE %?1%"
            + "OR  u.email LIKE %?1%")
    /*
    @Query ("SELECT u FROM Usuario u WHERE u.telefono LIKE %?1%") //para buscar num de telefono

    @Query ("SELECT u FROM Usuario u WHERE CONCAT (u.id,u.nombre,u.apellidoPaterno,u.apellidoMaterno,u.telefono,p.email)" +
            " LIKE %?1%") // consulta forma reducida*/
    public List<Usuario> findAll(String buscarPalabra);
}

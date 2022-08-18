package com.prueba.examen.controller;

import com.prueba.examen.models.Usuario;
import com.prueba.examen.service.UsuarioServicio;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //controlador para gestionar las rutas
public class UsuarioController {
    @Autowired //inyectamos el servicio
    private UsuarioServicio usuarioServicio;

    @RequestMapping("/") //ruta GET usuarios
    public String home(Model modelo, @Param("buscarPalabra") String buscarPalabra){
        //listamos usuarios
        List<Usuario> listaUsuarios = usuarioServicio.listAll(buscarPalabra); //en esa lista obtenemos los usuarios de la BD del metodo listAll
        modelo.addAttribute("listaUsuarios",listaUsuarios); //podamos acceder a esa lista mendiante el nombre listaProductos
        modelo.addAttribute("buscarPalabra",buscarPalabra);
        return "index.html";//retornamos el archivo html
    }

    @RequestMapping("/nuevoUsuario")            //ruta al formulario nuevoUsuario GET
    public String newUsuario(Model modelo){   //modelo para plantilla nuevo usuario
        Usuario usuario = new Usuario();        //pasamos instanciapara enlaarlo en html
        modelo.addAttribute("usuario", usuario); //podamos acceder a usuario del html mendiante el nombre usuario(verde)
        return "nuevoUsuario.html";        //retornamos el archivo html
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST) //ruta para guardar formulario nuevoUsuario
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario){   //modelo para plantilla nuevo usuario
        usuarioServicio.save(usuario);
        return "redirect:/";
    }

    @RequestMapping("/editarUsuario/{id}")            //
    public ModelAndView editUsuario(@PathVariable(name = "id") Long id) {   //
        ModelAndView modelo = new ModelAndView("editarUsuario.html");

        Usuario usuario = usuarioServicio.get(id);
        modelo.addObject("usuario", usuario);

        return modelo;
    }

    @RequestMapping("/eliminarUsuario/{id}")            //
    public String eliminarUsuario(@PathVariable(name = "id") Long id) {   //
        usuarioServicio.delete(id);
        return "redirect:/";
    }

}

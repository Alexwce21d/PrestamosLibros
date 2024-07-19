package com.app.web.controlador;

import com.app.web.entidad.Libro;
import com.app.web.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping
    public String listarLibros(Model model) {
        model.addAttribute("libros", libroServicio.obtenerTodosLosLibros());
        return "libros";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "crear_libro";
    }

    @PostMapping
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarLibro(@PathVariable("id") Long id, Model model) {
        Optional<Libro> libro = libroServicio.obtenerLibroPorId(id);
        if (libro.isPresent()) {
            model.addAttribute("libro", libro.get());
            return "editar_libro";
        } else {
            return "redirect:/libros";
        }
    }

    @PostMapping("/{id}")
    public String actualizarLibro(@PathVariable("id") Long id, @ModelAttribute Libro libro) {
        libro.setId(id);
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/{id}")
    public String eliminarLibro(@PathVariable("id") Long id) {
        libroServicio.eliminarLibro(id);
        return "redirect:/libros";
    }
}

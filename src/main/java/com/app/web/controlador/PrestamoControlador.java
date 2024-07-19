package com.app.web.controlador;

import com.app.web.entidad.Prestamo;
import com.app.web.repositorio.EstudianteRepositorio;
import com.app.web.repositorio.LibroRepositorio;
import com.app.web.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prestamos")
public class PrestamoControlador {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @GetMapping
    public String listarPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepositorio.findAll());
        return "prestamos";
    }

    @GetMapping("/nuevo")
    public String nuevoPrestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("estudiantes", estudianteRepositorio.findAll());
        model.addAttribute("libros", libroRepositorio.findAll());
        return "form_prestamo";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
        prestamoRepositorio.save(prestamo);
        return "redirect:/prestamos";
    }

    @GetMapping("/editar/{id}")
    public String editarPrestamoForm(@PathVariable("id") Long id, Model model) {
        Prestamo prestamo = prestamoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con id: " + id));
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("estudiantes", estudianteRepositorio.findAll());
        model.addAttribute("libros", libroRepositorio.findAll());
        return "form_prestamo";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPrestamo(@PathVariable("id") Long id, @ModelAttribute("prestamo") Prestamo prestamo) {
        prestamo.setId(id);
        prestamoRepositorio.save(prestamo);
        return "redirect:/prestamos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable("id") Long id) {
        prestamoRepositorio.deleteById(id);
        return "redirect:/prestamos";
    }
}

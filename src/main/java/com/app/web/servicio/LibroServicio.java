package com.app.web.servicio;

import com.app.web.entidad.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroServicio {
    List<Libro> obtenerTodosLosLibros();
    Optional<Libro> obtenerLibroPorId(Long id);
    Libro guardarLibro(Libro libro);
    void eliminarLibro(Long id);
}
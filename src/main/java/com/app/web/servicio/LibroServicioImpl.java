package com.app.web.servicio;

import com.app.web.entidad.Libro;
import com.app.web.repositorio.LibroRepositorio;
import com.app.web.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicioImpl implements LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepositorio.findById(id);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepositorio.deleteById(id);
    }
}

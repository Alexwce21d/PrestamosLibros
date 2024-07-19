package com.app.web.servicio;

import com.app.web.entidad.Prestamo;
import com.app.web.repositorio.PrestamoRepositorio;
import com.app.web.servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServicioImpl implements PrestamoServicio {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamoRepositorio.findAll();
    }

    @Override
    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepositorio.findById(id);
    }

    @Override
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepositorio.save(prestamo);
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepositorio.deleteById(id);
    }
}

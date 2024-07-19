package com.app.web.servicio;

import com.app.web.entidad.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoServicio {
    List<Prestamo> obtenerTodosLosPrestamos();
    Optional<Prestamo> obtenerPrestamoPorId(Long id);
    Prestamo guardarPrestamo(Prestamo prestamo);
    void eliminarPrestamo(Long id);
}

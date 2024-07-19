
package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.web.entidad.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}

package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.web.entidad.Prestamo;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
}
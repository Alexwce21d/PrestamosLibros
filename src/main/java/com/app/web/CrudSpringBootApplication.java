package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Estudiante;
import com.app.web.entidad.Libro;
import com.app.web.entidad.Prestamo;
import com.app.web.repositorio.EstudianteRepositorio;
import com.app.web.repositorio.LibroRepositorio;
import com.app.web.repositorio.PrestamoRepositorio;

import java.time.LocalDate;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar estudiantes
      /*  Estudiante estudiante1 = new Estudiante("Christian", "Ramirez", "cris20@gmail.com");
        estudianteRepositorio.save(estudiante1);

        Estudiante estudiante2 = new Estudiante("Andre", "Carrillo", "andrecar20@gmail.com");
        estudianteRepositorio.save(estudiante2);

        // Crear y guardar libros
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-0156012195");
        libroRepositorio.save(libro1);

        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728");
        libroRepositorio.save(libro2);

        // Crear y guardar préstamos
        Prestamo prestamo1 = new Prestamo(estudiante1, libro1, LocalDate.now(), LocalDate.now().plusDays(14));
        prestamoRepositorio.save(prestamo1);

        Prestamo prestamo2 = new Prestamo(estudiante2, libro2, LocalDate.now(), LocalDate.now().plusDays(14));
        prestamoRepositorio.save(prestamo2);*/
    }
}

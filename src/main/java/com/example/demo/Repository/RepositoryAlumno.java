package com.example.demo.Repository;

import com.example.demo.Entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAlumno extends CrudRepository<Alumno,Long> {
   // Alumno getByNombreEqualsAndMatriculaAOrApellido(String nombre, Long matricula, String apellido);
}

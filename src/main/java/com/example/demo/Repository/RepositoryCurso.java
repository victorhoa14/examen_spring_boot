package com.example.demo.Repository;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Curso_alumno;
import com.example.demo.Entity.Maestro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCurso extends CrudRepository<Curso,Long> {
    @Query("FROM Curso ")
    public abstract List<Curso> findCursoById_maestro(Maestro Id_maestro);
    @Query("FROM Curso ")
    public abstract Curso findCursoById_curso(Long Id_curso);
}

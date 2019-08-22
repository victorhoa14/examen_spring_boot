package com.example.demo.Repository;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Curso_alumno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCursoAlu extends CrudRepository<Curso_alumno,Long> {
    @Query("FROM Curso_alumno ")
public abstract List<Curso_alumno> findCurso_alumnoById_alumno(Alumno Id_alumno);
    @Query("FROM Curso_alumno ")
    public abstract List<Curso> findCurso_alumnoById_alumno(Long Id_alumno);
    @Query("FROM Curso_alumno ")
    public abstract List<Curso_alumno> findCurso_alumnoById_curso(Curso Id_curso);

}


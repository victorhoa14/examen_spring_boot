package com.example.demo.Service;

import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Maestro;
import com.example.demo.Repository.RepositoryCurso;
import com.example.demo.Repository.RepositoryMaestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCurso {

    @Autowired
    private RepositoryCurso r1;

    @Autowired
    RepositoryCurso a;

    public Curso createcurso(Curso cn) {
                return r1.save(cn);
    }

    public Curso Buscar(Long id_curso) {
        Curso n = r1.findById(id_curso).get();
        return  n;
    }

    public Boolean existecurso(Long id)
    {
        Boolean a=r1.existsById(id);
        return a;
    }


}

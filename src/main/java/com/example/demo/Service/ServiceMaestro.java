package com.example.demo.Service;

import com.example.demo.Controller.ControllerExpediente;
import com.example.demo.Controller.ControllerMaestro;
import com.example.demo.Entity.*;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryCurso;
import com.example.demo.Repository.RepositoryExpediente;
import com.example.demo.Repository.RepositoryMaestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ServiceMaestro {

    @Autowired
    private RepositoryMaestro m;
    @Autowired
    private RepositoryCurso m1;
    @Autowired
    private ServiceCurso sc;

    public Maestro create(Maestro nuevom) {
        return m.save(nuevom);
    }


    public String eliminarmaestro(Long id_maestro) {

        Maestro a=m.findById(id_maestro).get();
        List<Curso> x=m1.findCursoById_maestro(a);

        for(int indice = 0;indice<x.size();indice++)
        {   if (x.get(indice).getId_maestro()==a) {
            Curso n=x.get(indice);
            Curso y=new Curso();
            y.setId_curso(n.getId_curso());
            y.setNombre(n.getNombre());
            System.out.println(n + "------------------------------");
            //n.setId_curso(y.getId_curso());
            sc.createcurso(y);
            //m1.delete(x.get(indice));
        }
        }
        m.delete(a);

        return "Eliminado";
    }

    public Maestro Buscar(Long id_maestro) {
        Maestro n = m.findById(id_maestro).get();
        return  n;
    }
    public Boolean existeprofe(Long id)
    {
        Boolean a=m.existsById(id);
        return a;
    }
}

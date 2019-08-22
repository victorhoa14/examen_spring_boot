package com.example.demo.Service;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso_alumno;
import com.example.demo.Entity.Expediente;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryCursoAlu;
import com.example.demo.Repository.RepositoryExpediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAlumno {

    @Autowired
    private RepositoryExpediente e1;
    @Autowired
    private RepositoryAlumno e2;
    @Autowired
    private RepositoryCursoAlu e3;

    public Alumno buscar(Long id_alumno)
    {
        //Alumno a=e2.findById(id_alumno).get();
        Alumno a=e2.findById(id_alumno).get();
        return a;
    }
    public Boolean existe(Long id_alumno){
        Boolean a=e2.existsById(id_alumno);
        return a;
    }


    public Alumno create1(Alumno alum) {
        return e2.save(alum);
    }

    public Alumno eliminar(Long id_alumno) {

        Alumno a=e2.findById(id_alumno).get();
        List<Curso_alumno> m=e3.findCurso_alumnoById_alumno(a);

        for(int indice = 0;indice<m.size();indice++)
        {
            //Curso_alumno n=m.get(indice);
            //System.out.println(n+"------------------------------");
            e3.delete(m.get(indice));
        }


        //System.out.println(a);
        //e3.delete(m);

        e2.delete(a);
        e1.delete(a.getId_expediente());
        return a;
    }



}

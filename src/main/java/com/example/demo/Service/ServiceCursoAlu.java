package com.example.demo.Service;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Curso_alumno;
import com.example.demo.Entity.Expediente;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryCurso;
import com.example.demo.Repository.RepositoryCursoAlu;
import com.example.demo.Repository.RepositoryExpediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCursoAlu {

    @Autowired
    private RepositoryCurso e1;
    @Autowired
    private RepositoryAlumno e2;
    @Autowired
    private RepositoryCursoAlu e;


    public Curso_alumno create(Curso_alumno a) {
        return e.save(a);
    }


    public List<Curso> cursos(Alumno id_alumno)
    {
        List<Curso_alumno> a=e.findCurso_alumnoById_alumno(id_alumno);
        List<Curso> x=new ArrayList<Curso>();
        for(int indice = 0;indice<a.size();indice++)
        {
            if(a.get(indice).getId_alumno()==id_alumno) {
                Curso_alumno n = a.get(indice);
                //   System.out.println(n);
                //  System.out.println(" ");
                x.add(n.getId_curso());
            }
           //e3.delete(m.get(indice));
        }
        System.out.println(x);
        return x;
    }

    public List<Curso_alumno> cal(Alumno id_alumno)
    {
        List<Curso_alumno> a=e.findCurso_alumnoById_alumno(id_alumno);

        List<Curso_alumno> c=new ArrayList<Curso_alumno>();
        for(int indice = 0;indice<a.size();indice++)
        {
            if(a.get(indice).getId_alumno()==id_alumno)
            {
                c.add(a.get(indice));
            }
        }
        System.out.println("-------------"+c);

        return c;
    }

    public Curso_alumno buscar(Long id)
    {
        Curso_alumno z=e.findById(id).get();
        return z;
    }

    public Curso_alumno busca2(Curso id) {
        System.out.println(id.getId_curso()+"curso en curso alu--------------------------------------");
        List<Curso_alumno> x = e.findCurso_alumnoById_curso(id);
        Curso_alumno d=new Curso_alumno();
        for(int indice = 0;indice<x.size();indice++)
        {
            if(x.get(indice).getId_curso()==id)
            {
                d=x.get(indice);
            }
        }
        System.out.println(x+"AQUI-------------------------------------");
        return d;
    }

}

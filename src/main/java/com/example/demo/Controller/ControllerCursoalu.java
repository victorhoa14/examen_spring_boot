package com.example.demo.Controller;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Curso_alumno;
import com.example.demo.Entity.Maestro;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryCurso;
import com.example.demo.Repository.RepositoryMaestro;
import com.example.demo.Service.ServiceAlumno;
import com.example.demo.Service.ServiceCurso;
import com.example.demo.Service.ServiceCursoAlu;
import lombok.Data;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.demo.Controller")
@Controller
@Data
public class ControllerCursoalu {
    @Autowired
    RepositoryCurso rcurso;
    @Autowired
    ServiceCursoAlu ca;
    @Autowired
    ServiceAlumno sa;
    @Autowired
    RepositoryAlumno ma;
    @Autowired
    ServiceCurso sc;

    @RequestMapping("/inscribir")
    public String asignarProfe(Model model){
        model.addAttribute("cursoalu", new Curso_alumno());
        return "inscribiralumno";
    }

    @RequestMapping(value = "/asignarcurso", method = RequestMethod.POST)
    public String asignarcurso(
            @RequestParam("id_curso") Long id_curso,
            @RequestParam ("id_alumno") Long id_alumno){
        System.out.println(id_alumno+"-----"+id_curso);
        if (id_alumno!=null && id_curso!=null ) {
            Curso_alumno c = new Curso_alumno();
            Alumno a = sa.buscar(id_alumno);
            Curso b = sc.Buscar(id_curso);
            c.setId_alumno(a);
            c.setId_curso(b);
            ca.create(c);
        }
    return "index";

    }



    @RequestMapping("/buscarcursoal")
    public String buscaralu(Model model){
        model.addAttribute("cursoalu", new Curso_alumno());

        return "buscarcursoalu";
    }

    @RequestMapping(value = "/agregarcali", method = RequestMethod.GET)
    public String buscarcursos(@RequestParam ("id_alumno") Long id_alumno, Model v){
        String j="";
       if(id_alumno!=null)
       {
           if (sa.existe(id_alumno))
           {
               Alumno n = sa.buscar(id_alumno);
               System.out.println(n);
               List<Curso_alumno> l = ca.cal(n);
               List<Curso> c = ca.cursos(n);
               v.addAttribute("cursos", c);
               j = "cursosalumno";
           }
           else
           {
               j="index";
           }
       }
       else
       {
           j="index";
       }
         return j;

    }
    @RequestMapping("/agregarcali/{id}")
    public String agregarcali(@PathVariable Long id, Model model){
        Curso x=sc.Buscar(id);
        System.out.println(x+"----------------------");
        Curso_alumno n=ca.busca2(x);
        System.out.println(n+"*******************");
        model.addAttribute("calif", n);
        return "calificacion";
    }

    @RequestMapping("/agregarc")
    public String asignarc(Model model, Curso_alumno c){
       // model.addAttribute("cursoalu", new Curso_alumno());
        Curso_alumno n=ca.buscar(c.getId_cursoalu());
        n.setCalificacion(c.getCalificacion());
        ca.create(n);
        return "index";
    }

    @RequestMapping("/inicio")
    public String regresar
            (Model model){
       // model.addAttribute("cursoalu", new Curso_alumno());

        return "index";
    }
}

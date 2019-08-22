package com.example.demo.Controller;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Maestro;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryCurso;
import com.example.demo.Repository.RepositoryExpediente;
import com.example.demo.Repository.RepositoryMaestro;
import com.example.demo.Service.ServiceAlumno;
import com.example.demo.Service.ServiceCurso;
import com.example.demo.Service.ServiceMaestro;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.demo.Controller")
@Controller
@Data
public class ControllerCurso {
    static Logger logger=Logger.getLogger(ControllerCurso.class.getName());
    @Autowired
    ServiceCurso rc;

    @Autowired
    ServiceMaestro sm;

    @RequestMapping("/formcurso")
    public String formulario(Model model){
        model.addAttribute("curso", new Curso());
        return "crearcurso";
    }

    @RequestMapping(value = "/crearcurso", method = RequestMethod.POST)
    public String create(@Valid Curso m1) {

        if(m1.getNombre()!="") {
            logger.info("Curso creado"+m1);
            rc.createcurso(m1);
        }
        else
        {
            logger.warning("Curso no creado");
        }
        return "index";

    }

    @RequestMapping("/asignar")
    public String asignarProfe(Model model){
        model.addAttribute("curso", new Curso());

        return "asignarprofe";
    }
    @RequestMapping(value = "/asignarmaestro", method = RequestMethod.POST)
    public String asignar(@RequestParam("id_maestro") Long id_maestro,
            @RequestParam ("id_curso") Long id_curso, Model Model){
        if(id_maestro!=null && id_curso!=null) {
            if(rc.existecurso(id_curso)==true && sm.existeprofe(id_maestro)) {
                Curso n = rc.Buscar(id_curso);
                Maestro m = sm.Buscar(id_maestro);
                n.setId_maestro(m);
                rc.createcurso(n);
                logger.info("Maestro asignado"+n);
            }
        }
        else
        {
            logger.warning("Curso no existe");
        }

    return "index";

    }

    @RequestMapping("/informacioncurso")
    public String info(Model model){
        model.addAttribute("curso", new Curso());
        return "buscarcurso";
    }

    @RequestMapping(value = "/buscarcur", method = RequestMethod.GET)
    //@RequestParam
    public String actu(@RequestParam("id_curso") Long id_curso, Model model1){
        String t="";
        if(id_curso!=null) {
            if(rc.existecurso(id_curso)==true)
            {
                Curso a1 = rc.Buscar(id_curso);
                model1.addAttribute("curso", a1);
                t = "actualizarcurso";
                logger.info("Curso actualizado");
            }
            else
            {
                logger.warning("Curso no existe");
                t="index";
            }
        }
        else
        {
            logger.warning("Curso invalido");
            t="index";
        }
        return t;

    }

}

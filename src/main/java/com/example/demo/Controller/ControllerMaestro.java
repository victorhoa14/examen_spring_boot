package com.example.demo.Controller;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Expediente;
import com.example.demo.Entity.Maestro;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryExpediente;
import com.example.demo.Service.ServiceAlumno;
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
public class ControllerMaestro {
    @Autowired
    RepositoryAlumno a;
    @Autowired
    RepositoryExpediente e;
    @Autowired
    ServiceAlumno se;
    @Autowired
    ServiceMaestro sm;

    static Logger logger=Logger.getLogger(ControllerMaestro.class.getName());

    @RequestMapping(value = "/crearprofe", method = RequestMethod.POST)
    public String create(@Valid  Maestro m1,Model model) {
        if (m1.getMatricula()!=0) {
            sm.create(m1);
            logger.info("Maestro creado "+m1);
        }
        else
        {
            logger.info("Maestro no creado");
        }
     return "index";

    }

    @RequestMapping("/formprofe")
    public String formularioprofe(Model model){
        model.addAttribute("profe", new Maestro());
        return "crearprofe";
    }

    @RequestMapping("/eliminarprofe")
    public String formularioeliminarprofe(Model model){
        model.addAttribute("profe", new Maestro());
        return "borrarprofe";
    }

    @RequestMapping(value = "/borrarprofe",method = RequestMethod.GET)
    public String delatemaestro(@Valid @RequestParam ("id_maestro") Long id_maestro )
    {
        if(sm.existeprofe(id_maestro)==true) {
            logger.info("Maestro eliminado"+sm.Buscar(id_maestro));
            sm.eliminarmaestro(id_maestro);
        }
        else
        {
            logger.info("Maestro no existe");
        }
        return "index";
    }
    @RequestMapping("/informacionprofe")
    public String info(Model model){
        model.addAttribute("maestro", new Maestro());
        return "buscarmaestro";
    }

    @RequestMapping(value = "/infomaestro", method = RequestMethod.GET)
    //@RequestParam
    public String actualizarmaestro(@RequestParam("id_maestro") Long id_maestro, Model model1){
        String a="";
        if(sm.existeprofe(id_maestro)==true)
        {   a="actualizarprofe";
            Maestro a1 = sm.Buscar(id_maestro);
            model1.addAttribute("profe", a1);
            logger.info("Maestro actualizado");
        }
        else {
            logger.info("Maestro no existe");
            a="index";
        }
            return a;


    }

}

package com.example.demo.Controller;

import ch.qos.logback.classic.BasicConfigurator;
import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Expediente;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryExpediente;
import com.example.demo.Service.ServiceAlumno;
import com.example.demo.Service.ServiceExpediente;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.logging.Logger;


@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.demo.Controller")
@Controller
@Data
@Log4j

public class ControllerAlumno {
    @Autowired
    RepositoryAlumno a;
    @Autowired
    RepositoryExpediente e;
    @Autowired
    ServiceAlumno se;
    @Autowired
    ServiceExpediente ex;
    static Logger logger=Logger.getLogger(Alumno.class.getName());

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    //@RequestParam

    public String alumnos(@RequestParam("id_alumno") Long id_alumno, Model model1){

            Alumno a1 = se.buscar(id_alumno);
            model1.addAttribute("alu", a1);
            return "crear";

    }


//@RequestBody
   // @Valid
   @RequestMapping(value = "/crear", method = RequestMethod.POST)
    //@PostMapping("/create")
    public String create(@Valid Alumno alu,
                         Model model) {

            if(alu.getMatricula()!=null) {
                Expediente exp = new Expediente();
                ex.create_ex(exp);
                alu.setId_expediente(exp);
                Alumno userCreated = se.create1(alu);
                //model.addAttribute("alu", userCreated);
                logger.info("Usuario Creado o Modificado  "+userCreated);
            }
            else
            {
                logger.warning("Usuario no creado");
            }

      //log.info("Debugeano: {}", userCreated);

         return "index";

    }


    @RequestMapping("/form")
    public String formulario(Model model){
        model.addAttribute("alu", new Alumno());
        return "crear";
    }

    @RequestMapping("/eliminaralu")
    public String formularioeliminar(Model model){
        model.addAttribute("alu", new Alumno());
        return "borrar";
    }

    @RequestMapping(value = "/eliminar",method = RequestMethod.GET)
    public String delete(@Valid @RequestParam ("id_alumno") Long id_alumno )
    {   if (id_alumno!=0)
        {
           if(se.existe(id_alumno)==true) {
                logger.info("Usuario Eliminado"+se.buscar(id_alumno));
                Alumno a2 = se.eliminar(id_alumno);
            }
        }
        else
    {
        logger.warning("Usuario no existe");
    }
       return "index";
    }


    @RequestMapping("/informacion")
    public String info(Model model){
        model.addAttribute("alu", new Alumno());
        return "buscaraluact";
    }

    @RequestMapping(value = "/actualizarinfoalu", method = RequestMethod.GET)
    //@RequestParam
    public String actu(@RequestParam("id_alumno") Long id_alumno, Model model1){
        String d;
        if (se.existe(id_alumno)==true) {
            d="actualizaralu";
            Alumno a1 = se.buscar(id_alumno);
            model1.addAttribute("alu", a1);
            logger.info("Usuario: "+a1);
        }
        else
        {   logger.warning("Usuario no existe");
            d="index";
        }

        return d;

    }

}

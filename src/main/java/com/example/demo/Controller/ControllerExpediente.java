package com.example.demo.Controller;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Expediente;
import com.example.demo.Service.ServiceCurso;
import com.example.demo.Service.ServiceExpediente;
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

@Controller
@Data

public class ControllerExpediente {
@Autowired
    ServiceExpediente se;
    static Logger logger=Logger.getLogger(ControllerExpediente.class.getName());
    @RequestMapping(value = "/buscarex")
    public String formulario(Model model){
         model.addAttribute("exp", new Expediente());
        return "buscaexp";
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.GET)
    public String act(@RequestParam("id_expediente")Long id_expediente, Model model){
        String d;
        if(se.Existeexp(id_expediente)==true) {
            d="actualizarexp";
            Expediente n = new Expediente();
            n = se.buscar(id_expediente);
            model.addAttribute("exp", n);
            logger.info("Expediente Modificado");
           }
        else {
            logger.warning("Expediente no existe");
            d = "index";
        }
        return d;
    }


    @RequestMapping(value = "/actualizare", method = RequestMethod.POST)
     public String create(@Valid  Expediente exp,
                         Model model) {
        se.create_ex(exp);
        return "index";

    }

}

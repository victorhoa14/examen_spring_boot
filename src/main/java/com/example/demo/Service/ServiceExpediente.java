package com.example.demo.Service;

import com.example.demo.Entity.Alumno;
import com.example.demo.Entity.Expediente;
import com.example.demo.Repository.RepositoryAlumno;
import com.example.demo.Repository.RepositoryExpediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceExpediente {

    @Autowired
    private RepositoryExpediente e1;

    public Expediente create_ex(Expediente user) {

        return e1.save(user);
    }
    public Boolean Existeexp(Long id_expediente)
    {
        Boolean a=e1.existsById(id_expediente);
        return a;
    }
    public Expediente buscar(Long id_expediente)
    {
        //Alumno a=e2.findById(id_alumno).get();
        Expediente a=e1.findById(id_expediente).get();
        return a;
    }




}

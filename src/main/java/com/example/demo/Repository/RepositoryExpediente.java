package com.example.demo.Repository;

import com.example.demo.Entity.Expediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryExpediente extends CrudRepository<Expediente,Long> {

}

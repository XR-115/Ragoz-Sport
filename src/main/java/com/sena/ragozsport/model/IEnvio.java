package com.sena.ragozsport.model;

import org.springframework.data.repository.CrudRepository;
import com.sena.ragozsport.model.envio.Envio;

public interface IEnvio extends CrudRepository<Envio, Integer> {
    
}

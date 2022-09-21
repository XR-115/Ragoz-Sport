package com.sena.ragozsport.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sena.ragozsport.model.envio.Envio;
import com.sena.ragozsport.model.guia.guia;

public interface IEnvio extends CrudRepository<Envio, Integer> {

    public Optional <Envio> findByGuia(guia guia);
}

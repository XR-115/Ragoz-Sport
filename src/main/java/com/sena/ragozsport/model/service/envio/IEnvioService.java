package com.sena.ragozsport.model.service.envio;

import java.util.List;

import com.sena.ragozsport.model.envio.Envio;

public interface IEnvioService {
    
    public List<Envio> findAll();
    public void save(Envio envio);
    public Envio findOne(Integer idEnvio);
    public void delete(Integer idEnvio);
    
}

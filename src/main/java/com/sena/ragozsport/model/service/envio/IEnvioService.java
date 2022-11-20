package com.sena.ragozsport.model.service.envio;

import java.util.List;

import com.sena.ragozsport.model.envio.Envio;

public interface IEnvioService {
    

    public List<Envio> findAll();
    public Envio save(Envio envio) throws Exception;
    public void saveU(Envio envio);
    public Envio findOne(Integer idEnvio);
    public void delete(Integer idEnvio);
    
}

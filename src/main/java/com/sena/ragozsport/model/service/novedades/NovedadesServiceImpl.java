package com.sena.ragozsport.model.service.novedades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ragozsport.model.INovedades;
import com.sena.ragozsport.model.novedades.Novedades;

@Service
public class NovedadesServiceImpl implements INovedadesService {


    @Autowired
    private INovedades interfazNov;

    @Override
    public List<Novedades> findAll() {
        return (List<Novedades>) interfazNov.findAll() ;
    }

    @Override
    public void save(Novedades novedades) {
        interfazNov.save(novedades);
    }

    @Override
    public Novedades findOne(Integer idNovedades) {
        return interfazNov.findById(idNovedades).orElse(null) ;
    }

    @Override
    public void delete(Integer idNovedades) {
        interfazNov.deleteById(idNovedades);
        
    }
    
}

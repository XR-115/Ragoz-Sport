package com.sena.ragozsport.model.service.envio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.ragozsport.model.IEnvio;
import com.sena.ragozsport.model.envio.Envio;

@Service
public class EnvioServiceImpl implements IEnvioService {
    
    //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS--------------------------------------------//
    @Autowired
    private IEnvio envioD;

    @Override
    public List<Envio> findAll() {
    return (List<Envio>) envioD.findAll();
    }

     //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO--------------------------------------------//

     @Override
     public Envio findOne(Integer idEnvio){
         return envioD.findById(idEnvio).orElse(null);
     }

     //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
     @Override
     public void save(Envio envio) {
        envioD.save(envio);
         }

    //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
     @Override
     public void delete(Integer idEnvio) {
        envioD.deleteById(idEnvio);
         }
}

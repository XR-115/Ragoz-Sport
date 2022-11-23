package com.sena.ragozsport.model.service.envio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.sena.ragozsport.model.IEnvio;
import com.sena.ragozsport.model.envio.Envio;


@Service
public class EnvioServiceImpl implements IEnvioService {

    // ---------------------------------------MÉTODO PARA LISTAR TODOS LOS
    // DATOS--------------------------------------------//
    @Autowired
    private IEnvio envioD;

    @Override
    public List<Envio> findAll() {

    
        return (List<Envio>) envioD.findAll();
        
    }

    
    // ---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O
    // REGISTRAR UN DATO--------------------------------------------//

    @Override
    public Envio findOne(Integer idEnvio) {
        return envioD.findById(idEnvio).orElse(null);
    }

    // ---------------------------------------MÉTODO PARA GUARDAR UN
    // DATO-------------------------------------------//
    @Override
    public Envio save(Envio envio) throws Exception {
        if (!checkIdGuiaAvailable(envio)) {
            Envio createdEnvio = envioD.save(envio);

            return createdEnvio;
        }
        envioD.save(envio);
        return envio;
    }

    private boolean checkIdGuiaAvailable(Envio envio) throws Exception {
        Optional envioFound = envioD.findByGuia(envio.getGuia());
        if (envioFound.isPresent()) {
            throw new Exception("Esta guia ya ha sido asociada a un envío");
        }
        return false;
    }

    // ---------------------------------------MÉTODO PARA ACTUALIZAR SIN AFECTAR LA
    // GUIA-------------------------------------------//
    @Override
    public void saveU(Envio envio) {
        envioD.save(envio);
    }

    // ---------------------------------------MÉTODO PARA GUARDAR UN
    // DATO-------------------------------------------//
    @Override
    public void delete(Integer idEnvio) {
        envioD.deleteById(idEnvio);
    }

}

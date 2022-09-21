package com.sena.ragozsport.model.service.pago;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.ragozsport.model.IPago;
import com.sena.ragozsport.model.pago.Pago;

 @Service
public class PagoServiceImpl implements IPagoService {
     //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS--------------------------------------------//
     
    
     
     @Autowired
     private IPago pagoD;
 
     @Override
     public List<Pago> findAll() {
     return (List<Pago>) pagoD.findAll();
     }
 
      //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO--------------------------------------------//
 
      @Override
      public Pago findOne(Integer idPago){
          return pagoD.findById(idPago).orElse(null);
      }
 
      //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
      @Override
      public Pago save(Pago pago) throws Exception{
        if (!checkMetodopagoAvailable(pago)) {
            Pago createdPago =pagoD.save(pago);
        return createdPago; 
        } 
      return pago;
          }
 
      private boolean checkMetodopagoAvailable(Pago pago) throws Exception {
        Optional pagoFound = pagoD.findByMetodoPago(pago.getMetodoPago());
        if (pagoFound.isPresent()) {
            throw new Exception("Este método de pago ya fué registrado");
        }
        return false;
    }
      
    
     //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
      @Override
      public void delete(Integer idPago) {
      pagoD.deleteById(idPago);
          }

          
      
}

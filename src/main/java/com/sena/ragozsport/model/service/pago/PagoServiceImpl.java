package com.sena.ragozsport.model.service.pago;

import java.util.List;
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
      public void save(Pago pago) {
      pagoD.save(pago);
          }
 
     //---------------------------------------MÉTODO PARA GUARDAR UN DATO-------------------------------------------//
      @Override
      public void delete(Integer idPago) {
      pagoD.deleteById(idPago);
          }
}

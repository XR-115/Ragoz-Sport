package com.sena.ragozsport.model;

import org.springframework.data.repository.CrudRepository;
import com.sena.ragozsport.model.pago.Pago;

public interface IPago extends CrudRepository<Pago,Integer> {
    
}

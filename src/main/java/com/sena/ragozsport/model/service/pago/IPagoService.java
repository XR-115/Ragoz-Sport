package com.sena.ragozsport.model.service.pago;

import java.util.List;

import com.sena.ragozsport.model.pago.Pago;

public interface IPagoService {

    public List<Pago> findAll();
    public void save(Pago pago);
    public Pago findOne(Integer idPago);
    public void delete(Integer idPago);
    
}

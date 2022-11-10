package com.sena.ragozsport.model.service.novedades;

import java.util.List;

import com.sena.ragozsport.model.novedades.Novedades;


public interface INovedadesService {
  //------------- Metodo de listar ------------//
  public List<Novedades>findAll();
  //------------- Metodo de registar ------------//
  public void save(Novedades novedades);
  //------------- Metodo de Editar ------------//
  public Novedades findOne(Integer idNovedades);
  //------------- Metodo de eliminar ------------//
  public void delete(Integer idNovedades);
    
}

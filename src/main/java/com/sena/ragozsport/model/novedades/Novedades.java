package com.sena.ragozsport.model.novedades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sena.ragozsport.model.envio.Envio;

import javax.persistence.OneToOne;

@Entity
    @Table(name = "novedades")
public class Novedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNovedades;


    @NotEmpty
    @Column(name="Estado")
    private String Estado;
  
    @Column(name="observacion", length=150000)
    private String observacion;

    @Column(name="fecha")
    private String fecha;

    @OneToOne
    @JoinColumn(name = "FK_ENVIO", updatable = false, nullable = false)
    private Envio envio;

  public Novedades(){

  }

public Novedades(Integer idNovedades, @NotEmpty String estado, String observacion, String fecha, Envio envio) {
    this.idNovedades = idNovedades;
    Estado = estado;
    this.observacion = observacion;
    this.fecha = fecha;
    this.envio = envio;
}

public Integer getIdNovedades() {
    return idNovedades;
}

public void setIdNovedades(Integer idNovedades) {
    this.idNovedades = idNovedades;
}

public String getEstado() {
    return Estado;
}

public void setEstado(String estado) {
    Estado = estado;
}

public String getObservacion() {
    return observacion;
}

public void setObservacion(String observacion) {
    this.observacion = observacion;
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fecha) {
    this.fecha = fecha;
}

public Envio getEnvio() {
    return envio;
}

public void setEnvio(Envio envio) {
    this.envio = envio;
}



}

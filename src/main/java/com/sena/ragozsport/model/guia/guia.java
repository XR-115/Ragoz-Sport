package com.sena.ragozsport.model.guia;

import java.sql.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.sena.ragozsport.model.envio.Envio;


@Entity
@Table(name = "guia") 
public class guia {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Integer idGuia;

    @NotNull
    @Pattern(regexp = "^[0-9]{10,10}+$",message="El teléfono debe de tener 10 dígitos")
    @Column (name="telGuia", length = 10)
    private String telGuia;

    @NotEmpty
    @Column(name="direcGuia", length=25)
    private  String direcGuia;

    @NotNull
    @Column(name="fechaGuia")
    private Date fechaGuia;
    
   @NotNull
    @Column(name="numCajasGuia", length = 3)
    private Integer numCajasGuia;

    @NotNull
    @Column(name="valorMercancia")
    private Integer valorMercancia;

    @NotEmpty
    @Column(name="remitente", length=15)
    private  String remitente;

    @NotEmpty
    @Column(name="destinatario", length=15)
    private  String destinatario;

    @NotEmpty
    @Column(name="ciudadOrigen", length=12)
    private  String ciudadOrigen;

    @NotEmpty
    @Column(name="ciudadDestino", length=12)
    private  String ciudadDestino;


    @OneToOne(mappedBy = "guia", cascade = CascadeType.ALL)
    private Envio envio;

    
   

   //------------------------------ METODO CONSTRUCTOR VACIO Y CON PARAMETROS  ----------------------------//    
    public guia(){
        
    }

    public guia(Integer idGuia,
    @NotNull @Pattern(regexp = "(+57|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}") String telGuia,
    @NotEmpty String direcGuia, @NotNull Date fechaGuia, @NotNull Integer numCajasGuia,
    @NotNull Integer valorMercancia, @NotEmpty String remitente, @NotEmpty String destinatario,
    @NotEmpty String ciudadOrigen, @NotEmpty String ciudadDestino, Envio envio) {
this.idGuia = idGuia;
this.telGuia = telGuia;
this.direcGuia = direcGuia;
this.fechaGuia = fechaGuia;
this.numCajasGuia = numCajasGuia;
this.valorMercancia = valorMercancia;
this.remitente = remitente;
this.destinatario = destinatario;
this.ciudadOrigen = ciudadOrigen;
this.ciudadDestino = ciudadDestino;
this.envio = envio;
}

    public Integer getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public String getTelGuia() {
        return telGuia;
    }

    public void setTelGuia(String telGuia) {
        this.telGuia = telGuia;
    }

    public String getDirecGuia() {
        return direcGuia;
    }

    public void setDirecGuia(String direcGuia) {
        this.direcGuia = direcGuia;
    }

    public Date getFechaGuia() {
        return fechaGuia;
    }

    public void setFechaGuia(Date fechaGuia) {
        this.fechaGuia = fechaGuia;
    }

    public Integer getNumCajasGuia() {
        return numCajasGuia;
    }

    public void setNumCajasGuia(Integer numCajasGuia) {
        this.numCajasGuia = numCajasGuia;
    }

    public Integer getValorMercancia() {
        return valorMercancia;
    }

    public void setValorMercancia(Integer valorMercancia) {
        this.valorMercancia = valorMercancia;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
 

  //*-------------------------------MÉTODOS ACCESORES GETTERS Y SETTERS--------------------------------*//   




}



 



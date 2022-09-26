package com.sena.ragozsport.model.guia;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sena.ragozsport.model.envio.Envio;


@Entity
@Table(name = "guia") 
public class guia {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Integer idGuia;

    @NotNull
    @Column (name="telGuia")
    private Integer telGuia;

    @NotEmpty
    @Column(name="direcGuia", length=50)
    private  String direcGuia;

    @NotNull
    @Column(name="fechaGuia")
    private Date fechaGuia;
    
   @NotNull
    @Column(name="numCajasGuia")
    private Integer numCajasGuia;

    @NotNull
    @Column(name="valorMercancia")
    private double valorMercancia;

    @NotEmpty
    @Column(name="remitente", length=50)
    private  String remitente;

    @NotEmpty
    @Column(name="destinatario", length=50)
    private  String destinatario;

    @NotEmpty
    @Column(name="ciudadOrigen", length=50)
    private  String ciudadOrigen;

    @NotEmpty
    @Column(name="ciudadDestino", length=50)
    private  String ciudadDestino;


    @OneToOne(mappedBy = "guia", cascade = CascadeType.ALL)
    private Envio envio;

    
   

   //------------------------------ METODO CONSTRUCTOR VACIO Y CON PARAMETROS  ----------------------------//    
    public guia(){
        
    }

    public guia(Integer idGuia, @NotNull Integer telGuia, @NotEmpty String direcGuia, @NotNull Date fechaGuia,
    @NotNull Integer numCajasGuia, @NotNull double valorMercancia, @NotEmpty String remitente,
    @NotEmpty String destinatario, @NotEmpty String ciudadOrigen, @NotEmpty String ciudadDestino, Envio envio) {
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
 

  //*-------------------------------MÉTODOS ACCESORES GETTERS Y SETTERS--------------------------------*//   


    public Integer getIdGuia() {
        return idGuia;
    }


    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }


    public Integer getTelGuia() {
        return telGuia;
    }


    public void setTelGuia(Integer telGuia) {
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


    public double getValorMercancia() {
        return valorMercancia;
    }


    public void setValorMercancia(double valorMercancia) {
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

}



 



package com.sena.ragozsport.model.envio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.sena.ragozsport.model.guia.guia;
import com.sena.ragozsport.model.usuario.Usuario;


//*--------------------------------CREACIÓN TABLA--------------------------------*//

@Entity
    @Table(name = "envio")


//*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;

    @NotNull
    @Column(name="fechaEnvio")
    private String fechaEnvio;

    @NotNull
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
    @Column(name="horaEnvio")
    private String horaEnvio;

    @Column(name="estadoEnvio")
    private boolean estadoEnvio;


    @NotNull
    @Min(1000)
    @Max(99999999)
    @Column(name="costoTotalEnvio",length = 10)
    private Integer costoTotalEnvio;

    @Column(name="metodoPago")
    private String metodoPago;


   //----------------- RELACIÓN CON USUARIO -----------------//
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario fkusuario;

    //----------------- RELACIÓN CON GUIA -----------------//
    @OneToOne
    @JoinColumn(name = "FK_GUIA", updatable = false, nullable = false)
    private guia guia;




//*--------------------------------CONSTRUCTORES--------------------------------*//    
    public Envio() {
       
    }

    public Envio(Integer idEnvio, @NotNull String fechaEnvio,
            @NotNull @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]") String horaEnvio, boolean estadoEnvio,
            @NotNull @Min(45000) @Max(99999999) Integer costoTotalEnvio, String metodoPago, Usuario fkusuario,
            com.sena.ragozsport.model.guia.guia guia) {
        this.idEnvio = idEnvio;
        this.fechaEnvio = fechaEnvio;
        this.horaEnvio = horaEnvio;
        this.estadoEnvio = estadoEnvio;
        this.costoTotalEnvio = costoTotalEnvio;
        this.metodoPago = metodoPago;
        this.fkusuario = fkusuario;
        this.guia = guia;
    }
    //*-------------------------------MÉTODOS ACCESORES GETTERS Y SETTERS--------------------------------*//   

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public boolean isEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Integer getCostoTotalEnvio() {
        return costoTotalEnvio;
    }

    public void setCostoTotalEnvio(Integer costoTotalEnvio) {
        this.costoTotalEnvio = costoTotalEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Usuario getFkusuario() {
        return fkusuario;
    }

    public void setFkusuario(Usuario fkusuario) {
        this.fkusuario = fkusuario;
    }

    public guia getGuia() {
        return guia;
    }

    public void setGuia(guia guia) {
        this.guia = guia;
    }
    

    
}
   
        

    
    



   
    

    

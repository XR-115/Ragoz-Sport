package com.sena.ragozsport.model.envio;

import java.sql.Date;



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
import javax.validation.constraints.NotNull;


import com.sena.ragozsport.model.guia.guia;
import com.sena.ragozsport.model.pago.Pago;
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
    private Date fechaEnvio;

    @NotNull
    @Column(name="horaEnvio")
    private String horaEnvio;

    @Column(name="estadoEnvio")
    private boolean estadoEnvio;



    @Column(name="costoTotalEnvio",length = 10)
    private double costoTotalEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pago fkpago;
   
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario fkusuario;

    
    @OneToOne
    @JoinColumn(name = "FK_GUIA", updatable = false, nullable = false)
    private guia guia;

   /* @OneToOne(mappedBy="FKguia")
    private guia FKguia;*/


//*--------------------------------CONSTRUCTORES--------------------------------*//    
    public Envio() {
       
    }

    public Envio(Integer idEnvio, Date fechaEnvio, String horaEnvio, boolean estadoEnvio, double costoTotalEnvio,
            Pago fkpago, Usuario fkusuario, com.sena.ragozsport.model.guia.guia guia) {
        this.idEnvio = idEnvio;
        this.fechaEnvio = fechaEnvio;
        this.horaEnvio = horaEnvio;
        this.estadoEnvio = estadoEnvio;
        this.costoTotalEnvio = costoTotalEnvio;
        this.fkpago = fkpago;
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

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(String horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public boolean getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(boolean estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public double getCostoTotalEnvio() {
        return costoTotalEnvio;
    }

    public void setCostoTotalEnvio(double costoTotalEnvio) {
        this.costoTotalEnvio = costoTotalEnvio;
    }

    public Pago getFkpago() {
        return fkpago;
    }

    public void setFkpago(Pago fkpago) {
        this.fkpago = fkpago;
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

    //*--------------------------------MÉTODOS ACCESORES--------------------------------*//
   
        

    
    



   
    

    
}

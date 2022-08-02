package com.sena.ragozsport.model.envio;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



//*--------------------------------CREACIÓN TABLA--------------------------------*//

@Entity
    @Table(name = "envio")


//*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;

    @NotEmpty
    @Column(name="fechaEnvio",length = 4)
    private Date fechaEnvio;

    @NotEmpty
    @Column(name="horaEnvio",length = 3)
    private Time horaEnvio;

    @NotEmpty
    @Column(name="estadoEnvio")
    private boolean estadoEnvio;

    @NotEmpty
    @Column(name="costoTotalEnvio",length = 10)
    private double costoTotalEnvio;





//*--------------------------------CONSTRUCTORES--------------------------------*//    
    public Envio() {
    }

    public Envio(Integer idEnvio, @NotEmpty Date fechaEnvio, @NotEmpty Time horaEnvio, @NotEmpty boolean estadoEnvio,
            @NotEmpty double costoTotalEnvio) {
        this.idEnvio = idEnvio;
        this.fechaEnvio = fechaEnvio;
        this.horaEnvio = horaEnvio;
        this.estadoEnvio = estadoEnvio;
        this.costoTotalEnvio = costoTotalEnvio;
    }




//*--------------------------------MÉTODOS ACCESORES--------------------------------*//

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

    public Time getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Time horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public boolean isEstadoEnvio() {
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

    
}

package com.sena.ragozsport.model.pago;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.sena.ragozsport.model.envio.Envio;



//*--------------------------------NOMBRE DE LA TABLA--------------------------------*//
@Entity
    @Table(name = "pago")


//*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPago;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z]{3,15}")
    @Column(name = "metodoPago",length = 30)
    private String metodoPago;

    @OneToMany(mappedBy = "fkpago", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Envio> envio;

 

 //-------------------------------------------CONSTRUCTORES---------------------------------------//
    
 public Pago() {
    envio=new ArrayList<Envio>();
}

public Pago(Integer idPago, @NotEmpty String metodoPago, List<Envio> envio) {
    this.idPago = idPago;
    this.metodoPago = metodoPago;
    this.envio = envio;
}


//-------------------------------------------MÉTODOS ACCESORES---------------------------------------//

public Integer getIdPago() {
    return idPago;
}



public void setIdPago(Integer idPago) {
    this.idPago = idPago;
}



public String getMetodoPago() {
    return metodoPago;
}



public void setMetodoPago(String metodoPago) {
    this.metodoPago = metodoPago;
}



public List<Envio> getEnvio() {
    return envio;
}



public void setEnvio(List<Envio> envio) {
    this.envio = envio;
}


 
 

   
    
}

package com.sena.ragozsport.model.usuario;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.sena.ragozsport.model.envio.Envio;


//*--------------------------------CREACIÓN TABLA--------------------------------*//

@Entity
    @Table(name = "usuario")
//*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

   
    @Column(name="Actor")
    private String  Actor ;

    @NotEmpty
    @Column(name="nombreUsuario")
    private String nombreUsuario;
    @NotBlank
    @Column(name="apellidoUsuario ")
    private String ApellidoUsuario;

    @NotNull
    @Column(name="numerodeTelefono", length = 10)
    private Double NumerodeTelefono;
    
    @NotNull
    @Column(name="numeroDocumento")
    private String numeroDocumento;

    @NotEmpty
    @Column(name="Password")
    private String Password;

    @Email 
	@NotBlank
    @Column(name="correo")
    private String correo;

     @OneToMany(mappedBy = "fkusuario", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Envio> envioi;



public Usuario() {
    }



public Usuario(Integer idUsuario, String actor, @NotEmpty String nombreUsuario, @NotBlank String apellidoUsuario,
        @NotNull Double numerodeTelefono, @NotNull String numeroDocumento, @NotEmpty String password,
        @Email @NotBlank String correo, List<Envio> envioi) {
    this.idUsuario = idUsuario;
    Actor = actor;
    this.nombreUsuario = nombreUsuario;
    ApellidoUsuario = apellidoUsuario;
    NumerodeTelefono = numerodeTelefono;
    this.numeroDocumento = numeroDocumento;
    Password = password;
    this.correo = correo;
    this.envioi = envioi;
}



public Integer getIdUsuario() {
    return idUsuario;
}



public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
}



public String getActor() {
    return Actor;
}



public void setActor(String actor) {
    Actor = actor;
}



public String getNombreUsuario() {
    return nombreUsuario;
}



public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
}



public String getApellidoUsuario() {
    return ApellidoUsuario;
}



public void setApellidoUsuario(String apellidoUsuario) {
    ApellidoUsuario = apellidoUsuario;
}



public Double getNumerodeTelefono() {
    return NumerodeTelefono;
}



public void setNumerodeTelefono(Double numerodeTelefono) {
    NumerodeTelefono = numerodeTelefono;
}



public String getNumeroDocumento() {
    return numeroDocumento;
}



public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
}



public String getPassword() {
    return Password;
}



public void setPassword(String password) {
    Password = password;
}



public String getCorreo() {
    return correo;
}



public void setCorreo(String correo) {
    this.correo = correo;
}



public List<Envio> getEnvioi() {
    return envioi;
}



public void setEnvioi(List<Envio> envioi) {
    this.envioi = envioi;
}




}

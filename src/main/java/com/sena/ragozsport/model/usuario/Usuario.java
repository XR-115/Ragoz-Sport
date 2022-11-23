package com.sena.ragozsport.model.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;

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



    @NotEmpty
    @Column(name="nombreUsuario")
    private String nombreUsuario;
    @NotBlank
    @Column(name="apellidoUsuario ")
    private String ApellidoUsuario;

    @Column(name="username")
    private String username;

    @NotNull
    @Column(name="numerodeTelefono", length = 10)
    private Double NumerodeTelefono;
    
    @NotNull
    @Column(name="numeroDocumento")
    private String numeroDocumento;

    @NotBlank
    @Column(name="tipident ")
    private String tipident ;

    @NotEmpty
    @Column(name="Password")
    private String Password;

    @Email 
	@NotBlank
    @Column(name="correo")
    private String correo;

     @OneToMany(mappedBy = "fkusuario", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Envio> envioi;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "idUsuario"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
                )

    private List<Roles> roles;
    


    //-----------------Constructor vacío---------------//
    public Usuario() {
        }

    //-----------------Constructor con parámetros---------------//
    public Usuario(Integer idUsuario, @NotEmpty String nombreUsuario, @NotBlank String apellidoUsuario, String username,
            @NotNull Double numerodeTelefono, @NotNull String numeroDocumento, @NotBlank String tipident,
            @NotEmpty String password, @Email @NotBlank String correo, List<Envio> envioi, List<Roles> roles) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        ApellidoUsuario = apellidoUsuario;
        this.username = username;
        NumerodeTelefono = numerodeTelefono;
        this.numeroDocumento = numeroDocumento;
        this.tipident = tipident;
        Password = password;
        this.correo = correo;
        this.envioi = envioi;
        this.roles = roles;
    }



    //-----------------MÉTODOS ACCESORES---------------//
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getTipident() {
        return tipident;
    }

    public void setTipident(String tipident) {
        this.tipident = tipident;
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

        
    






}
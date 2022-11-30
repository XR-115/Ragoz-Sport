package com.sena.ragozsport.model.producto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import com.sena.ragozsport.model.pedido.Pedido;


    //*--------------------------------CREACIÓN TABLA--------------------------------*//
    @Entity
    @Table(name="producto")
    //*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Producto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @NotBlank
    @Column(name ="tipoCalzadoPro", length = 9)
    @NotEmpty
    private String tipoCalzadoPro;

    @NotBlank
    @Column(name ="categoriaProd", length = 9)
    private String categoriaProd;

    @NotBlank
    @Column(name ="referenciaProd",unique = true, length = 6)
    private String referenciaProd;

    @NotBlank
    @Column(name ="numeracionProd", length = 5)
    private String numeracionProd;

    
    @Column(name ="totalProd", length = 2)
    private Integer totalProd;
    
    @ManyToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Pedido> pedido;


    //-- METODO CONSTRUCTOR VACIO Y CON PARAMETROS --//
    public Integer getIdProducto() {
        return idProducto;
    }


    
    public Producto() {
    }

    public Producto(Integer idProducto, @NotEmpty String tipoCalzadoPro, String categoriaProd, String referenciaProd,
            String numeracionProd, Integer totalProd, List<Pedido> pedido) {
        this.idProducto = idProducto;
        this.tipoCalzadoPro = tipoCalzadoPro;
        this.categoriaProd = categoriaProd;
        this.referenciaProd = referenciaProd;
        this.numeracionProd = numeracionProd;
        this.totalProd = totalProd;
        this.pedido = pedido;
    }


    //-- METODOS GET Y SET --// 
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }



    public String getTipoCalzadoPro() {
        return tipoCalzadoPro;
    }



    public void setTipoCalzadoPro(String tipoCalzadoPro) {
        this.tipoCalzadoPro = tipoCalzadoPro;
    }



    public String getCategoriaProd() {
        return categoriaProd;
    }



    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }



    public String getReferenciaProd() {
        return referenciaProd;
    }



    public void setReferenciaProd(String referenciaProd) {
        this.referenciaProd = referenciaProd;
    }



    public String getNumeracionProd() {
        return numeracionProd;
    }



    public void setNumeracionProd(String numeracionProd) {
        this.numeracionProd = numeracionProd;
    }



    public Integer getTotalProd() {
        return totalProd;
    }



    public void setTotalProd(Integer totalProd) {
        this.totalProd = totalProd;
    }



    public List<Pedido> getPedido() {
        return pedido;
    }



    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}
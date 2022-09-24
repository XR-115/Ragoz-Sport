package com.sena.ragozsport.model.pedido;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sena.ragozsport.model.producto.Producto;
import com.sena.ragozsport.model.guia.guia;


    //*--------------------------------CREACIÓN TABLA--------------------------------*//
    @Entity
    @Table(name="pedido")

    //*--------------------------------ATRIBUTOS DE LAS TABLAS--------------------------------*//
public class Pedido {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @NotNull
    @Column(name ="cantidadTotalPed")
    private Integer cantidadTotalPed;

    @NotBlank
    @Column(name ="totalCategPed")
    private String totalCategPed;


    @ManyToOne(fetch = FetchType.LAZY)
    private Producto fkproducto;

    @ManyToOne(fetch = FetchType.LAZY)
    private guia fkguia;
    


    //-- METODO CONSTRUCTOR VACIO Y CON PARAMETROS --//
    public Pedido(){

    }   

    public Pedido(Integer idPedido, @NotNull Integer cantidadTotalPed, @NotBlank String totalCategPed,
            Producto fkproducto, guia fkguia) {
        this.idPedido = idPedido;
        this.cantidadTotalPed = cantidadTotalPed;
        this.totalCategPed = totalCategPed;
        this.fkproducto = fkproducto;
        this.fkguia = fkguia;
    }


    //-- METODOS GET Y SET --// 

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getCantidadTotalPed() {
        return cantidadTotalPed;
    }

    public void setCantidadTotalPed(Integer cantidadTotalPed) {
        this.cantidadTotalPed = cantidadTotalPed;
    }

    public String getTotalCategPed() {
        return totalCategPed;
    }

    public void setTotalCategPed(String totalCategPed) {
        this.totalCategPed = totalCategPed;
    }

    public Producto getFkproducto() {
        return fkproducto;
    }

    public void setFkproducto(Producto fkproducto) {
        this.fkproducto = fkproducto;
    }

    public guia getFkguia() {
        return fkguia;
    }

    public void setFkguia(guia fkguia) {
        this.fkguia = fkguia;
    }
    

}

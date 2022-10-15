package com.sena.ragozsport.model.pedido;


import java.util.List;

import javax.persistence.*;

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


    @ManyToOne(fetch = FetchType.LAZY)
    private guia fkguia;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pedido_producto",
        joinColumns = @JoinColumn(name = "id_pedido"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> producto;
    


    //-- METODO CONSTRUCTOR VACIO Y CON PARAMETROS --//
    public Pedido(){

    }   

    public Pedido(Integer idPedido, @NotNull Integer cantidadTotalPed, guia fkguia, List<Producto> producto) {
        this.idPedido = idPedido;
        this.cantidadTotalPed = cantidadTotalPed;
        this.fkguia = fkguia;
        this.producto = producto;
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

    public guia getFkguia() {
        return fkguia;
    }

    public void setFkguia(guia fkguia) {
        this.fkguia = fkguia;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}

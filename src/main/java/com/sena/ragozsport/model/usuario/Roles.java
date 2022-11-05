package com.sena.ragozsport.model.usuario;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
 
        @Id
        @Column(name = "role_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nombre;

        @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
        private List<Usuario> usuario;


        //-----------------Constructor vacío---------------//
        public Roles() {
        }

        //-----------------Constructor con parámetros---------------//
        public Roles(Integer id, String nombre, List<Usuario> usuario) {
            this.id = id;
            this.nombre = nombre;
            this.usuario = usuario;
        }


        //-----------------MÉTODOS ACCESORES---------------//
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<Usuario> getUsuario() {
            return usuario;
        }

        public void setUsuario(List<Usuario> usuario) {
            this.usuario = usuario;
        }

       
       
    }


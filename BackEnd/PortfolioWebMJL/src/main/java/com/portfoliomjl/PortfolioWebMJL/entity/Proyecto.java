package com.portfoliomjl.PortfolioWebMJL.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String url;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String imagen, String url) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.url = url;
    }

}

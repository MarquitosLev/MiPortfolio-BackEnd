package com.portfoliomjl.PortfolioWebMJL.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class HyS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int porcent;

    public HyS() {
    }

    public HyS(String nombre, int porcent) {
        this.nombre = nombre;
        this.porcent = porcent;
    }
    
    
}

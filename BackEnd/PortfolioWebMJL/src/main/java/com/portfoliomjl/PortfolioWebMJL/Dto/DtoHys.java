package com.portfoliomjl.PortfolioWebMJL.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHys {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcent;

    public DtoHys() {
    }

    public DtoHys(String nombre, int porcent) {
        this.nombre = nombre;
        this.porcent = porcent;
    }
    
    
}

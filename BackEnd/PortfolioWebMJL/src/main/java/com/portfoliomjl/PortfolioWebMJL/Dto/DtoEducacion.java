package com.portfoliomjl.PortfolioWebMJL.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    public DtoEducacion() {
    }

    public DtoEducacion(String nom, String descripcionE) {
        this.nombreE = nom;
        this.descripcionE = descripcionE;
    }
    
    
    
    
}

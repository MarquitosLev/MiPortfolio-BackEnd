package com.portfoliomjl.PortfolioWebMJL.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoProyecto {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;
    @NotBlank
    private String imagen;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String descripcion, String imagen, String url) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.url = url;
    }

}

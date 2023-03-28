package com.mjlportfolio.mjl.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Entity
public class Persona {
    // Es de buena practica utilizar long en la ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 40, message = "Longitud no permitida")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 40, message = "Longitud no permitida")
    private String apellido;
    
    @Size(min = 1, max = 40, message = "Longitud no permitida")
    private String img;
    
    
    
}

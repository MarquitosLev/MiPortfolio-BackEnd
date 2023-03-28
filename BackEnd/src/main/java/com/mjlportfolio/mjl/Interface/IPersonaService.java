package com.mjlportfolio.mjl.Interface;

import com.mjlportfolio.mjl.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Lista de las personas
    public List<Persona> getPersonas();
    
    //Guardar una persona
    public void savePersona(Persona pers);
    
    //Borrar una persona
    public void deletePersona(Long id);

    //Buscar una persona
    public Persona findPersona(Long id);
}

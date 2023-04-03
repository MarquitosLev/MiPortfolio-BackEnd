/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio_mjl.mjl.service;
import com.portfolio_mjl.mjl.model.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona(Persona pers);
    
    public void deletePersona(Long id);
    
    public Persona getPersona(long id);
}

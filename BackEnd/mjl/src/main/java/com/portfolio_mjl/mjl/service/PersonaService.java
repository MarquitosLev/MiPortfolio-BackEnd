package com.portfolio_mjl.mjl.service;

import com.portfolio_mjl.mjl.model.Persona;
import com.portfolio_mjl.mjl.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private PersonaRepository persRepository;

    @Override
    public List<Persona> getPersonas() {
        return persRepository.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        persRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        persRepository.deleteById(id);
    }

    @Override
    public Persona getPersona(long id) {
        return persRepository.findById(id).orElse(null);
    }




}

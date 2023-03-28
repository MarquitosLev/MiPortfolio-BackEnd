package com.mjlportfolio.mjl.Service;

import com.mjlportfolio.mjl.Entity.Persona;
import com.mjlportfolio.mjl.Interface.IPersonaService;
import com.mjlportfolio.mjl.Repository.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    // Inyector de dependencias
    @Autowired IPersonaRepo IPersonaRepository;
    
    @Override
    public List<Persona> getPersonas() {
        return IPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        IPersonaRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return IPersonaRepository.findById(id).orElse(null);
    }
    
}

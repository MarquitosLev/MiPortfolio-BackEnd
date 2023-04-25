package com.portfoliomjl.PortfolioWebMJL.service;

import com.portfoliomjl.PortfolioWebMJL.entity.Persona;
import com.portfoliomjl.PortfolioWebMJL.repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {

    @Autowired
    IPersonaRepository iPerRepo;

    public List<Persona> list() {
        return iPerRepo.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return iPerRepo.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return iPerRepo.findByNombre(nombre);
    }

    public void save(Persona persona) {
        iPerRepo.save(persona);
    }

    public void delete(int id) {
        iPerRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return iPerRepo.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iPerRepo.existsByNombre(nombre);
    }
}

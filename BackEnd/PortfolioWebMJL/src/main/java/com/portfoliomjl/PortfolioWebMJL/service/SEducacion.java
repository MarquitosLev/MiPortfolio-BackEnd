package com.portfoliomjl.PortfolioWebMJL.service;

import com.portfoliomjl.PortfolioWebMJL.entity.Educacion;
import com.portfoliomjl.PortfolioWebMJL.repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {

    @Autowired
    REducacion rEducacion;

    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreE(String nomE){
        return rEducacion.findByNombreE(nomE);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nom){
        return rEducacion.existsByNombreE(nom);
    }
    
    public void save(Educacion educ){
        rEducacion.save(educ);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    
}

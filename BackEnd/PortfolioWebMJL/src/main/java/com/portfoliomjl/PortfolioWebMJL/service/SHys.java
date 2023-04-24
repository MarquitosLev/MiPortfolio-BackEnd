package com.portfoliomjl.PortfolioWebMJL.service;

import com.portfoliomjl.PortfolioWebMJL.entity.HyS;
import com.portfoliomjl.PortfolioWebMJL.repository.RHys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHys {
    @Autowired RHys rHys;
    
     public List<HyS> list(){
         return rHys.findAll();
     }
     
     public Optional<HyS> getOne(int id){
         return rHys.findById(id);
     }
     
     public Optional<HyS> getByNombreH(String nombreE){
         return rHys.findByNombre(nombreE);
     }
     
     public void save(HyS expe){
         rHys.save(expe);
     }
     
     public void delete(int id){
         rHys.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rHys.existsById(id);
     }
     
     public boolean existsByNombreH(String nombreE){
         return rHys.existsByNombre(nombreE);
     }
}

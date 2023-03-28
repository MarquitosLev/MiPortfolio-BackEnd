package com.mjlportfolio.mjl.Repository;

import com.mjlportfolio.mjl.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<Clase, Tipo de Primary Key> 
@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {
    
    
    
}

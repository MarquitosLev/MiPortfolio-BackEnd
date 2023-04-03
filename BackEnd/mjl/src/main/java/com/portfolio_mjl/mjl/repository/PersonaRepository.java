
package com.portfolio_mjl.mjl.repository;


import com.portfolio_mjl.mjl.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}

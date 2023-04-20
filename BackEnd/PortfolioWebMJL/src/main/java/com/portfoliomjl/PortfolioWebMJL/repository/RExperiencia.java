package com.portfoliomjl.PortfolioWebMJL.repository;

import com.portfoliomjl.PortfolioWebMJL.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreE(String nombreE);
    public Optional<Experiencia> findByDescripcionE(String descE);
    public boolean existsByNombreE(String nombreE);
}

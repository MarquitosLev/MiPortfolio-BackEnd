package com.portfoliomjl.PortfolioWebMJL.repository;

import com.portfoliomjl.PortfolioWebMJL.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> findByNombreE(String nomE);
    public boolean existsByNombreE(String nomE);
}

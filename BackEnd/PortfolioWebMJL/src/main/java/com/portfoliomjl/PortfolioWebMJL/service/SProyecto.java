package com.portfoliomjl.PortfolioWebMJL.service;

import com.portfoliomjl.PortfolioWebMJL.entity.Proyecto;
import com.portfoliomjl.PortfolioWebMJL.repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto iRProyecto;

    public List<Proyecto> list() {
        return iRProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return iRProyecto.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return iRProyecto.findByNombre(nombre);
    }

    public void save(Proyecto proyecto) {
        iRProyecto.save(proyecto);
    }

    public void delete(int id) {
        iRProyecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return iRProyecto.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iRProyecto.existsByNombre(nombre);
    }
}

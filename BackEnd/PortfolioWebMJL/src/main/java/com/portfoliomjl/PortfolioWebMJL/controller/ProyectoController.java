package com.portfoliomjl.PortfolioWebMJL.controller;

import com.portfoliomjl.PortfolioWebMJL.Dto.DtoProyecto;
import com.portfoliomjl.PortfolioWebMJL.Security.Controller.Mensaje;
import com.portfoliomjl.PortfolioWebMJL.entity.Proyecto;
import com.portfoliomjl.PortfolioWebMJL.service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://portfolio-frontend-mjl.web.app", "http://localhost:4200"})
public class ProyectoController {

    @Autowired
    SProyecto iSProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = iSProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!iSProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proy = iSProyecto.getOne(id).get();
        return new ResponseEntity(proy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!iSProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        iSProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProy) {
        if (StringUtils.isBlank(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (iSProyecto.existsByNombre(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proy = new Proyecto(
                dtoProy.getNombre(), dtoProy.getDescripcion(), dtoProy.getImagen(), dtoProy.getUrl()
        );
        iSProyecto.save(proy);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProy) {
        if (!iSProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (iSProyecto.existsByNombre(dtoProy.getNombre()) && iSProyecto.getByNombre(dtoProy.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proy = iSProyecto.getOne(id).get();

        proy.setNombre(dtoProy.getNombre());
        proy.setDescripcion(dtoProy.getDescripcion());
        proy.setImagen(dtoProy.getImagen());
        proy.setUrl(dtoProy.getUrl());

        iSProyecto.save(proy);

        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}

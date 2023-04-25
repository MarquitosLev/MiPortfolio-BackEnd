package com.portfoliomjl.PortfolioWebMJL.controller;

import com.portfoliomjl.PortfolioWebMJL.Dto.DtoPersona;
import com.portfoliomjl.PortfolioWebMJL.Security.Controller.Mensaje;
import com.portfoliomjl.PortfolioWebMJL.entity.Persona;
import com.portfoliomjl.PortfolioWebMJL.service.ImpPersonaService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://portfolio-frontend-mjl.web.app", "http://localhost:4200"})
public class PersonaController {

     @Autowired
    ImpPersonaService SPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = SPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!SPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona perso = SPersona.getOne(id).get();
        return new ResponseEntity(perso, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!SPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        SPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPer) {
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (SPersona.existsByNombre(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        Persona perso = new Persona(
                dtoPer.getNombre(), dtoPer.getApellido(), dtoPer.getDescripcion(), dtoPer.getImg()
        );
        SPersona.save(perso);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPer) {
        if (!SPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (SPersona.existsByNombre(dtoPer.getNombre()) && SPersona.getByNombre(dtoPer.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Persona perso = SPersona.getOne(id).get();

        perso.setNombre(dtoPer.getNombre());
        perso.setApellido(dtoPer.getApellido());
        perso.setDescripcion(dtoPer.getDescripcion());
        perso.setImg(dtoPer.getImg());

        SPersona.save(perso);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}

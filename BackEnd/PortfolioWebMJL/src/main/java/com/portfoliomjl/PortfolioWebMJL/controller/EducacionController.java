package com.portfoliomjl.PortfolioWebMJL.controller;

import com.portfoliomjl.PortfolioWebMJL.Dto.DtoEducacion;
import com.portfoliomjl.PortfolioWebMJL.Security.Controller.Mensaje;
import com.portfoliomjl.PortfolioWebMJL.entity.Educacion;
import com.portfoliomjl.PortfolioWebMJL.service.SEducacion;
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

//LOS MENTODOS SON SIMILARES AL DE EXPERIENCIA
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200 ")
public class EducacionController {

    @Autowired
    SEducacion sEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> lista = sEducacion.list();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEduc) {
        if (StringUtils.isBlank(dtoEduc.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoEduc.getNombreE())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educ = new Educacion(dtoEduc.getNombreE(), dtoEduc.getDescripcionE());
        sEducacion.save(educ);

        return new ResponseEntity(new Mensaje("Educacion se ha creado"), HttpStatus.OK);

    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educ = sEducacion.getOne(id).get();
        
        return new ResponseEntity(educ, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEduc) {
        if (sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoEduc.getNombreE()) && sEducacion.getByNombreE(dtoEduc.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEduc.getNombreE())) {
            return new ResponseEntity(new Mensaje("El campo esta vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educ = sEducacion.getOne(id).get();
        
        educ.setNombreE(dtoEduc.getNombreE());
        educ.setDescripcionE(dtoEduc.getDescripcionE());
        sEducacion.save(educ);
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
}

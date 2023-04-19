package com.portfoliomjl.PortfolioWebMJL.controller;

import com.portfoliomjl.PortfolioWebMJL.Interface.IPersonaService;
import com.portfoliomjl.PortfolioWebMJL.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/persona/traer")
    public List<Persona> getPersonas() {
        return iPersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "Persona creada";
    }

    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable int id) {
        iPersonaService.deletePersona(id);
        return "Persona borrada";
    }

    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable int id, @RequestParam("nombre") String newName, @RequestParam("apellido") String newLastN, @RequestParam("img") String newImg) {
        Persona pers = iPersonaService.findPersona(id);
        pers.setApellido(newLastN);
        pers.setNombre(newName);
        pers.setImg(newImg);

        iPersonaService.savePersona(pers);
        return pers;
    }
}

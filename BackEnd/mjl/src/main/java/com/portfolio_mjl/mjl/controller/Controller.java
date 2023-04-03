package com.portfolio_mjl.mjl.controller;

import com.portfolio_mjl.mjl.model.Persona;
import com.portfolio_mjl.mjl.service.IPersonaService;
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
public class Controller {

    @Autowired
    private IPersonaService interPerso;

    @GetMapping("/ver/personas")
    public List<Persona> getLista() {
        return interPerso.getPersonas();
    }

    @PostMapping("/crear/persona")
    public String crearPersona(@RequestBody Persona per) {
        interPerso.savePersona(per);
        return "Persona creada";
    }

    @DeleteMapping("/delete/persona/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPerso.deletePersona(id);
        return "Persona borrada";
    }

    @PutMapping("edit/persona/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String newNombre,
            @RequestParam("apellido") String newApellido
    ) {
        Persona per = interPerso.getPersona(id);

        per.setApellido(newApellido);
        per.setNombre(newNombre);
        interPerso.savePersona(per);
        return per;
    }
}

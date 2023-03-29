package com.mjlportfolio.mjl.Controller;

import com.mjlportfolio.mjl.Entity.Persona;
import com.mjlportfolio.mjl.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService IPersonaService;

    //@GetMapping Trae de la base de datos al front (muy por arriba)
    @GetMapping("personas/lista")
    public List<Persona> getPersonas() {
        return IPersonaService.getPersonas();
    }

    //@PostMapping desde el Front lo lleva a la base de datos
    // @RequestBody Necesario para agregar una persona
    @PostMapping("/personas/save")
    public String creoPersona(@RequestBody Persona pers) {
        IPersonaService.savePersona(pers);
        return "Persona creada";
    }

    //Borra en la base de datos
    @DeleteMapping("/personas/delete/{id}")
    public String borroPersona(@PathVariable Long id) {
        IPersonaService.deletePersona(id);
        return "Persona eliminada";
    }

    // @PutMapping Edita a una persona
    @PutMapping("/personas/edit/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String newNombre,
            @RequestParam("apellido") String newApellido, @RequestParam("img") String newImg) {
        Persona pers = IPersonaService.findPersona(id);
        pers.setApellido(newApellido);
        pers.setNombre(newNombre);
        pers.setImg(newImg);

        IPersonaService.savePersona(pers);
        return pers;
    }

    @GetMapping("personas/find")
    public Persona buscoPersona() {
        return IPersonaService.findPersona( (long) 1);
    }

}

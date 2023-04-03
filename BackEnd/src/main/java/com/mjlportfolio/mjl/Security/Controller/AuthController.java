package com.mjlportfolio.mjl.Security.Controller;

import com.mjlportfolio.mjl.Security.Dto.JwtDto;
import com.mjlportfolio.mjl.Security.Dto.LoginUsuario;
import com.mjlportfolio.mjl.Security.Dto.NuevoUsuario;
import com.mjlportfolio.mjl.Security.Entity.Rol;
import com.mjlportfolio.mjl.Security.Entity.Usuario;
import com.mjlportfolio.mjl.Security.Enums.RolNombre;
import com.mjlportfolio.mjl.Security.Service.RolService;
import com.mjlportfolio.mjl.Security.Service.UsuarioService;
import com.mjlportfolio.mjl.Security.jwt.JwtProvider;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passEncoder;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UsuarioService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mas puesto o email invalido"), HttpStatus.BAD_REQUEST);
        }

        if (userService.existByNombreUsuario(nuevoUser.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe."), HttpStatus.BAD_REQUEST);
        }

        if (userService.existByEmail(nuevoUser.getEmail())) {
            return new ResponseEntity(new Mensaje("Ese email ya existe."), HttpStatus.BAD_REQUEST);
        }

        Usuario user = new Usuario(nuevoUser.getNombre(),
                nuevoUser.getNombreUsuario(), nuevoUser.getEmail(),
                passEncoder.encode(nuevoUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());

        if (nuevoUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROL_ADMIN).get());
        }

        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Mensaje("Usuario Creado y guardado."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal Puestos."), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreUsuario(), loginUsuario.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}

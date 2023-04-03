package com.mjlportfolio.mjl.Security.Service;

import com.mjlportfolio.mjl.Security.Entity.Rol;
import com.mjlportfolio.mjl.Security.Entity.Usuario;
import com.mjlportfolio.mjl.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iUsuarioRepository.findByRolNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsu) {
        return iUsuarioRepository.existByNombreUsuario(nombreUsu);
    }

    public boolean existByEmail(String email) {
        return iUsuarioRepository.existByEmail(email);
    }

    public void save(Usuario user) {
        iUsuarioRepository.save(user);
    }
}

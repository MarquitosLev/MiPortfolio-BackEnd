package com.mjlportfolio.mjl.Security.Repository;

import com.mjlportfolio.mjl.Security.Entity.Rol;
import com.mjlportfolio.mjl.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
       Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

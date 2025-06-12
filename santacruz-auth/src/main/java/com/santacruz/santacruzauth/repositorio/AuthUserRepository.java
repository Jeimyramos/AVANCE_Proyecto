package com.santacruz.santacruzauth.repositorio;



import com.santacruz.santacruzauth.Entidad.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
    Optional<AuthUser> findByUserName(String userName);
}

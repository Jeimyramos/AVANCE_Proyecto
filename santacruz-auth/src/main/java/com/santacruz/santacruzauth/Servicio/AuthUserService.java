package com.santacruz.santacruzauth.Servicio;

import com.santacruz.santacruzauth.Dto.AuthUserDto;
import com.santacruz.santacruzauth.Entidad.AuthUser;
import com.santacruz.santacruzauth.Entidad.TokenDto;

public interface AuthUserService {
    public AuthUser save(AuthUserDto authUserDto);


    public TokenDto login(AuthUserDto authUserDto);


    public TokenDto validate(String token);
}

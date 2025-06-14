package com.santacruz.santacruzauth.Servicio.Implemento;


import com.santacruz.santacruzauth.Dto.AuthUserDto;
import com.santacruz.santacruzauth.Entidad.AuthUser;
import com.santacruz.santacruzauth.Entidad.TokenDto;
import com.santacruz.santacruzauth.Seguridad.JwtProvider;
import com.santacruz.santacruzauth.Servicio.AuthUserService;
import com.santacruz.santacruzauth.repositorio.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;


    @Override
    public AuthUser save(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authUserRepository.findByUserName((authUserDto.getUserName()));
        if (user.isPresent())
            return null;
        String password = passwordEncoder.encode(authUserDto.getPassword());
        AuthUser authUser = AuthUser.builder()
                .userName(authUserDto.getUserName())
                .password(password)
                .build();




        return authUserRepository.save(authUser);
    }




    @Override
    public TokenDto login(AuthUserDto authUserDto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(authUserDto.getUserName());
        if (!user.isPresent())
            return null;
        if (passwordEncoder.matches(authUserDto.getPassword(), user.get().getPassword()))
            return new TokenDto(jwtProvider.createToken(user.get()));
        return null;
    }




    @Override
    public TokenDto validate(String token) {
        if (!jwtProvider.validate(token))
            return null;
        String username = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUserName(username).isPresent())
            return null;
        return new TokenDto(token);
    }
}

package com.todouno.restController;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.todouno.DTO.JwtDTO;
import com.todouno.DTO.LoginUser;
import com.todouno.DTO.Mensaje;
import com.todouno.DTO.NewUser;
import com.todouno.model.Rol;
import com.todouno.model.RolName;
import com.todouno.model.User;
import com.todouno.repositories.IRepoRol;
import com.todouno.repositories.IRepoUser;
import com.todouno.security.JWT.JwtProvider;
/**
 * clase que maneja las autenticaciones de los usuarios y registro
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 * @version 12/04/2020
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
	//atributo de la clase la cual realiza una instacia cada vez que es requerida gracias a la anotacion @Autowired gracias a este atributo se encriptan las contraseñas
	@Autowired
    PasswordEncoder passwordEncoder;
	//atributo de la clase la cual realiza una instacia cada vez que es requerida gracias a la anotacion @Autowired 
    @Autowired
    AuthenticationManager authenticationManager;
    //atributo de la clase la cual realiza una instacia cada vez que es requerida gracias a la anotacion @Autowired usando la interfaz de repositorio de usuarios para hacer una instancia de 
    //ese repositorio
    @Autowired
    IRepoUser iRepoUser;
    //atributo de la clase la cual realiza una instacia cada vez que es requerida gracias a la anotacion @Autowired usando la interfaz de repositorio de roles  para hacer una instancia de 
    //ese repositorio
    @Autowired
    IRepoRol iRepoRol;
    //atributo donde realiza instancia por usuario para guardar token y sesion entro otras credenciales necesarias
    @Autowired
    JwtProvider jwtProvider;
    
    /**
     * metodo para crear nuevo usuario o usuario en registro
     * @param nuevoUsuario
     * @param bindingResult
     * @return
     */
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser nuevoUsuario, BindingResult bindingResult){
    	System.out.println("ingreso a crear nuevo usuario");
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if(iRepoUser.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(iRepoUser.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        User usuario =
                new User(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<String> rolesStr = nuevoUsuario.getRoles();
        Set<Rol> roles = new HashSet<>();
        for (String rol : rolesStr) {
            switch (rol) {
                case "admin":
                    Rol rolAdmin = iRepoRol.findByRolNombre(RolName.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                default:
                    Rol rolUser = iRepoRol.findByRolNombre(RolName.ROLE_USER).get();
                    roles.add(rolUser);
            }
        }
        usuario.setRoles(roles);
        iRepoUser.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }
    /**
     * metodo para verificar la sesion del usuario una vez este ha verificado retorna de tipo JwtDTO 
     * @param loginUsuario
     * @param bindingResult
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
}

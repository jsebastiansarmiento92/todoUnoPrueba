package com.todouno.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.todouno.model.User;
/**
 * clase donde implementa Userdetails el cual define metodos los cuales la clase JWTProvider usa para tener informacion del usuario y sesion de este
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
public class UserPrincipal implements UserDetails{

	//atributo identificador del usuario (unico)
	private Long id;
	//atributo nombre completo del usuario
	private String nombre;
	//atributo nickname o nombre de cuenta del usuario
	private String nombreUsuario;
	//atributo donde guarda email del usuario
	private String email;
	//atributo donde guarda la contraseña ya encripatada del usuario
	private String password;
	//atributo don guarda privilegios o roles
	private Collection<? extends GrantedAuthority> authorities;



	/**
	 * cosntructor donde guarda la informacion del usuario 
	 * @param id
	 * @param nombre
	 * @param nombreUsuario
	 * @param email
	 * @param password
	 * @param authorities
	 */
	public UserPrincipal(Long id, String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	/**
	 * metodo el cual devuelve el usuario de la sesion
	 * @param usuario
	 * @return
	 */
	public static UserPrincipal build(User usuario){
		List<GrantedAuthority> authorities =
				usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
		return new UserPrincipal(usuario.getId(), usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
	}
	//respectivos metodos set y get
	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * metodo implmentado desde UserDetails el cual devuelve la lista de privilegios de usuario ya guardado
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nombreUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



}

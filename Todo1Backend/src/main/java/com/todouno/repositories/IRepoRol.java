package com.todouno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Rol;
import com.todouno.model.RolName;

@Repository
public interface IRepoRol extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByRolNombre(RolName rolNombre);
	
}

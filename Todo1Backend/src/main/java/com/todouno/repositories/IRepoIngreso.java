package com.todouno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Ingreso;

@Repository
public interface IRepoIngreso extends JpaRepository<Ingreso, Integer> {
	
}

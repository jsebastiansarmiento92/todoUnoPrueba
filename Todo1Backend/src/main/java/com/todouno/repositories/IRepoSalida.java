package com.todouno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Salida;

@Repository
public interface IRepoSalida extends JpaRepository<Salida, Integer> {

}

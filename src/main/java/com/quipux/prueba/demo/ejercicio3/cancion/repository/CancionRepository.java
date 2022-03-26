package com.quipux.prueba.demo.ejercicio3.cancion.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.prueba.demo.ejercicio3.cancion.model.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, BigInteger> {

}

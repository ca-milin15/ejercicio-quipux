package com.quipux.prueba.demo.ejercicio3.listareproducccion.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccionXCanciones;

@Repository
public interface ListaReproduccionXCancionesRepository  extends JpaRepository<ListaReproduccionXCanciones, BigInteger>{

}

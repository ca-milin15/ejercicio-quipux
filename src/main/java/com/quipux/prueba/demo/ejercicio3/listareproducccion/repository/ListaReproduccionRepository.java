package com.quipux.prueba.demo.ejercicio3.listareproducccion.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccion;
import com.quipux.prueba.demo.ejercicio3.usuario.model.Usuario;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, BigInteger>{

	List<ListaReproduccion> findByUsuario(Usuario usuario);
	
}

package com.quipux.prueba.demo.ejercicio3.cancion.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.quipux.prueba.demo.ejercicio3.cancion.model.Cancion;
import com.quipux.prueba.demo.ejercicio3.cancion.repository.CancionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService{

	CancionRepository cancionRepository;
	
	@Override
	public Cancion consultarCancion(BigInteger idCancion) {
		return cancionRepository.findById(idCancion).orElseThrow(() -> new RuntimeException());
	}

}

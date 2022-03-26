package com.quipux.prueba.demo.ejercicio3.cancion.service;

import java.math.BigInteger;

import com.quipux.prueba.demo.ejercicio3.cancion.model.Cancion;

public interface CancionService {

	Cancion consultarCancion(BigInteger idCancion);
}

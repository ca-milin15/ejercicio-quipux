package com.quipux.prueba.demo.ejercicio3.listareproducccion.service;

import java.math.BigInteger;
import java.util.List;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionRequest;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionResponse;

public interface ListaReproduccionService {

	ListaReproduccionResponse crearListaReproduccion(ListaReproduccionRequest listaReproduccionRequest);

	List<ListaReproduccionResponse> obtenerListaReproduccionPorId(BigInteger idListaReproduccion);
	List<ListaReproduccionResponse> obtenerListaReproduccionPorUsuario(BigInteger idUsuario);

	boolean eliminarListaReproduccion(BigInteger idListaReproduccion);
}

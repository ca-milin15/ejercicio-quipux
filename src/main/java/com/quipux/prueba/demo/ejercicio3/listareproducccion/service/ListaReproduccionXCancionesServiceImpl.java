package com.quipux.prueba.demo.ejercicio3.listareproducccion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccionXCanciones;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.repository.ListaReproduccionXCancionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListaReproduccionXCancionesServiceImpl implements ListaReproduccionXCancionesService{

	ListaReproduccionXCancionesRepository listaReproduccionXCancionesRepository;
	
	@Override
	public List<ListaReproduccionXCanciones> asignarCancionesAListaReproduccion(List<ListaReproduccionXCanciones> listaDeListaReproduccionXCanciones) {
		return listaReproduccionXCancionesRepository.saveAll(listaDeListaReproduccionXCanciones);
	}


}

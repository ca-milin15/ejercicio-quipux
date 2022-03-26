package com.quipux.prueba.demo.ejercicio3.listareproducccion.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.Cancion;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccion;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.repository.ListaReproduccionRepository;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.CancionResponse;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionRequest;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionResponse;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.exceptions.ListaReproduccionPersistenciaRuntimeException;
import com.quipux.prueba.demo.ejercicio3.usuario.service.UsuarioService;

@Service
public class ListaReproduccionServiceImpl implements ListaReproduccionService{

	@Autowired
	ListaReproduccionRepository listaReproduccionDAO;
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public ListaReproduccionResponse crearListaReproduccion(ListaReproduccionRequest listaReproduccionRequest) {
		var lista = construirObjetoListaReproduccion(listaReproduccionRequest); 
		var listaReproduccionSaved = construirObjetoListaReproduccion(lista);
		return construirObjetoListaReproduccionResponse(listaReproduccionSaved);
	}

	private ListaReproduccionResponse construirObjetoListaReproduccionResponse(
			ListaReproduccion listaReproduccionSaved) {
		return ListaReproduccionResponse.builder()
				.id(listaReproduccionSaved.getId())
				.nombre(listaReproduccionSaved.getNombre())
				.descripcion(listaReproduccionSaved.getDescripcion())
				.canciones(listaReproduccionSaved.getCanciones().stream().map(cancionEntity -> new CancionResponse(cancionEntity)).collect(Collectors.toList()))
				.build();
	}

	private ListaReproduccion construirObjetoListaReproduccion(ListaReproduccion listaReproduccion) {
		try {
			return listaReproduccionDAO.save(listaReproduccion);
		} catch (Exception e) {
			throw new ListaReproduccionPersistenciaRuntimeException(e.getMessage());
		}
	}
	
	private ListaReproduccion construirObjetoListaReproduccion(ListaReproduccionRequest listaReproduccionRequest) {
		return ListaReproduccion.builder()
				.nombre(listaReproduccionRequest.getNombre())
				.descripcion(listaReproduccionRequest.getDescripcion())
				.canciones(listaReproduccionRequest.getCanciones().stream().map(cancionRequest -> {
					return new Cancion(cancionRequest);
				}).collect(Collectors.toList())).build();
	}

	@Override
	public List<ListaReproduccionResponse> obtenerListaReproduccionPorId(BigInteger idListaReproduccion) {
		return listaReproduccionDAO.findById(idListaReproduccion).stream().map(listaEntity -> construirObjetoListaReproduccionResponse(listaEntity)).collect(Collectors.toList());
	}

	@Override
	public List<ListaReproduccionResponse> obtenerListaReproduccionPorUsuario(BigInteger idUsuario) {
		var usuario = usuarioService.consultarUsuario(idUsuario);
		return listaReproduccionDAO.findByUsuario(usuario).stream().map(listaEntity -> construirObjetoListaReproduccionResponse(listaEntity)).collect(Collectors.toList());
	}

	@Override
	public boolean eliminarListaReproduccion(BigInteger idListaReproduccion) {
		// TODO Reubicar mensaje a .yml del proyecto
		var listaReproduccion = listaReproduccionDAO.findById(idListaReproduccion).orElseThrow(() -> new ListaReproduccionPersistenciaRuntimeException("El ID de la lista de reproduccion no existe en el sistema."));
		listaReproduccionDAO.delete(listaReproduccion);
		return true;
	}
	


}

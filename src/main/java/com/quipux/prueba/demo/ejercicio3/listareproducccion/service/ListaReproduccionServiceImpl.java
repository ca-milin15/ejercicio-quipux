package com.quipux.prueba.demo.ejercicio3.listareproducccion.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quipux.prueba.demo.ejercicio3.cancion.service.CancionService;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccion;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccionXCanciones;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.repository.ListaReproduccionRepository;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.CancionResponse;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionRequest;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionResponse;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.exceptions.ListaReproduccionPersistenciaRuntimeException;
import com.quipux.prueba.demo.ejercicio3.usuario.service.UsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListaReproduccionServiceImpl implements ListaReproduccionService{

	ListaReproduccionRepository listaReproduccionDAO;
	UsuarioService usuarioService;
	CancionService cancionService;
	ListaReproduccionXCancionesService listaReproduccionXCancionesService;

	@Override
	public ListaReproduccionResponse crearListaReproduccion(ListaReproduccionRequest listaReproduccionRequest) {
		var lista = construirObjetoListaReproduccion(listaReproduccionRequest); 
		var listaReproduccionSaved = almacenarListaReproduccion(lista);
		asignarCancionesAListaReproduccion(listaReproduccionSaved, listaReproduccionRequest);
		return construirObjetoListaReproduccionResponse(listaReproduccionSaved);
	}

	private void asignarCancionesAListaReproduccion(ListaReproduccion listaReproduccionSaved,
			ListaReproduccionRequest listaReproduccionRequest) {

		var listaReproduccionXCanciones = listaReproduccionRequest.getCanciones().stream().map(cancionReq -> {
			var cancion = cancionService.consultarCancion(cancionReq.getId());
			return new ListaReproduccionXCanciones(listaReproduccionSaved, cancion);
		}).collect(Collectors.toList());
		listaReproduccionSaved.setListaReproduccionXCanciones(listaReproduccionXCanciones);
		listaReproduccionXCancionesService.asignarCancionesAListaReproduccion(listaReproduccionXCanciones);
	}

	private ListaReproduccionResponse construirObjetoListaReproduccionResponse(
			ListaReproduccion listaReproduccionSaved) {
		return ListaReproduccionResponse.builder()
				.id(listaReproduccionSaved.getId())
				.nombre(listaReproduccionSaved.getNombre())
				.descripcion(listaReproduccionSaved.getDescripcion())
				.canciones(listaReproduccionSaved.getListaReproduccionXCanciones().stream().map(listaReproduccionXCanciones -> new CancionResponse(listaReproduccionXCanciones.getCancion())).collect(Collectors.toList()))
				.build();
	}

	private ListaReproduccion almacenarListaReproduccion(ListaReproduccion listaReproduccion) {
		try {
			return listaReproduccionDAO.save(listaReproduccion);
		} catch (Exception e) {
			throw new ListaReproduccionPersistenciaRuntimeException(e.getMessage());
		}
	}
	
	private ListaReproduccion construirObjetoListaReproduccion(ListaReproduccionRequest listaReproduccionRequest) {
		var usuario = usuarioService.consultarUsuario(listaReproduccionRequest.getIdUsuario());
		return ListaReproduccion.builder()
				.nombre(listaReproduccionRequest.getNombre())
				.descripcion(listaReproduccionRequest.getDescripcion())
				.usuario(usuario)
				.build();
	}

	@Override
	public ListaReproduccionResponse obtenerListaReproduccionPorId(BigInteger idListaReproduccion) {
		var listareprod = listaReproduccionDAO.findById(idListaReproduccion).orElseThrow(() -> new RuntimeException());
		return construirObjetoListaReproduccionResponse(listareprod);
	}

	@Override
	public List<ListaReproduccionResponse> obtenerListaReproduccionPorUsuario(BigInteger idUsuario) {
		var usuario = usuarioService.consultarUsuario(idUsuario);
		return listaReproduccionDAO.findByUsuario(usuario).stream().map(listaEntity -> construirObjetoListaReproduccionResponse(listaEntity)).collect(Collectors.toList());
	}

	@Override
	public boolean eliminarListaReproduccion(BigInteger idListaReproduccion) {
		var listaReproduccion = listaReproduccionDAO.findById(idListaReproduccion).orElseThrow(() -> new ListaReproduccionPersistenciaRuntimeException("El ID de la lista de reproduccion no existe en el sistema."));
		listaReproduccionDAO.delete(listaReproduccion);
		return true;
	}
	


}

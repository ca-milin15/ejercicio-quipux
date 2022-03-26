package com.quipux.prueba.demo.ejercicio3.listareproducccion.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.service.ListaReproduccionService;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionRequest;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.ListaReproduccionResponse;

@RestController
@RequestMapping("listaReproduccion")
public class ListaReproduccionController {

	@Autowired
	ListaReproduccionService listaReproduccionService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ListaReproduccionResponse crearListaReproduccion(@RequestBody ListaReproduccionRequest listaReproduccionRequest){
		return listaReproduccionService.crearListaReproduccion(listaReproduccionRequest);
	}
	

	@GetMapping("/{idListaReproduccion}")
	@ResponseStatus(value = HttpStatus.OK)
	public ListaReproduccionResponse obtenerListaReproduccionPorId(@PathVariable(name = "idListaReproduccion") BigInteger idListaReproduccion){
		return listaReproduccionService.obtenerListaReproduccionPorId(idListaReproduccion);
	}

	@GetMapping("/usuario/{idUsuario}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ListaReproduccionResponse> obtenerListaReproduccionPorIdUSuario(@PathVariable(name = "idUsuario") BigInteger idUsuario){
		return listaReproduccionService.obtenerListaReproduccionPorUsuario(idUsuario);
	}

	@DeleteMapping("/{idListaReproduccion}")
	@ResponseStatus(value = HttpStatus.OK)
	public boolean eliminarListaReproduccion(@PathVariable(name = "idListaReproduccion") BigInteger idUsuario){
		return listaReproduccionService.eliminarListaReproduccion(idUsuario);
	}
}

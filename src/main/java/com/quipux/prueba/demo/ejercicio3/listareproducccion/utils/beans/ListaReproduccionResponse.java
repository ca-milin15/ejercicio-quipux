package com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ListaReproduccionResponse implements Serializable{

	private static final long serialVersionUID = 2562941931013442756L;
	
	BigInteger id;
	String nombre;
	String descripcion;
	List<CancionResponse> canciones;

}

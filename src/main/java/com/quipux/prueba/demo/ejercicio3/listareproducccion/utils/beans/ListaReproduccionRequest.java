package com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ListaReproduccionRequest implements Serializable {

	private static final long serialVersionUID = 9206035657017716251L;

	String nombre;
	String descripcion;
	List<CancionResponse> canciones;
	BigInteger idUsuario;
}

package com.quipux.prueba.demo.ejercicio3.usuario.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.EntidadGeneral;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Usuario  extends EntidadGeneral{

	private static final long serialVersionUID = -3814298507292841937L;

	@Column(name = "usuario")
	String usuario;

	@Column(name = "contrasena")
	String contrasena;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "apellido")
	String apellido;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	List<ListaReproduccion> listasReproduccion;
	
}

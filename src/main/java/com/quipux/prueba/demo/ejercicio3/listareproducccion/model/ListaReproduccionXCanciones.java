package com.quipux.prueba.demo.ejercicio3.listareproducccion.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quipux.prueba.demo.ejercicio3.cancion.model.Cancion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "lista_reproduccion_x_cancion")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ListaReproduccionXCanciones extends EntidadGeneral {
	

	private static final long serialVersionUID = 1744194697521909443L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lista_reproduccion")
	ListaReproduccion listaReproduccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cancion")
	Cancion cancion;
	

	public ListaReproduccionXCanciones(ListaReproduccion listaReproduccionSaved, Cancion cancion) {
		this.listaReproduccion = listaReproduccionSaved;
		this.cancion = cancion;
	}
}

package com.quipux.prueba.demo.ejercicio3.listareproducccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.CancionResponse;

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
public class Cancion extends EntidadGeneral{


	private static final long serialVersionUID = -7316336773867340315L;

	@Column(name = "titulo")
	String titulo;

	@Column(name = "artista")
	String artista;

	@Column(name = "album")
	String album;

	@Column(name = "anno")
	int anno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lista_reproduccion_id")
	ListaReproduccion listaReproduccion;
	

	public Cancion(CancionResponse cancionRequest) {
		this.titulo = cancionRequest.getTitulo();
		this.artista = cancionRequest.getArtista();
		this.album = cancionRequest.getAlbum();
		this.anno = cancionRequest.getAnno();
	}
}

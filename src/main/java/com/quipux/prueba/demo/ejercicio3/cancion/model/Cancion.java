package com.quipux.prueba.demo.ejercicio3.cancion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.EntidadGeneral;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.ListaReproduccionXCanciones;
import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans.CancionResponse;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "cancion")
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cancion")
	List<ListaReproduccionXCanciones> listaReproduccionXCanciones;
	

	public Cancion(CancionResponse cancionRequest) {
		this.titulo = cancionRequest.getTitulo();
		this.artista = cancionRequest.getArtista();
		this.album = cancionRequest.getAlbum();
		this.anno = cancionRequest.getAnno();
	}
}

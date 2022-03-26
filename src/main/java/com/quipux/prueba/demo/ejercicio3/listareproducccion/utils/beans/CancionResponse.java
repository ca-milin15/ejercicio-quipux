package com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.beans;

import java.io.Serializable;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.model.Cancion;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CancionResponse implements Serializable {

	private static final long serialVersionUID = 8235515229489895192L;

	String titulo;
	String artista;
	String album;
	int anno;
	

	public CancionResponse(Cancion cancionEntity) {
		this.titulo = cancionEntity.getTitulo();
		this.artista = cancionEntity.getArtista();
		this.album = cancionEntity.getAlbum();
		this.anno = cancionEntity.getAnno();
	}
}

package com.quipux.prueba.demo.ejercicio3.listareproducccion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.quipux.prueba.demo.ejercicio3.usuario.model.Usuario;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListaReproduccion  extends EntidadGeneral{

	private static final long serialVersionUID = 3671490921028363642L;

	@Column(name = "nombre")
	String nombre;

	@Column(name = "descripcion")
	String descripcion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "listaReproduccion")
	List<Cancion> canciones;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	Usuario usuario;
}

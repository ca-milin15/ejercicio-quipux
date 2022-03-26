package com.quipux.prueba.demo.ejercicio2.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Equipo {
	String nombre;
	String estadio;
	int cantidadTitulos;
	List<Jugador> jugadoresTitulares = new ArrayList<Jugador>();
	List<Jugador> jugadoresSuplentes = new ArrayList<Jugador>();
}

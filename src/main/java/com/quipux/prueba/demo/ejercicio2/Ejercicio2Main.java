package com.quipux.prueba.demo.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.quipux.prueba.demo.ejercicio2.model.Equipo;
import com.quipux.prueba.demo.ejercicio2.model.Jugador;

public class Ejercicio2Main {
	public static void main(String[] args) {
		Equipo equipo = obtenerInformacionDelEquipo();
		generarReporteBasico(equipo);
		generarReporteDetallado(equipo);
	}

	private static void generarReporteDetallado(Equipo equipo) {
		var reporteDetallado = new StringBuilder();
		reporteDetallado.append("Nombre del equipo: ").append(equipo.getNombre()).append("\n \n")
		.append("Jugadores titulares: \n").append(constuirInfoJugadorReporteDet(equipo.getJugadoresTitulares())).append("\n \n")
		.append("Jugadores suplentes: \n").append(constuirInfoJugadorReporteDet(equipo.getJugadoresSuplentes())).append("\n \n").toString();
		JOptionPane.showMessageDialog(null, reporteDetallado);
	}

	private static String constuirInfoJugadorReporteDet(List<Jugador> listaJugador) {
		return listaJugador.stream().map(titular -> {
			return "Nombre jugador: ".concat(titular.getNombre()).concat("\n")
					.concat("Posicion jugador: ").concat(titular.getPosicion()).concat("\n");
		}).collect(Collectors.joining("\n"));
	}
	
	private static void generarReporteBasico(Equipo equipo) {
		var reporteBasico = new StringBuilder();
		reporteBasico.append("Nombre del equipo: ").append(equipo.getNombre()).append("\n")
		.append("Titulos ganadoso: ").append(equipo.getCantidadTitulos()).append("\n")
		.append("CantidadTotal de jugadores: ").append(equipo.getJugadoresTitulares().size() + equipo.getJugadoresSuplentes().size()).append("\n").toString();
		JOptionPane.showMessageDialog(null, reporteBasico);
	}

	private static Equipo obtenerInformacionDelEquipo() {
		var equipo = new Equipo();
		equipo.setNombre(JOptionPane.showInputDialog(null, "Ingrese nombre del equipo"));
		equipo.setEstadio(JOptionPane.showInputDialog(null, "Estadio del equipo"));
		var titulos = JOptionPane.showInputDialog(null, "Cantidad de titulos");
		equipo.setCantidadTitulos(Integer.parseInt(titulos));
		
		obtenerInfoTodosJugadores(equipo);
		
		return equipo;
	}

	static final List<String> TIPO_JUGADOR = new ArrayList<String>() {
		private static final long serialVersionUID = 5951291996484537986L;
		{
			add("Titulares");
			add("Suplentes");
		}
	};
	
	private static void obtenerInfoTodosJugadores(Equipo equipo) {
		for (int j = 0; j < TIPO_JUGADOR.size(); j++) {
			var cantJugadorString = JOptionPane.showInputDialog(null, "Ingrese cantidad de jugadores de tipo: ".concat(TIPO_JUGADOR.get(j)));
			var cantJugador = Integer.parseInt(cantJugadorString);
			if(TIPO_JUGADOR.get(j).contentEquals("Titulares")) {
				equipo.setJugadoresTitulares(obtenerInfoTodosJugadoresXEstado(cantJugador));
			} else {
				equipo.setJugadoresSuplentes(obtenerInfoTodosJugadoresXEstado(cantJugador));
			}
		}
	}
	
	private static List<Jugador> obtenerInfoTodosJugadoresXEstado(int cantidadJugador) {
		var listaJugadores = new ArrayList<Jugador>();
		for (int j = 0; j < cantidadJugador; j++) {
			listaJugadores.add(obtenerInfoJugador());
		}
		return listaJugadores;
	}
	
	private static Jugador obtenerInfoJugador() {
		var jugador = new Jugador();
		jugador.setNombre(JOptionPane.showInputDialog(null, "Ingrese nombre del jugador"));
		jugador.setPosicion(JOptionPane.showInputDialog(null, "Ingrese posicion del jugador"));
		return jugador;
	}
}

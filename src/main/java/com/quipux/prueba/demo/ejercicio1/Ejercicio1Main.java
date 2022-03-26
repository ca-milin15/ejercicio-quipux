package com.quipux.prueba.demo.ejercicio1;

import javax.swing.JOptionPane;

public class Ejercicio1Main {

	public static void main(String[] args) {
		var dialog = JOptionPane.showInputDialog(null, "Ingrese numero entero");
		validacionesVarEntera(dialog);
	}

	private static void validacionesVarEntera(String dialog) {

		var varAsInt = Integer.parseInt(dialog);
		if(varAsInt % 2 != 0) {
			System.out.println("ImPar");
			JOptionPane.showMessageDialog(null, "Quipux");
		} else {
			System.out.println("Par");
			if(varAsInt >= 2 && varAsInt <= 5) {
				JOptionPane.showMessageDialog(null, "No Quipux");
			} else if(varAsInt >= 6 && varAsInt <= 20) {
				JOptionPane.showMessageDialog(null, "Quipux");
			} else if(varAsInt > 20) {
				JOptionPane.showMessageDialog(null, "No Quipux");
			}
		}
	}

}

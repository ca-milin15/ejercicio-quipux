package com.quipux.prueba.demo.ejercicio3.listareproducccion.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@MappedSuperclass
public class EntidadGeneral implements Serializable{

	private static final long serialVersionUID = -78131138528048709L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	BigInteger id;
	
}

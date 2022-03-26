package com.quipux.prueba.demo.ejercicio3.usuario.service;

import java.math.BigInteger;

import com.quipux.prueba.demo.ejercicio3.usuario.model.Usuario;

public interface UsuarioService {

	Usuario consultarUsuario(BigInteger idUsuario);
}

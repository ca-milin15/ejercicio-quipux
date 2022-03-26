package com.quipux.prueba.demo.ejercicio3.usuario.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.quipux.prueba.demo.ejercicio3.listareproducccion.utils.exceptions.UsuarioPersistenciaRuntimeException;
import com.quipux.prueba.demo.ejercicio3.usuario.model.Usuario;
import com.quipux.prueba.demo.ejercicio3.usuario.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario consultarUsuario(BigInteger idUsuario) {
		// TODO Reubicar mensaje a .yml del proyecto
		return usuarioRepository.findById(idUsuario).orElseThrow(() -> new UsuarioPersistenciaRuntimeException("El ID de usuario suministrado no existe en el sistema"));
	}

}

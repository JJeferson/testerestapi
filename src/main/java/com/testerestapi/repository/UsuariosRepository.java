package com.testerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testerestapi.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long>{
	
	Usuarios findById(long id_usuario);
	

}

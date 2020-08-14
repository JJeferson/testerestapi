package com.testerestapi.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testerestapi.repository.UsuariosRepository;
import com.testerestapi.models.Usuarios;

@RestController
@RequestMapping(value="/api")

public class UsuariosResource {
	

	@Autowired
	UsuariosRepository usuariosRepository;
	
	@GetMapping("/usuarios")
	public List<Usuarios> listaUsuarios(){
		return usuariosRepository.findAll();
		
	}
	
	@GetMapping("/usuarios/{id_usuario}")
	public Usuarios listaUsuarioUnico(@PathVariable(value="id_usuario") long id_usuario){
		return usuariosRepository.findById(id_usuario);
		
	}
	
	
	@DeleteMapping("/usuarios")
	public void deletaUsuarios(@RequestBody Usuarios usuarios){
		  usuariosRepository.delete(usuarios);
		
		  /*
		   exemplo Json exclusão
		   {"id_usuario":1} 
		    
		   */
	}
	
	
	@PutMapping("/usuarios")
	public Usuarios alteraUsuarios(@RequestBody Usuarios usuarios){
		  return usuariosRepository.save(usuarios);
		 
			/*
			Exemplo de Json para POST
			 { 
			"id_usuario":3,
	        "tipo_usuario": "Administrador",
	        "chave_usuario": "test22e@teste.com",
	        "nome": "teste",
	        "email": "teste772@teste.com",
	        "senha": "123",
	        "rg": "177219447",
	        "cpf": "0077270p76",
	        "endereco": "rua teste ",
	        "estado": "RS",
	        "pais": "BR",
	        "cep": "93600000",
	        "fone": "1232"
	         } 
			 */
		  
	}
	
	
	
	@PostMapping("/usuarios")
	public Usuarios Usuarios(@RequestBody Usuarios usuarios){
		return usuariosRepository.save(usuarios);
		
		/*
		Exemplo de Json para POST
		 { 
        "tipo_usuario": "Administrador",
        "chave_usuario": "test22e@teste.com",
        "nome": "teste",
        "email": "teste772@teste.com",
        "senha": "123",
        "rg": "177219447",
        "cpf": "0077270p76",
        "endereco": "rua teste ",
        "estado": "RS",
        "pais": "BR",
        "cep": "93600000",
        "fone": "1232"
         } 
		 */
		
	}

} 
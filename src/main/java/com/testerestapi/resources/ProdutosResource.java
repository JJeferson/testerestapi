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

import com.testerestapi.repository.ProdutosRepository;
import com.testerestapi.models.Produtos;
import com.testerestapi.models.Usuarios;

@RestController
@RequestMapping(value="/api")

public class ProdutosResource {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@GetMapping("/produtos")
	public List<Produtos> listaProdutos(){
		return produtosRepository.findAll();
		
	}
	
	
	
	@GetMapping("/produtos/{id_produto}")
	public Produtos listaProdutoUnico(@PathVariable(value="id_produto") long id_produto){
		return produtosRepository.findById(id_produto);
		
	}
	
	
	
	@DeleteMapping("/produtos")
	public void deletaProdutos(@RequestBody Produtos produtos){
		  produtosRepository.delete(produtos);
		
		  /*
		   exemplo Json exclusão
		   {"id_produto":1} 
		    
		   */
	}
	
	
	
	@PutMapping("/produtos")
	public Produtos alteraProdutos(@RequestBody Produtos produtos){
		  return produtosRepository.save(produtos);
		 
			/*
			Exemplo de Json para POST
			 { 
 			 { 
			"id_produto":9,
            "chave_usuario": "TESTE", 
	        "descricao": "Produto teste",           
            "estoque_atual": "33",           
            "vendedor": "Vendedor TESTE",           
            "preco_principal": "45",               
            "preco_compra": "22",              
            "id_tabela_precos": "12"
    
	         }
    
	         } 
			 */
		  
	}
	
	
	@PostMapping("/produtos")
	public Produtos Produtos(@RequestBody Produtos produtos){
		return produtosRepository.save(produtos);
		
		/*
		Exemplo de Json para POST
		 { 
        "tipo_usuario": "Administrador",
        "chave_usuario": "TESTE", 
	    "descricao": "Produto teste",           
        "estoque_atual": "33",           
        "vendedor": "Vendedor TESTE",           
        "preco_principal": "45",               
        "preco_compra": "22",              
        "id_tabela_precos": "12"
    
         } 
		 */
		
	}
	
	
	
	
}

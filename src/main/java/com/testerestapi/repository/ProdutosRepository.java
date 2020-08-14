package com.testerestapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.testerestapi.models.Produtos; 

public interface ProdutosRepository extends JpaRepository<Produtos,Long>{
	
	Produtos findById(long id_produto);
	

}
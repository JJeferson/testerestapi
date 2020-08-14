 
package com.testerestapi.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")

public class Produtos implements Serializable{

	
	
    private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long   id_produto; 
    private String chave_usuario; 
	private String descricao;           
    private String estoque_atual;           
    private String vendedor;           
    private String preco_principal;               
    private String preco_compra;              
    private String id_tabela_precos;
    
    
	public long getId_produto() {
		return id_produto;
	}
	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}
	public String getChave_usuario() {
		return chave_usuario;
	}
	public void setChave_usuario(String chave_usuario) {
		this.chave_usuario = chave_usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEstoque_atual() {
		return estoque_atual;
	}
	public void setEstoque_atual(String estoque_atual) {
		this.estoque_atual = estoque_atual;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getPreco_principal() {
		return preco_principal;
	}
	public void setPreco_principal(String preco_principal) {
		this.preco_principal = preco_principal;
	}
	public String getPreco_compra() {
		return preco_compra;
	}
	public void setPreco_compra(String preco_compra) {
		this.preco_compra = preco_compra;
	}
	public String getId_tabela_precos() {
		return id_tabela_precos;
	}
	public void setId_tabela_precos(String id_tabela_precos) {
		this.id_tabela_precos = id_tabela_precos;
	}   
    
    
    
    
    
}

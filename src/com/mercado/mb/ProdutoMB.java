package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.ProdutoDAO;
import com.mercado.modelo.Produto;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB {

	private Produto produto;
	private AbstractDAO<Produto> produtoDAO;
	private List<Produto> produtos;

	private String erro;

	public ProdutoMB() {
		produto = new Produto();
		produtoDAO = new ProdutoDAO();
		setProdutos(new ArrayList<Produto>());
	}

	public String getSalvarProduto() {
		try {
			produtoDAO.adicionar(produto);
			this.produto = new Produto();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.setErro(ex.getMessage());
			return "erro";
		}
		return "sucesso"; // string que leva para pagina de cadastro realizado
	}
	
	public String getExcluir(Produto prod){
		try {
			produtos.remove(prod);
			this.produto = new Produto();			
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String getPesquisar(){
		try{
			this.produtos = produtoDAO.getLista(produto);			
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa		
	}

	public String getIndex() {

		return "index";
	}
	
	public String getCadastrar(){
		
		return "cadastrarProduto";
	}
	
	public Produto getProduto(){
		
		return produto;
	}
	
	public void setProduto(Produto prod){
		
		this.produto = prod;
	}
	
	public List<Produto> getProdutos(){
		
		produtos = produtoDAO.getLista(produto);
		return produtos;
	}
	
	public void setProdutos(List<Produto> produs){
		
		this.produtos = produs;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

package com.closet.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.closet.dao.AbstractDAO;
import com.closet.dao.PecaDAO;
import com.closet.modelo.Peca;

@ManagedBean(name = "pecaMB")
@SessionScoped
public class PecaMB {

	private Peca produto;
	private AbstractDAO<Peca> produtoDAO;
	private List<Peca> produtos;

	private String erro;

	public PecaMB() {
		produto = new Peca();
		produtoDAO = new PecaDAO();
		setProdutos(new ArrayList<Peca>());
	}

	public String getSalvarProduto() {
		try {
			produtoDAO.adicionar(produto);
			this.produto = new Peca();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.setErro(ex.getMessage());
			return "erro";
		}
		return "sucesso"; // string que leva para pagina de cadastro realizado
	}
	
	public String getExcluir(Peca prod){
		try {
			produtos.remove(prod);
			this.produto = new Peca();			
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
	
	public Peca getProduto(){
		
		return produto;
	}
	
	public void setProduto(Peca prod){
		
		this.produto = prod;
	}
	
	public List<Peca> getProdutos(){
		
		produtos = produtoDAO.getLista(produto);
		return produtos;
	}
	
	public void setProdutos(List<Peca> produs){
		
		this.produtos = produs;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

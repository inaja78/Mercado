package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.CompraDAO;
import com.mercado.modelo.Compra;

public class CompraMB {
	private Compra compra;
	private AbstractDAO<Compra> compraDAO;
	private List<Compra> compras;
	
	private String erro;
	
	public CompraMB(){
		compra = new Compra();
		compraDAO =  new CompraDAO();
		setCompras(new ArrayList<Compra>());		
	}
	
	public String Salvar(){
		try{
			compraDAO.adicionar(compra);
			this.compra = new Compra();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "sucesso"; //string que leva para pagina de cadastro realizado
	}
	
	public String Excluir(Compra comp){
		try{
			compras.remove(comp);
			this.compra = new Compra();
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String Pesquisar(){
		try{
			this.compras = compraDAO.getLista(compra);
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String Editar(){
		
		return "alterar";
	}
	
	public Compra getCompra(){
		
		return compra;
	}
	
	public void setCompra(Compra compr){
		
		this.compra = compr;
	}
		
	public List<Compra> getCompras(){
		compra = (Compra) compraDAO.getLista(compra);
		return compras;
	}
	
	public void setCompras(List<Compra> compras){
		this.compras = compras;
	}
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

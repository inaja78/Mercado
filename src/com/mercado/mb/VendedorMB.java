package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.VendedorDAO;
import com.mercado.modelo.Vendedor;


public class VendedorMB {
	
	private Vendedor vendedor;
	private AbstractDAO<Vendedor> vendedorDAO;
	private List<Vendedor> vendedores;
	
	private String erro;
	
	public VendedorMB(){
		vendedor = new Vendedor();
		vendedorDAO = new VendedorDAO();
		setVendedores(new ArrayList<Vendedor>());
	}
	
	public String Salvar(){
		try{
			vendedorDAO.adicionar(vendedor);
			this.vendedor = new Vendedor();			
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso"; //string que leva para pagina de cadastro realizado 
	}
	
	public String Excluir(Vendedor vend){
		try{
			vendedores.remove(vend);
			this.vendedor = new Vendedor();			
			
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado		
	}
	
	public String Pesquisar(){
		try{
			this.vendedores = vendedorDAO.getLista(vendedor);
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
	
	public Vendedor getVendedor(){
		
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor){
		
		this.vendedor = vendedor;
	}
	
	public List<Vendedor> getVendedores(){
		vendedores = vendedorDAO.getLista(vendedor);
		return vendedores;
	}
	
	public void setVendedores(List<Vendedor> vendedores){
		this.vendedores = vendedores;
	}
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

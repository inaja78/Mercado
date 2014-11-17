package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.VendaDAO;
import com.mercado.modelo.Venda;

public class VendaMB {
	
	private Venda venda;
	private AbstractDAO<Venda> vendaDAO;
	private List<Venda> vendas;
	
	private String erro;
	
	public VendaMB(){
		venda = new Venda();
		vendaDAO = new VendaDAO();
		setVendas(new ArrayList<Venda>());
	}
	
	public String salvar(){
		try{
			vendaDAO.adicionar(venda);
			this.venda = new Venda();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "sucesso"; //string que leva para pagina de cadastro realizado
	}
	
	public String excluir(Venda ven){
		try{
			vendas.remove(ven);
			this.venda = new Venda();
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String pesquisar(){
		try{
			this.vendas = vendaDAO.getLista(venda);
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String editar(){
		
		return "alterar";
	}
		
	public List<Venda> getVendas(){
		vendas = vendaDAO.getLista(venda);
		return vendas;
	}
	
	public void setVendas(List<Venda> vendas){
		this.vendas = vendas;
	}
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

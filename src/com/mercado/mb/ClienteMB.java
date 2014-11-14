package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.ClienteDAO;
import com.mercado.modelo.Cliente;

public class ClienteMB {
	
	private Cliente cliente;
	private AbstractDAO<Cliente> clienteDAO;
	private List<Cliente> clientes;
	
	private String erro;
	
	public ClienteMB(){
		cliente = new Cliente();
		clienteDAO = new ClienteDAO();
		setClientes(new ArrayList<Cliente>());
	}
	
	public String salvar(){
		try{
			clienteDAO.adicionar(cliente);
			this.cliente = new Cliente();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "sucesso"; //string que leva para pagina de cadastro realizado 		
	}
	
	public String excluir(Cliente cli){
		try{
			clientes.remove(cli);
			this.cliente = new Cliente();			
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String pesquisar(){
		try{
			this.clientes = clienteDAO.getLista(cliente);
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String editar(){
		
		return "alterar"; //string que leva para pagina de cadastro
	}

	public List<Cliente> getClientes() {
		clientes = clienteDAO.getLista(cliente);
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
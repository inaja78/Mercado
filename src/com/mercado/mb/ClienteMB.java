package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.ClienteDAO;
import com.mercado.modelo.Cliente;

public class ClienteMB {
	
	private Cliente cliente;
	private AbstractDAO<Cliente> clienteDAO;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteMB(){
		cliente = new Cliente();
		clienteDAO = new ClienteDAO();
		setClientes(new ArrayList<Cliente>());
	}
	
	public String salvar(){
		
		return "sucesso! "; //string que leva para pagina de cadastro realizado 
		
	}
	
	public String excluir(){
		
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String pesquisar(){
		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String editar(){
		
		return "alterar"; //string que leva para pagina de cadastro
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public AbstractDAO<Cliente> getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(AbstractDAO<Cliente> clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}

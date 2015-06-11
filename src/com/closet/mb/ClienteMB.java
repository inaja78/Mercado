package com.closet.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.closet.dao.AbstractDAO;
import com.closet.dao.ClienteDAO;
import com.closet.modelo.Cliente;

@ManagedBean(name="clienteBean")
@SessionScoped
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
	
	public void Teste() {
		System.out.println("teste");
	}
	
	public String salvarCliente(){
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
	
	public String Excluir(Cliente cli){
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
	
	public String getPesquisar(){
		try{
			this.clientes = clienteDAO.getLista(cliente);
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String getIndex(){
		
		return "index";
	}
	
	public String getCadastrarCliente(){
		
		return "cliente"; //string que leva para pagina de cadastro
	}
	
	public String getEditar(){
		
		return "cliente"; //string que leva para pagina de cadastro
	}
	
	public void setCliente(Cliente clie){
		
		this.cliente = clie;
	}
	
	public Cliente getCliente(){
		
		return cliente;
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
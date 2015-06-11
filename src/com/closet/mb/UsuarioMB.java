package com.closet.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.closet.dao.LoginDAO;
import com.closet.modelo.Usuario;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioMB {

	private Usuario usuario;
	private List<LoginDAO> loginDAO;
	private List<Usuario> usuarios;

	private String erro;

	public UsuarioMB() {
		usuario = new Usuario();
		loginDAO = (new ArrayList<LoginDAO>());
		setUsuario(new ArrayList<Usuario>());

	}

	public void getAdicionarUsuario() {
		System.out.println("Adicionar usuario " + usuario.getLogin());
		usuarios.add(usuario);
		usuario = new Usuario();
	}
	
	public String getLogin(Usuario user){
		if(usuario.getSenha().equals(loginDAO)){
			return "home";
		}
		else{
			return "erro";
		}		
	}
	
	public String getCadastrarUsuario(){
		
		return "cadastrarUsuario";
	}

	public String Editar() {

		return "alterar"; // string que leva para pagina de cadastro
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario user) {

		this.usuario = user;
	}

	public void setUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}

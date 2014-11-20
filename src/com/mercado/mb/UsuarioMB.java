package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import com.mercado.modelo.Usuario;

public class UsuarioMB {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private String erro;
	
	public UsuarioMB(){
		usuario = new Usuario();
		setUsuario(new ArrayList<Usuario>());
		
	}
	
	public void adicionarUsuario() {
	    System.out.println("Adicionar usuario " + usuario.getLogin());
	    usuarios.add(usuario);
	    usuario = new Usuario();
	  }
	
	public String editar(){
		
		return "alterar"; //string que leva para pagina de cadastro
	}

	public Usuario getUsuario() {
	    return usuario;
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

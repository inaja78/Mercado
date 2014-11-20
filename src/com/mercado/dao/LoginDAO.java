package com.mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mercado.modelo.Usuario;

public class LoginDAO {
	
	protected Connection conn;
	
	public LoginDAO(){
		super();
		try {
			conn = FabricaConexao.getInstance().getConexao();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> getUsuarios() {
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Usario");
			ResultSet rs = ptmt.executeQuery();
			ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
			
			while(rs.next()) {
				Usuario u1 = new Usuario();
				u1.setLogin(rs.getString("login"));
				u1.setSenha(rs.getString("senha"));
				listaUsuarios.add(u1);
			}
			rs.close();
			ptmt.close();
			return listaUsuarios;
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}		
	}

}

package com.closet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.modelo.Usuario;

public class LoginDAO {
	
	protected Connection conn;
	private List<Usuario> user = new ArrayList<Usuario>();
	
	public LoginDAO(){
		super();
		user = new ArrayList<Usuario>();
		try {
			conn = FabricaConexao.getInstance().getConexao();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> getUsuarios() {
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from USUARIO where senha like ?");
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				Usuario u1 = new Usuario();
				u1.setSenha(rs.getString("senha"));
				user.add(u1);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}	
		return (ArrayList<Usuario>) user;
	}

}

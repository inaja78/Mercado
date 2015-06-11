package com.closet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/closet";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "bibi";
	
	private static FabricaConexao fabricaConexao = null; 
	
	private FabricaConexao(){
		try{
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConexao() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conn;
	}
	
	public static FabricaConexao getInstance(){
		if(fabricaConexao == null){
			fabricaConexao = new FabricaConexao();			
		}
		return fabricaConexao;
	}
	
}

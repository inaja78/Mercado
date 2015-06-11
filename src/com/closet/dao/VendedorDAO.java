package com.closet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.modelo.Vendedor;

public class VendedorDAO extends AbstractDAO<Vendedor>{
	
	private List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
	
	public VendedorDAO(){
		super();
		listaVendedor = new ArrayList<Vendedor>();
	}

	@Override
	public List<Vendedor> getLista(Vendedor vendedor) {
		
		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from VENDEDOR");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				listaVendedor = new ArrayList<Vendedor>();
				listaVendedor.add(vendedor);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listaVendedor;
		/*try {
			PreparedStatement ptmt = conn.prepareStatement("select * from VENDEDOR where nome like ?");
			ptmt.setString(1, "%" + vendedor.getNome() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				vendedor = new Vendedor();
				listaVendedor.add(vendedor);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaVendedor;*/
	}

	@Override
	public List<Vendedor> getLista() {
		return listaVendedor;
	}
	
	public void adicionar(Vendedor vendedor) {
		try{
			PreparedStatement ptmt = conn.prepareStatement("insert into VENDEDOR(cpf, nome) values (?, ?)");
			ptmt.setString(1, vendedor.getCpf());
			ptmt.setString(2, vendedor.getNome());
			ptmt.executeUpdate();
			ptmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		listaVendedor.add(vendedor);		
	}
	
	public void remover(Vendedor vendedor) {
		/*		try {
		PreparedStatement stmt;
		stmt = conexao.prepareStatement(sql);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}*/
		
	}

}

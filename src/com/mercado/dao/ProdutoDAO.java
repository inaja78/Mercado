package com.mercado.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mercado.modelo.Produto;

public class ProdutoDAO extends AbstractDAO<Produto>{
	
	private List<Produto> listaProduto = new ArrayList<Produto>();
	
	public ProdutoDAO(){
		super();
		listaProduto = new ArrayList<Produto>();
	}
	
	public List<Produto> getLista(Produto produto) {
		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from Produto where nome like ?");
			ptmt.setString(1, "%" + produto.getNome() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				listaProduto.add(produto);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaProduto;
	}

	public List<Produto> getLista() {
		return listaProduto;
	}

	public void adicionar(Produto produto) {
		try {
			PreparedStatement ptmt = conn.prepareStatement("insert into Produto(codigo, nome, qtdVenda, qtdCompra, qtdEstoque, valor) values (?, ?, ?, ?, ?, ?)");
			ptmt.setInt(1, produto.getCodigo());
			ptmt.setString(2, produto.getNome());
			ptmt.setInt(3, produto.getQtdVenda());
			ptmt.setInt(4, produto.getQtdCompra());
			ptmt.setInt(5, produto.getQtdEstoque());
			ptmt.setFloat(6, produto.getValor());
			ptmt.executeUpdate();
			ptmt.close();
		} catch (SQLException e) {
    			throw new RuntimeException(e);
		}
		listaProduto.add(produto);
	}

	public void remover(Produto objeto) {
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

package com.closet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.modelo.Peca;

public class PecaDAO extends AbstractDAO<Peca>{
	
	//private PecaDAO pecaDAO;
	private List<Peca> listaProduto = new ArrayList<Peca>();
	
	public PecaDAO(){
		super();
		listaProduto = new ArrayList<Peca>();
	}
	
	public List<Peca> getLista(Peca produto) {
		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from PRODUTO where nome like ?");
			ptmt.setString(1, "%" + produto.getNome() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				produto = new Peca();
				listaProduto.add(produto);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaProduto;
	}

	public List<Peca> getLista() {
		return listaProduto;
	}

	public void adicionar(Peca produto) {
		try {
			PreparedStatement ptmt = conn.prepareStatement("insert into PRODUTO(codigo, nome, qtd_venda, qtd_compra, qtd_estoque, valor) values (?, ?, ?, ?, ?, ?)");
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

	public void remover(Peca objeto) {
/*		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
			}*/
		
	}
	
	public boolean Remover(Peca obj) {
        if ((obj.getCodigo() > 0)) {
            try {
                //Seta o atributo ativo com valor '0'
                PreparedStatement sqlUpdate = conn.prepareStatement("update produto set ativo = 0 where IdProduto=?");
                sqlUpdate.setInt(1, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
	

}

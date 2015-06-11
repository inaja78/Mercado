package com.closet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.modelo.Compra;
import com.closet.modelo.Peca;
import com.closet.modelo.Vendedor;

public class CompraDAO extends AbstractDAO<Compra>{
	
	private List<Peca> listaProduto = new ArrayList<Peca>();
	private List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
	private List<Compra> listaCompra = new ArrayList<Compra>();
	
	public CompraDAO(){
		super();
		listaCompra = new ArrayList<Compra>();
	}
	
	public void adicionar(Compra compra) {
		try{
			PreparedStatement ptmt = conn.prepareStatement("insert into COMPRA (cod_compra, cpf_vendedor, itens, qtd_itens, valor_total) values (?, ?, ?, ?, ?)");
			ptmt.setInt(1, compra.getCod_compra());
			ptmt.setString(2, compra.getCpfVendedor());
			ptmt.setInt(3, compra.getItens());
			ptmt.setInt(4, compra.getQtd_itens());
			ptmt.setDouble(5, compra.getValorTotal());
			ptmt.executeUpdate();
			ptmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		listaCompra.add(compra);
		
	}
	
	public void remover(Compra compra) {
		/*		try {
		PreparedStatement stmt;
		stmt = conexao.prepareStatement(sql);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}*/
	}

	public List<Compra> getLista(Compra compra) {
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from COMPRA where cod_compra = ?");
			ptmt.setInt(1, compra.getCod_compra());
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
				compra = new Compra();
				listaCompra.add(compra);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaCompra;
	}
	
	public List<Peca> getListaProduto(Peca produto){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from PRODUTO where codigo like ?");
			ptmt.setString(1, "%" + produto.getCodigo() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
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
	
	public List<Vendedor> getListaVendedor(Vendedor vendedor){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from VENDEDOR where cpf like ?");
			ptmt.setString(1, "%" + vendedor.getCpf() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
				vendedor = new Vendedor();
				listaVendedor.add(vendedor);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaVendedor;
	}

	public List<Compra> getLista() {
	
		return listaCompra;
	}

}

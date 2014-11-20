package com.mercado.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mercado.modelo.Produto;
import com.mercado.modelo.Compra;
import com.mercado.modelo.Vendedor;

public class CompraDAO extends AbstractDAO<Compra>{
	
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
	private List<Compra> listaCompra = new ArrayList<Compra>();
	
	public CompraDAO(){
		super();
		listaCompra = new ArrayList<Compra>();
	}
	
	public void adicionar(Compra compra) {
		try{
			PreparedStatement ptmt = conn.prepareStatement("insert into Venda (cod_compra, cpfVendedor, itens, qtd_itens, dataCompra, valorTotal) values (?, ?, ?, ?, ?, ?)");
			ptmt.setInt(1, compra.getCod_compra());
			ptmt.setString(2, compra.getCpfVendedor());
			ptmt.setInt(3, compra.getItens());
			ptmt.setInt(4, compra.getQtd_itens());
			ptmt.setDate(5, (Date) compra.getDataCompra());
			ptmt.setDouble(6, compra.getValorTotal());
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
			PreparedStatement ptmt = conn.prepareStatement("select * from Compra where cod_compra like ?");
			ptmt.setString(1, "%" + compra.getCod_compra() + "%");
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
	
	public List<Produto> getListaProduto(Produto produto){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Produto where codigo like ?");
			ptmt.setString(1, "%" + produto.getCodigo() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
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
	
	public List<Vendedor> getListaVendedor(Vendedor vendedor){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Vendedor where cpf like ?");
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

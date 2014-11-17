package com.mercado.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mercado.modelo.Produto;
import com.mercado.modelo.Venda;
import com.mercado.modelo.Cliente;

public class VendaDAO  extends AbstractDAO<Venda>{
	
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private List<Venda> listaVenda = new ArrayList<Venda>();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public VendaDAO(){
		super();
		listaVenda = new ArrayList<Venda>();
	}
	
	public void adicionar(Venda venda){
		try{
			PreparedStatement ptmt = conn.prepareStatement("insert into Venda (codigo, cpfCliente, itens, qtd_itens, dataVenda, valorTotal) values (?, ?, ?, ?, ?, ?)");
			ptmt.setInt(1, venda.getCodigo());
			ptmt.setString(2, venda.getCpfCliente());
			ptmt.setInt(3, venda.getItens());
			ptmt.setInt(4, venda.getQtd_itens());
			ptmt.setDate(5, (Date) venda.getDataVenda());
			ptmt.setDouble(6, venda.getValorTotal());
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		listaVenda.add(venda);
	}
	
	public void remover(Venda venda){
		/*		try {
		PreparedStatement stmt;
		stmt = conexao.prepareStatement(sql);
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}*/
	}
	
	public List<Venda> getLista(Venda venda){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Venda where codigo like ?");
			ptmt.setString(1, "%" + venda.getCodigo() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
				venda = new Venda();
				listaVenda.add(venda);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaVenda;
	}
	
	public List<Venda> getLista(){
		
		return listaVenda;
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
	
	public List<Cliente> getListaCliente(Cliente cliente){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Cliente where cpf like ?");
			ptmt.setString(1, "%" + cliente.getCpf() + "%");
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()){
				cliente = new Cliente();
				listaCliente.add(cliente);
			}
			rs.close();
			ptmt.close();
			} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaCliente;
	}	

}

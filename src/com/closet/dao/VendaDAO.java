package com.closet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.modelo.Cliente;
import com.closet.modelo.Peca;
import com.closet.modelo.Venda;

public class VendaDAO  extends AbstractDAO<Venda>{
	
	private List<Peca> listaProduto = new ArrayList<Peca>();
	private List<Venda> listaVenda = new ArrayList<Venda>();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public VendaDAO(){
		super();
		listaVenda = new ArrayList<Venda>();
	}
	
	public void adicionar(Venda venda){
		try{
			PreparedStatement ptmt = conn.prepareStatement("insert into VENDA (codigo, cpf_cliente, itens, qtd_itens, valor_total) values (?, ?, ?, ?, ?)");
			ptmt.setInt(1, venda.getCodigo());
			ptmt.setString(2, venda.getCliente().getCpf());
			ptmt.setInt(3, venda.getItemVenda().getProduto().getCodigo());
			ptmt.setInt(4, venda.getItemVenda().getQtd_venda());
			ptmt.setDouble(5, venda.getValorTotal());
			ptmt.executeUpdate();
			ptmt.close();
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
	
	public List<Venda> getLista(Venda venda){
		try{
			PreparedStatement ptmt = conn.prepareStatement("select * from Venda where codigo = ?");
			ptmt.setInt(1, venda.getCodigo());
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

package com.closet.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private int codigo;
	private Date dataVenda;
	private float valorTotal;
	private Cliente cliente;
	private ItemVenda itemVenda;
	private List<ItemVenda> itensVenda;
	//private String cpfCliente;
	//private int itens;
	//private int qtd_itens;
	
	
	
	//private Produto produto;
	
	public Venda(){
		cliente = new Cliente();
		itemVenda = new ItemVenda();
	}
	

	public Venda(Cliente cliente, ItemVenda itemVenda){
		this.cliente = cliente;
		this.itemVenda = itemVenda;
		this.itensVenda = new ArrayList<ItemVenda>();
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/*public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getItens() {
		return itens;
	}

	public void setItens(int itens) {
		this.itens = itens;
	}
	
	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}
*/
	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	
/*	public Produto getProduto(){
		
		return produto;
	}
	
	public void setProduto(Produto prod){
		
		this.produto = prod;
	}
	
	public float getTotal(){
		
		return itemVenda.getValor() * qtd_itens;
	}
	
	public String toString() {
        return this.cpfCliente;
    }*/

}

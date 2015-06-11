package com.closet.modelo;

import java.util.Date;

public class Compra {
	private int cod_compra;
	private String cpfVendedor;
	private int itens;
	private int qtd_itens;
	private Date dataCompra;
	private float valorTotal;
	
	private Vendedor vendedor;

	public int getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}

	public String getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(String cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
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

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public String toString() {
        return this.cpfVendedor	;
    }

}

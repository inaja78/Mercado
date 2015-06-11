package com.closet.modelo;

public class ItemCompra {
	private int cod_compra;
	private int cod_produto;
	private int qtd_compra;
	private float valor;
	
	private Peca produto;

	public int getCod_compra() {
		return cod_compra;
	}

	public void setCod_compra(int cod_compra) {
		this.cod_compra = cod_compra;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQtd_compra() {
		return qtd_compra;
	}

	public void setQtd_compra(int qtd_compra) {
		this.qtd_compra = qtd_compra;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Peca getProduto() {
		return produto;
	}

	public void setProduto(Peca produto) {
		this.produto = produto;
	}
	
	/*public String toString() {
    return this.nome;
	}*/


}

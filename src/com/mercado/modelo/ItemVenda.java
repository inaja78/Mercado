package com.mercado.modelo;

public class ItemVenda {
	private int cod_venda;
	private int cod_produto;
	private int qtd_venda;
	private float valor;
	
	private Produto produto;

	public int getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(int cod_venda) {
		this.cod_venda = cod_venda;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQtd_venda() {
		return qtd_venda;
	}

	public void setQtd_venda(int qtd_venda) {
		this.qtd_venda = qtd_venda;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	/*public String toString() {
        return this.nome;
    }*/
	
}

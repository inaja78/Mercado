package com.closet.modelo;

public class ItemVenda {
	private int cod_venda;
	private Venda venda;
	private int qtd_venda;
	private float valor;
	
	private Peca produto;
	
	public ItemVenda(){
		produto = new Peca();
	}
	
	public ItemVenda(Peca produto, int qtd_venda, int cod_venda){
		this.produto = produto;
		this.qtd_venda = qtd_venda;
		this.cod_venda = cod_venda;
	}

	public int getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(int cod_venda) {
		this.cod_venda = cod_venda;
	}

	/*public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}*/
	
	public int getQtd_venda() {
		return qtd_venda;
	}

	public void setQtd_venda(int qtd_venda) {
		this.qtd_venda = qtd_venda;
	}

	public float getValor1() {
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
	
	public Float getValor(){
		
		return produto.getValor() * qtd_venda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	/*public String toString() {
        return this.nome;
    }*/
	
}

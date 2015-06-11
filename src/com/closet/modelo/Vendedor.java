package com.closet.modelo;

public class Vendedor {
	private String cpf;
	private String nome;
	
	public Vendedor(){
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
        return this.cpf;
    }

}

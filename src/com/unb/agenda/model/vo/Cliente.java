package com.unb.agenda.model.vo;

public class Cliente {
	
	private int id;
	private String nome;
	private String endereco;
	private int cpf;
	

	public Cliente(){
		
	}
	
	public Cliente(int id, String nome, String endereco, int cpf){
		this.id = id;
		this.nome=nome;
		this.endereco = endereco;
		this.cpf=cpf;				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


}

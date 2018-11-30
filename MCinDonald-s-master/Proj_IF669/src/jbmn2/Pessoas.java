package jbmn2;
public abstract class Pessoas {
	private String cpf;
	private String nome;
	private int idade;
	
	public Pessoas(String cpf, String nome, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	
	
	
}



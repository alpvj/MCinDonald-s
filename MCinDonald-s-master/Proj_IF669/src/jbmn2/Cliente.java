package jbmn2;

public class Cliente extends Pessoas{
	
	private String pratoPreferido;
	
	public Cliente(String cpf, String nome, int idade, String pratoPreferido) {
		super(cpf,nome,idade);
		this.pratoPreferido = pratoPreferido;
	}
	
	public String getPratoPreferido() {
		return this.pratoPreferido;
	}
	
	
}
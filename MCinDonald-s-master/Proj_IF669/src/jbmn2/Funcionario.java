package jbmn2;

public class Funcionario extends Pessoas{
	private int rg;
	private String cargo;
	private String endereco;
	private String estadoCivil;
	private String antecedentesCriminais;
	
	public Funcionario(String cpf, String nome, int idade, int rg, String cargo, String endereco, String estadoCivil, String antecedentesCriminais) {
		super(cpf,nome,idade);
		this.rg = rg;
		this.cargo = cargo;
		this.endereco = endereco;
		this.estadoCivil = estadoCivil;
		this.antecedentesCriminais = antecedentesCriminais;
	}
	
	public int getRg() {
		return this.rg;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public String getEstadoCivil() {
		return this.estadoCivil;
	}
	
	public String getAntecedentesCriminais() {
		return this.antecedentesCriminais;
	}

	public String getCargo() {
		return cargo;
	}

}

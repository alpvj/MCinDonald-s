package alpvj;

public class Sobremesas {
	private String nome;
	private double preco;

	Sobremesas() {
		this.nome = null;
		this.preco = 0;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return this.nome;
	}

	public double getPreco() {
		return this.preco;
	}
}
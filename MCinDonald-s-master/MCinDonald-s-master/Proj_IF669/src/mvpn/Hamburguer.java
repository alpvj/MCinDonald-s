package mvpn;

public class Hamburguer {
	private double preco;
	private String nome;
	

	public Hamburguer(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean verificar(String nome) {
		boolean tem = false;
		if (this.nome == nome) {
			tem = true;
		}
		return tem;
	}

	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
}

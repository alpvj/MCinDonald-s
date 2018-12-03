package dvcc;

public class CafeManha {

	private String nome;
	private double valor;

	public CafeManha() {
		this.nome = null;
		this.valor = 0;
	}

	public void setValor(double valor) {
		this.valor = valor;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return this.valor;
	}

	public String getNome() {
		return this.nome;
	}
}

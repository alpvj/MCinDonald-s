package dvcc;

public class CafeManha {
	private String nome;
	private double preco;

	CafeManha(){
		this.nome = null;
		this.preco = 0;
	}
    public void setPreco(double preco) {
    	this.preco = preco;
		
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public double getPreco() {
		return this.preco;
	}
	public String getNome(){
		return this.nome;
	}

}

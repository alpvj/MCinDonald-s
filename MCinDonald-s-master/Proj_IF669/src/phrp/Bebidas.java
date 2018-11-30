package phrp;
public class Bebidas {
	
	  private String tipo;
      private String sabor;
      private char tamanho;     
      private double preco;
      
      
      public Bebidas (String tipo, String sabor, char tamanho, double preco) {
      	this.tipo = tipo;
      	this.sabor = sabor;
      	this.tamanho = tamanho;
      	this.preco = preco;
      	
      }
      
		public String getTipo() {
			return this.tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getSabor() {
			return this.sabor;
		}
		public void setSabor(String sabor) {
			this.sabor = sabor;
		}
		public char getTamanho() {
			return this.tamanho;
		}
		public void setTamanho(char tamanho) {
			this.tamanho = tamanho;
		}
		public double getPreco() {
			return this.preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}     
}
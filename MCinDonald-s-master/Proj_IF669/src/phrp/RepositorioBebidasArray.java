package phrp;
public class RepositorioBebidasArray implements RepositorioBebidas {

	Bebidas[] arrayBebidas;

	public RepositorioBebidasArray() {
		this.arrayBebidas = new Bebidas[200];
	}

	public void inserir(Bebidas bebida) {

		int index = 0;
		boolean pausa = false;

		for (int i = 0; i < this.arrayBebidas.length && !pausa; i++) {

			if (this.arrayBebidas[i] == null) {

				index = i;
				pausa = !pausa;

			}
		}

		this.arrayBebidas[index] = bebida;
	}

	public void remover(Bebidas bebida) {

		int index = 0;
		boolean pausa = false;

		for (int i = 0; i < this.arrayBebidas.length && !pausa; i++) {
			if (this.arrayBebidas[i] == bebida) {
				index = i;
				pausa = !pausa;
			}
		}

		for (int i = index; i < arrayBebidas.length - 1; i++) {
			this.arrayBebidas[i] = this.arrayBebidas[i + 1];
		}

	}

	public Bebidas procurar(Bebidas bebida) {

		for (int i = 0; i < arrayBebidas.length; i++) {

			if (this.arrayBebidas[i].getSabor().equals(bebida.getSabor())) {
				return this.arrayBebidas[i];
			} else {
				return null;
			}
		}
		return null;
	}

	public boolean existe(Bebidas bebida) {

		for (int i = 0; i < arrayBebidas.length; i++) {

			if (this.arrayBebidas[i] != null) {
				if (this.arrayBebidas[i].getSabor().equals(bebida.getSabor())) {
					return true;
				}
			}
		}
		return false;
	}

	public void atualizar(Bebidas bebida) {

		boolean parada = false;
		for (int i = 0; i < arrayBebidas.length && !parada; i++) {
			if (this.arrayBebidas[i] != null) {
				if (this.arrayBebidas[i].getSabor().equals(bebida.getSabor())
						&& this.arrayBebidas[i].getTamanho() == bebida.getTamanho()) {
					this.arrayBebidas[i].setPreco(bebida.getPreco());
					parada = true;

				}
			}
		}
	}

}

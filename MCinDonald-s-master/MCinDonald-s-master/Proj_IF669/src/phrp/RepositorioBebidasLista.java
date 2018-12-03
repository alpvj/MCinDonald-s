package phrp;
public class RepositorioBebidasLista implements RepositorioBebidas {

	private Bebidas bebida;
	private RepositorioBebidasLista proximo;

	public RepositorioBebidasLista() {
		this.bebida = null;
		this.proximo = null;
	}

	public void inserirBebidas(Bebidas bebida) {

		if (this.bebida == null) {
			this.bebida = bebida;
			this.proximo = new RepositorioBebidasLista();
		} else {
			this.proximo.inserirBebidas(bebida);
		}
	}

	public void removerBebidas(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor())) {
				this.bebida = this.proximo.bebida;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerBebidas(bebida);
			}
		}
	}

	public Bebidas procurarBebidas(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor())) {
				return bebida;
			} else {
				return this.proximo.procurarBebidas(bebida);
			}
		} else
			return null;
	}

	public boolean existeBebidas(Bebidas bebida) {
		if (this.bebida == null) {
			return false;
		} else if (this.bebida.getSabor().equals(bebida.getSabor())) {
			return true;
		} else if (this.proximo != null) {
			return this.proximo.existeBebidas(bebida);
		} else {
			return false;
		}

	}

	public void atualizarBebidas(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor()) && this.bebida.getTamanho() == bebida.getTamanho()) {
				this.bebida.setPreco(bebida.getPreco());
			} else
				this.proximo.atualizarBebidas(bebida);
		}
	}

}
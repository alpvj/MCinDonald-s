package phrp;
public class RepositorioBebidasLista implements RepositorioBebidas {

	private Bebidas bebida;
	private RepositorioBebidasLista proximo;

	public RepositorioBebidasLista() {
		this.bebida = null;
		this.proximo = null;
	}

	public void inserir(Bebidas bebida) {

		if (this.bebida == null) {
			this.bebida = bebida;
			this.proximo = new RepositorioBebidasLista();
		} else {
			this.proximo.inserir(bebida);
		}
	}

	public void remover(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor())) {
				this.bebida = this.proximo.bebida;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(bebida);
			}
		}
	}

	public Bebidas procurar(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor())) {
				return bebida;
			} else {
				return this.proximo.procurar(bebida);
			}
		} else
			return null;
	}

	public boolean existe(Bebidas bebida) {
		if (this.bebida == null) {
			return false;
		} else if (this.bebida.getSabor().equals(bebida.getSabor())) {
			return true;
		} else if (this.proximo != null) {
			return this.proximo.existe(bebida);
		} else {
			return false;
		}

	}

	public void atualizar(Bebidas bebida) {
		if (this.proximo != null) {
			if (this.bebida.getSabor().equals(bebida.getSabor()) && this.bebida.getTamanho() == bebida.getTamanho()) {
				this.bebida.setPreco(bebida.getPreco());
			} else
				this.proximo.atualizar(bebida);
		}
	}

}
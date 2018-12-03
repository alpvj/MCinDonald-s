package dvcc;

public class RepositorioArrayCafeManha implements RepositorioCafeManha {

	CafeManha[] arraycafemanha;

	public RepositorioArrayCafeManha() {
		this.arraycafemanha = new CafeManha[200];
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException{
		int aux = 0;
		if (!checarCafeManha(cafemanha.getNome())) {
			for (int i = 0; i < arraycafemanha.length && aux == 0; i++) {
				if (this.arraycafemanha[i] == null) {
					this.arraycafemanha[i] = cafemanha;
					aux++;
				}
			}
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void removerCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		if (checarCafeManha(nomeDoProduto)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nomeDoProduto)) {
					for (int j = i; j < (this.arraycafemanha.length - 1); j++) {
						this.arraycafemanha[j] = this.arraycafemanha[j + 1];
					}
					break;
				}
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}

	public void atualizarNome(String nomeDesatualizado, String nomeAtual)	throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		if (!checarCafeManha(nomeAtual)) {
			if (checarCafeManha(nomeDesatualizado)) {
				for (int i = 0; i < this.arraycafemanha.length; i++) {
					if (this.arraycafemanha[i].getNome().equals(nomeDesatualizado)) {
						this.arraycafemanha[i].setNome(nomeAtual);
					}
				}
			} else
				throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void atualizarValor(String nomeDoProduto, double valor) throws CafeDaManhaInexistenteException {
		if (checarCafeManha(nomeDoProduto)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nomeDoProduto)) {
					this.arraycafemanha[i].setValor(valor);
					return;
				}
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}

	public void atualizarCafeManha(String nomeDoProduto, CafeManha cafemanha) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		if (!checarCafeManha(cafemanha.getNome())) {
			if (checarCafeManha(nomeDoProduto)) {
				for (int i = 0; i < this.arraycafemanha.length; i++) {
					if (this.arraycafemanha[i].getNome().equals(nomeDoProduto)) {
						this.arraycafemanha[i].setNome(cafemanha.getNome());
						this.arraycafemanha[i].setValor(cafemanha.getValor());
						return;
					}
				}
			} else
				throw new CafeDaManhaInexistenteException();
			} else
				throw new CafeDaManhaJaExisteException();
		}
	
	public boolean checarCafeManha(String nomeDoProduto) {
		boolean checado = false;

		for (int i = 0; i < this.arraycafemanha.length; i++) {
			if (this.arraycafemanha[i] != null)
			if (this.arraycafemanha[i].getNome().equals(nomeDoProduto))
				checado = true;
		}

		return checado;
	}

	public CafeManha encontrarCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		CafeManha encontrar;
		if (checarCafeManha(nomeDoProduto)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nomeDoProduto)) {
					encontrar = this.arraycafemanha[i];
					return encontrar;
				}

			}
		} else
			throw new CafeDaManhaInexistenteException();
		return null;
	}
}
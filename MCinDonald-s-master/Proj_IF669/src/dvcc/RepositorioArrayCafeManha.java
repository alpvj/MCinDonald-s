package dvcc;

public class RepositorioArrayCafeManha implements RepositorioCafeManha {

	CafeManha[] arraycafemanha;

	public RepositorioArrayCafeManha() {
		this.arraycafemanha = new CafeManha[200];
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException{
		boolean parar = false;
		if (!verificarCafeManha(cafemanha.getNome())) {
			for (int i = 0; i < arraycafemanha.length && !parar; i++) {
				if (this.arraycafemanha[i] == null) {
					this.arraycafemanha[i] = cafemanha;
					parar = true;
				}
			}
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void removerCafeManha(String nome_cafemanha) throws CafeDaManhaInexistenteException {
		if (verificarCafeManha(nome_cafemanha)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nome_cafemanha)) {
					for (int j = i; j < (this.arraycafemanha.length - 1); j++) {
						this.arraycafemanha[j] = this.arraycafemanha[j + 1];
					}
				}
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}

	public boolean verificarCafeManha(String nome_cafemanha) {
		boolean retorno = false;

		for (int i = 0; i < this.arraycafemanha.length; i++) {
			if (this.arraycafemanha[i].getNome().equals(nome_cafemanha))
				retorno = true;
		}

		return retorno;
	}

	public CafeManha procurarCafeManha(String nome_cafemanha) throws CafeDaManhaInexistenteException {
		CafeManha retorno;
		if (verificarCafeManha(nome_cafemanha)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nome_cafemanha)) {
					retorno = this.arraycafemanha[i];
					return retorno;
				}

			}
		} else
			throw new CafeDaManhaInexistenteException();
		return null;
	}

	public void atualizarNome(String nome_Antigo, String nome_Novo)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		if (verificarCafeManha(nome_Novo)) {
			if (verificarCafeManha(nome_Antigo)) {
				for (int i = 0; i < this.arraycafemanha.length; i++) {
					if (this.arraycafemanha[i].getNome().equals(nome_Antigo)) {
						this.arraycafemanha[i].setNome(nome_Novo);
					}
				}
			} else
				throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void atualizarPreco(String nome, double preco) throws CafeDaManhaInexistenteException {
		if (verificarCafeManha(nome)) {
			for (int i = 0; i < this.arraycafemanha.length; i++) {
				if (this.arraycafemanha[i].getNome().equals(nome)) {
					this.arraycafemanha[i].setPreco(preco);
				}
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}

	public void atualizarCafeManha(String nome, CafeManha cafemanha)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		if (verificarCafeManha(cafemanha.getNome())) {
			if (verificarCafeManha(nome)) {
				for (int i = 0; i < this.arraycafemanha.length; i++) {
					if (this.arraycafemanha[i].getNome().equals(nome)) {
						this.arraycafemanha[i] = cafemanha;
					}
				}
			} else
				throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}
}

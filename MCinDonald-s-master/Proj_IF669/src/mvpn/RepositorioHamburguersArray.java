package mvpn;

public class RepositorioHamburguersArray implements RepositorioHamburguers {
	private Hamburguer[] repositorio = new Hamburguer[250];

	public boolean checarHamburguer(String nome) {

		boolean retorno = false;
		for (int i = 0; i < this.repositorio.length; i++) {
			if (this.repositorio[i] != null) {
				if (this.repositorio[i].getNome().equals(nome)) {
					retorno = true;
				}
			}
		}

		return retorno;
	}

	public void inserir(Hamburguer hamburguer) throws HamburguerExistenteException {
		boolean parar = false;
		if (!checarHamburguer(hamburguer.getNome())) {
			for (int i = 0; i < this.repositorio.length && !parar; i++) {
				if (this.repositorio[i] == null) {
					this.repositorio[i] = hamburguer;
					parar = true;
				}
			}
		} else {
			throw new HamburguerExistenteException();
		}

	}

	public void remover(String nome) throws HamburguerInexistenteException {
		boolean parar = false;

		if (checarHamburguer(nome)) {
			for (int i = 0; i < this.repositorio.length && !parar; i++) {
				if (this.repositorio[i].getNome() == nome) {
					this.repositorio[i] = null;
					parar = true;
				}
			}
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public Hamburguer procurar(String nome) throws HamburguerInexistenteException {
		Hamburguer retorno = null;
		if (checarHamburguer(nome)) {
			for (int i = 0; i < this.repositorio.length; i++) {
				if (repositorio[i] != null && this.repositorio[i].getNome().equals(nome)) {
					retorno = this.repositorio[i];
				}
			}
			return retorno;
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public void atualizar(String nomeAntigo, String nomeNovo, double preco) throws HamburguerInexistenteException {
		if (checarHamburguer(nomeAntigo)) {
			for (int i = 0; i < this.repositorio.length; i++) {
				if (this.repositorio[i] != null && this.repositorio[i].getNome() == nomeAntigo) {
					this.repositorio[i].setNome(nomeNovo);
					this.repositorio[i].setPreco(preco);
				}
			}
		} else {
			throw new HamburguerInexistenteException();
		}
	}
}

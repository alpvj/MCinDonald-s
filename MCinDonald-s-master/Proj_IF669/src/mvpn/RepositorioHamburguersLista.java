package mvpn;

public class RepositorioHamburguersLista implements RepositorioHamburguers {
	private RepositorioHamburguersLista proximo;
	private Hamburguer hamburguer;

	public RepositorioHamburguersLista() {

		this.hamburguer = null;
		this.proximo = null;
	}

	public boolean checarHamburguer(String nome) {
		boolean retorno = false;
		if (this.hamburguer != null) {
			if (this.hamburguer.getNome() == nome) {
				retorno = true;
			} else {
				return this.proximo.checarHamburguer(nome);
			}
		}
		return retorno;
	}

	public void inserir(Hamburguer hamburguer) {

		if (this.proximo == null) {
			this.hamburguer = hamburguer;
			this.proximo = new RepositorioHamburguersLista();
		} else {
			this.proximo.inserir(hamburguer);
		}

	}

	public void remover(String nome) {
		if (this.hamburguer != null) {
			if (this.hamburguer.getNome() == nome) {
				this.hamburguer = this.proximo.hamburguer;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(nome);
			}
		} else {
			throw new RuntimeException("Esse hamburguer nao existe");
		}
	}

	public void atualizar(String nomeAntigo, String nomeNovo, double preco) {
		if (this.hamburguer != null) {
			if (this.hamburguer.getNome().equals(nomeAntigo)) {
				this.hamburguer.setNome(nomeNovo);
				this.hamburguer.setPreco(preco);
			} else {
				this.proximo.atualizar(nomeNovo, nomeAntigo, preco);
			}
		} else {
			throw new RuntimeException("Nao foi possivel atualizar o cardapio. Motivo: o hamburguer nao existe");
		}
	}

	public Hamburguer procurar(String nome) {
		Hamburguer retorno;
		if (this.hamburguer != null) {
			if (this.hamburguer.getNome().equals(nome)) {
				retorno = this.hamburguer;
			} else {
				retorno = this.proximo.procurar(nome);
			}
		} else {
			throw new RuntimeException("");
		}
		return retorno;
	}

}

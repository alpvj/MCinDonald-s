package mvpn;

public class NegociosHamburguers implements RepositorioHamburguers {

	private RepositorioHamburguers repositorio;

	public NegociosHamburguers(RepositorioHamburguers repositorio) {
		this.repositorio = repositorio;

	}

	public void inserir(Hamburguer hamburguer) throws HamburguerExistenteException {

		if (!this.repositorio.checarHamburguer(hamburguer.getNome())) {
			this.repositorio.inserir(hamburguer);
		} else {
			throw new HamburguerExistenteException();
		}
	}

	public void remover(String nome) throws HamburguerInexistenteException {

		if (this.repositorio.checarHamburguer(nome)) {
			this.repositorio.remover(nome);
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public void atualizar(String nomeAntigo, String nomeNovo, double preco) throws HamburguerInexistenteException {

		if (this.repositorio.checarHamburguer(nomeAntigo)) {
			this.repositorio.atualizar(nomeAntigo, nomeNovo, preco);

		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public Hamburguer procurar(String nome) throws HamburguerInexistenteException {

		if (this.repositorio.checarHamburguer(nome)) {
			return this.repositorio.procurar(nome);
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public boolean checarHamburguer(String nome) {
		return repositorio.checarHamburguer(nome);
	}

}

package phrp;

public class NegociosBebidas {

	private RepositorioBebidas repositorio;

	public NegociosBebidas(RepositorioBebidas repositorio) {
		this.repositorio = repositorio;
	}

	public void inserir(Bebidas bebida) throws BebidaExistenteException {

		if (!repositorio.existe(bebida)) {
			repositorio.inserir(bebida);
		} else {
			throw new BebidaExistenteException();
		}
	}

	public void remover(Bebidas bebida) throws BebidaInexistenteException {

		if (repositorio.existe(bebida)) {
			repositorio.remover(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public Bebidas procurar(Bebidas bebida) throws BebidaInexistenteException {
		if (repositorio.existe(bebida)) {
			return repositorio.procurar(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public boolean existe(Bebidas bebida) {
		if (repositorio.existe(bebida)) {
			return true;
		} else {
			return false;
		}
	}

	public void atualizar(Bebidas bebida) throws BebidaInexistenteException {
		if (repositorio.existe(bebida)) {
			repositorio.atualizar(bebida);
		} else {
			throw new BebidaInexistenteException();
		}

	}
}

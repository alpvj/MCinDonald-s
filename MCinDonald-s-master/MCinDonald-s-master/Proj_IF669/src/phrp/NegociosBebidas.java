package phrp;

public class NegociosBebidas {

	private RepositorioBebidas repositorio;

	public NegociosBebidas(RepositorioBebidas repositorio) {
		this.repositorio = repositorio;
	}

	public void inserirBebidas(Bebidas bebida) throws BebidaExistenteException {

		if (!repositorio.existeBebidas(bebida)) {
			repositorio.inserirBebidas(bebida);
		} else {
			throw new BebidaExistenteException();
		}
	}

	public void removerBebidas(Bebidas bebida) throws BebidaInexistenteException {

		if (repositorio.existeBebidas(bebida)) {
			repositorio.removerBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public Bebidas procurarBebidas(Bebidas bebida) throws BebidaInexistenteException {
		if (repositorio.existeBebidas(bebida)) {
			return repositorio.procurarBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public boolean existeBebidas(Bebidas bebida) {
		if (repositorio.existeBebidas(bebida)) {
			return true;
		} else {
			return false;
		}
	}

	public void atualizarBebidas(Bebidas bebida) throws BebidaInexistenteException {
		if (repositorio.existeBebidas(bebida)) {
			repositorio.atualizarBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}

	}
}

package dvcc;

public class NegociosCafeManha implements RepositorioCafeManha {
	private RepositorioCafeManha repositorio;

	public NegociosCafeManha(RepositorioCafeManha repositorio) {
		this.repositorio = repositorio;
	}

	public CafeManha encontrarCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		return repositorio.encontrarCafeManha(nomeDoProduto);
	}

	public boolean checarCafeManha(String nomeDoProduto) {
		return repositorio.checarCafeManha(nomeDoProduto);
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException {
		repositorio.adicionarCafeManha(cafemanha);
	}

	public void removerCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		repositorio.removerCafeManha(nomeDoProduto);
	}

	public void atualizarNome(String nomeDesatualizado, String nomeAtual)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		repositorio.atualizarNome(nomeDesatualizado, nomeAtual);
	}

	public void atualizarValor(String nomeDoproduto, double valor) throws CafeDaManhaInexistenteException {
		repositorio.atualizarValor(nomeDoproduto, valor);
	}

	public void atualizarCafeManha(String nomeDoproduto, CafeManha cafemanha)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		repositorio.atualizarCafeManha(nomeDoproduto, cafemanha);
	}
}

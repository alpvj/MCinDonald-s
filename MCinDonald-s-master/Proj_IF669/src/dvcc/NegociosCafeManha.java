package dvcc;

public class NegociosCafeManha implements RepositorioCafeManha{
	private RepositorioCafeManha repositorio;

	public NegociosCafeManha(RepositorioCafeManha repositorio) {
		this.repositorio = repositorio;
	}

	public CafeManha procurarCafeManha(String nome_cafemanha) throws CafeDaManhaInexistenteException{
		return repositorio.procurarCafeManha(nome_cafemanha);
	}

	public boolean verificarCafeManha(String nome_cafemanha) {
		return repositorio.verificarCafeManha(nome_cafemanha);
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException {
		repositorio.adicionarCafeManha(cafemanha);
	}

	public void removerCafeManha(String nome_cafemanha) throws CafeDaManhaInexistenteException {
		repositorio.removerCafeManha(nome_cafemanha);
	}

	public void atualizarNome(String nome_Antigo, String nome_Novo) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		repositorio.atualizarNome(nome_Antigo, nome_Novo);
	}

	public void atualizarPreco(String nome, double preco) throws CafeDaManhaInexistenteException{
		repositorio.atualizarPreco(nome, preco);
	}

	public void atualizarCafeManha(String nome, CafeManha cafemanha) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException{
		repositorio.atualizarCafeManha(nome, cafemanha);
	}

}

package dvcc;

public interface RepositorioCafeManha {
	public CafeManha encontrarCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException;

	public boolean checarCafeManha(String nomeDoProduto);

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException;

	public void removerCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException;

	public void atualizarNome(String nomeDesatualizado, String nomeAtual)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException;

	public void atualizarValor(String nomeDoProduto, double valor) throws CafeDaManhaInexistenteException;

	public void atualizarCafeManha(String nomeDoProduto, CafeManha cafemanha)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException;
}

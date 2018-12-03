package dvcc;

public class RepositorioListaCafeManha implements RepositorioCafeManha{



	private CafeManha cafemanha;
	private RepositorioListaCafeManha proximo;

	public RepositorioListaCafeManha() {
		cafemanha = null;
		proximo = null;
	}
	public CafeManha encontrarCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException{
		CafeManha encontrado;
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeDoProduto)) {
				encontrado = this.cafemanha;
			} else
				return this.proximo.encontrarCafeManha(nomeDoProduto);
		} else
			throw new CafeDaManhaInexistenteException();

		return encontrado;
	}

	public boolean checarCafeManha(String nomeDoProduto) {
		boolean verificado = false;

		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeDoProduto)) {
				verificado = true;
			} else
				verificado = this.proximo.checarCafeManha(nomeDoProduto);
		} else
			verificado = false;

		return verificado;
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException{
		if (!checarCafeManha(cafemanha.getNome())) {
			if (this.cafemanha == null) {
				this.cafemanha = cafemanha;
				this.proximo = new RepositorioListaCafeManha();
			} else {
				this.proximo.adicionarCafeManha(cafemanha);
			}
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void removerCafeManha(String nomeCafeManha) throws CafeDaManhaInexistenteException{
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeCafeManha)) {
				this.cafemanha = this.proximo.cafemanha;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.removerCafeManha(nomeCafeManha);
		} else
			throw new CafeDaManhaInexistenteException();
	}

	public void atualizarNome(String nomeDesatualizado, String nomeAtual) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException{
		if (!checarCafeManha(nomeAtual)) {
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeDesatualizado)) {
				this.cafemanha.setNome(nomeAtual);
			} else {
				this.proximo.atualizarNome(nomeDesatualizado, nomeAtual);
			}
		} else
			throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void atualizarValor(String nomeDoProduto, double valor) throws CafeDaManhaInexistenteException{
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeDoProduto)) {
				this.cafemanha.setValor(valor);
			} else {
				this.proximo.atualizarValor(nomeDoProduto, valor);
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}
	public void atualizarCafeManha(String nomeDoProduto, CafeManha cafemanha) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException{
		if (!checarCafeManha(cafemanha.getNome())) {
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeDoProduto)) {
				this.cafemanha.setNome(cafemanha.getNome());
				this.cafemanha.setValor(cafemanha.getValor());
			} else {
				this.proximo.atualizarCafeManha(nomeDoProduto, cafemanha);
			}
		} else
			throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}

}
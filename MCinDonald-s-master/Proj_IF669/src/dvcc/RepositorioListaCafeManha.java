package dvcc;

public class RepositorioListaCafeManha {


	private CafeManha cafemanha;
	private RepositorioListaCafeManha proximo;

	RepositorioListaCafeManha() {
		cafemanha = null;
		proximo = null;
	}

	public CafeManha procurarCafeManha(String nomeCafeManha) throws CafeDaManhaInexistenteException{
		CafeManha encontrado;
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeCafeManha)) {
				encontrado = this.cafemanha;
			} else
				return this.proximo.procurarCafeManha(nomeCafeManha);
		} else
			throw new CafeDaManhaInexistenteException();

		return encontrado;
	}

	public boolean verificarCafeManha(String nomeCafeManha) {
		boolean verificado = false;

		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nomeCafeManha)) {
				verificado = true;
			} else
				verificado = this.proximo.verificarCafeManha(nomeCafeManha);
		} else
			verificado = false;

		return verificado;
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException{
		if (!verificarCafeManha(cafemanha.getNome())) {
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

	public void atualizarNome(String nome_Antigo, String nome_Novo) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException{
		if (verificarCafeManha(nome_Novo)) {
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nome_Antigo)) {
				this.cafemanha.setNome(nome_Novo);
			} else {
				this.proximo.atualizarNome(nome_Antigo, nome_Novo);
			}
		} else
			throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}

	public void atualizarPreco(String nome, double preco) throws CafeDaManhaInexistenteException{
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nome)) {
				this.cafemanha.setPreco(preco);
			} else {
				this.proximo.atualizarPreco(nome, preco);
			}
		} else
			throw new CafeDaManhaInexistenteException();
	}
	public void atualizarSobremesa(String nome, CafeManha cafemanha) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException{
		if (verificarCafeManha(cafemanha.getNome())) {
		if (this.cafemanha != null) {
			if (this.cafemanha.getNome().equals(nome)) {
				this.cafemanha = cafemanha;
			} else {
				this.proximo.atualizarSobremesa(nome, cafemanha);
			}
		} else
			throw new CafeDaManhaInexistenteException();
		} else
			throw new CafeDaManhaJaExisteException();
	}


}

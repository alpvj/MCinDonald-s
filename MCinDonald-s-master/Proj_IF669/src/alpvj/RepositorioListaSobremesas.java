package alpvj;

public class RepositorioListaSobremesas implements RepositorioSobremesas {
	private Sobremesas sobremesa;
	private RepositorioListaSobremesas proximo;

	RepositorioListaSobremesas() {
		sobremesa = null;
		proximo = null;
	}

	public Sobremesas procurarSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException{
		Sobremesas retorno;
		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome_Sobremesa)) {
				retorno = this.sobremesa;
			} else
				retorno = this.proximo.procurarSobremesa(nome_Sobremesa);
		} else
			throw new SobremesaInexistenteException();

		return retorno;
	}

	public boolean verificarSobremesa(String nome_Sobremesa) {
		boolean retorno = false;

		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome_Sobremesa)) {
				retorno = true;
			} else
				retorno = this.proximo.verificarSobremesa(nome_Sobremesa);
		} else
			retorno = false;

		return retorno;
	}

	public void adicionarSobremesa(Sobremesas sobremesa) throws SobremesaJaExisteException {
		if (!verificarSobremesa(sobremesa.getNome())) {
			if (this.sobremesa == null) {
				this.sobremesa = sobremesa;
				this.proximo = new RepositorioListaSobremesas();
			} else {
				this.proximo.adicionarSobremesa(sobremesa);
			}
		} else
			throw new SobremesaJaExisteException();
	}

	public void removerSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException{
		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome_Sobremesa)) {
				this.sobremesa = this.proximo.sobremesa;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.removerSobremesa(nome_Sobremesa);
		} else
			throw new SobremesaInexistenteException();
	}

	public void atualizarNomeSobremesa(String nome_Antigo, String nome_Novo) throws SobremesaInexistenteException, SobremesaJaExisteException{
		if (verificarSobremesa(nome_Novo)) {
		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome_Antigo)) {
				this.sobremesa.setNome(nome_Novo);
			} else {
				this.proximo.atualizarNomeSobremesa(nome_Antigo, nome_Novo);
			}
		} else
			throw new SobremesaInexistenteException();
		} else
			throw new SobremesaJaExisteException();
	}

	public void atualizarPrecoSobremesa(String nome, double preco) throws SobremesaInexistenteException{
		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome)) {
				this.sobremesa.setPreco(preco);
			} else {
				this.proximo.atualizarPrecoSobremesa(nome, preco);
			}
		} else
			throw new SobremesaInexistenteException();
	}

	public void atualizarSobremesa(String nome, Sobremesas sobremesa) throws SobremesaInexistenteException, SobremesaJaExisteException{
		if (verificarSobremesa(sobremesa.getNome())) {
		if (this.sobremesa != null) {
			if (this.sobremesa.getNome().equals(nome)) {
				this.sobremesa = sobremesa;
			} else {
				this.proximo.atualizarSobremesa(nome, sobremesa);
			}
		} else
			throw new SobremesaInexistenteException();
		} else
			throw new SobremesaJaExisteException();
	}

}
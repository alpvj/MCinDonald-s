package alpvj;

public class RepositorioArraySobremesas implements RepositorioSobremesas {
	
 	Sobremesas[] arraySobremesas;
 	
	public RepositorioArraySobremesas() {
		this.arraySobremesas = new Sobremesas[200];
	}

	public void adicionarSobremesa(Sobremesas sobremesa) throws SobremesaJaExisteException{
		boolean parar = false;
		if (!verificarSobremesa(sobremesa.getNome())) {
			for (int i = 0; i < arraySobremesas.length && !parar; i++) {
				if (this.arraySobremesas[i] == null) {
					this.arraySobremesas[i] = sobremesa;
					parar = true;
				}
			}
		} else
			throw new SobremesaJaExisteException();
	}

	public void removerSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException{
		if (verificarSobremesa(nome_Sobremesa)) {
			for (int i = 0; i < this.arraySobremesas.length; i++) {
				if (this.arraySobremesas[i].getNome().equals(nome_Sobremesa)) {
					for (int j = i; j < (this.arraySobremesas.length - 1); j++) {
						this.arraySobremesas[j] = this.arraySobremesas[j + 1];
					}
					break;
				}
			}
		} else
			throw new SobremesaInexistenteException();
	}

	public boolean verificarSobremesa(String nome_Sobremesa) {
		for (int i = 0; i < this.arraySobremesas.length; i++) {
			if (this.arraySobremesas[i] != null)
			if (this.arraySobremesas[i].getNome().equals(nome_Sobremesa))
				return true;
		}
		return false;
	}

	public Sobremesas procurarSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException{
		Sobremesas retorno;
		if (verificarSobremesa(nome_Sobremesa)) {
			for (int i = 0; i < this.arraySobremesas.length; i++) {
				if (this.arraySobremesas[i].getNome().equals(nome_Sobremesa)) {
					retorno = this.arraySobremesas[i];
					return retorno;
				}

			}
		} else
			throw new SobremesaInexistenteException();
		return null;// so pro eclipse nao reclamar
	}

	public void atualizarNomeSobremesa(String nome_Antigo, String nome_Novo) throws SobremesaInexistenteException, SobremesaJaExisteException{
		if (!verificarSobremesa(nome_Novo)) {
		if (verificarSobremesa(nome_Antigo)) {
			for (int i = 0; i < this.arraySobremesas.length; i++) {
				if (this.arraySobremesas[i].getNome().equals(nome_Antigo)) {
					this.arraySobremesas[i].setNome(nome_Novo);
					return;
				}
			}
		} else
			throw new SobremesaInexistenteException();
		} else
			throw new SobremesaJaExisteException();
	}

	public void atualizarPrecoSobremesa(String nome, double preco) throws SobremesaInexistenteException{
		if (verificarSobremesa(nome)) {
			for (int i = 0; i < this.arraySobremesas.length; i++) {
				if (this.arraySobremesas[i].getNome().equals(nome)) {
					this.arraySobremesas[i].setPreco(preco);
					return;
				}
			}
		} else
			throw new SobremesaInexistenteException();
	}

	public void atualizarSobremesa(String nome, Sobremesas sobremesa) throws SobremesaInexistenteException, SobremesaJaExisteException{
		if (!verificarSobremesa(sobremesa.getNome())) {
		if (verificarSobremesa(nome)) {
			for (int i = 0; i < this.arraySobremesas.length; i++) {
				if (this.arraySobremesas[i].getNome().equals(nome)) {
					this.arraySobremesas[i].setNome(sobremesa.getNome());
					this.arraySobremesas[i].setPreco(sobremesa.getPreco());
					return;
				}
			}
		} else
			throw new SobremesaInexistenteException();
		} else
			throw new SobremesaJaExisteException();
	}

}

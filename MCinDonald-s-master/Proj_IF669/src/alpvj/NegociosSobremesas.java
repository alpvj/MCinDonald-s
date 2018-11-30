package alpvj;

public class NegociosSobremesas implements RepositorioSobremesas{
	private RepositorioSobremesas repositorio;

	public NegociosSobremesas(RepositorioSobremesas repositorio) {
		this.repositorio = repositorio;
	}
	
//	public NegociosSobremesas(int tipo) {
//		// ARRAY = 1
//		if (tipo == 1) {
//			this.repositorio = new RepositorioArraySobremesas();
//		} else {
//			this.repositorio = new RepositorioListaSobremesas();
//		}
//	}

	public Sobremesas procurarSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException{
		return repositorio.procurarSobremesa(nome_Sobremesa);
	}

	public boolean verificarSobremesa(String nome_Sobremesa) {
		return repositorio.verificarSobremesa(nome_Sobremesa);
	}

	public void adicionarSobremesa(Sobremesas sobremesa) throws SobremesaJaExisteException {
		repositorio.adicionarSobremesa(sobremesa);
	}

	public void removerSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException {
		repositorio.removerSobremesa(nome_Sobremesa);
	}

	public void atualizarNomeSobremesa(String nome_Antigo, String nome_Novo) throws SobremesaInexistenteException, SobremesaJaExisteException {
		repositorio.atualizarNomeSobremesa(nome_Antigo, nome_Novo);
	}

	public void atualizarPrecoSobremesa(String nome, double preco) throws SobremesaInexistenteException{
		repositorio.atualizarPrecoSobremesa(nome, preco);
	}

	public void atualizarSobremesa(String nome, Sobremesas sobremesa) throws SobremesaInexistenteException, SobremesaJaExisteException{
		repositorio.atualizarSobremesa(nome, sobremesa);
	}

}
package alpvj;

public interface RepositorioSobremesas {
	
	public Sobremesas procurarSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException;

	public boolean verificarSobremesa(String nome_Sobremesa);

	public void adicionarSobremesa(Sobremesas sobremesa) throws SobremesaJaExisteException;

	public void removerSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException;

	public void atualizarNomeSobremesa(String nome_Antigo, String nome_Novo) throws SobremesaInexistenteException, SobremesaJaExisteException;

	public void atualizarPrecoSobremesa(String nome, double preco) throws SobremesaInexistenteException;
	
	public void atualizarSobremesa(String nome, Sobremesas sobremesa) throws SobremesaInexistenteException, SobremesaJaExisteException;

}
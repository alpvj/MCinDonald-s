package mvpn;

public interface RepositorioHamburguers {

	public void inserir (Hamburguer hamburguer) throws HamburguerExistenteException;
	
	public void remover (String nome) throws HamburguerInexistenteException;
	
	public Hamburguer procurar(String nome) throws HamburguerInexistenteException;
	
	public void atualizar(String nomeAntigo, String nomeNovo, double preco) throws HamburguerInexistenteException;
	
	public boolean checarHamburguer (String nome);
}
	

package phrp;
public interface RepositorioBebidas {
	
	public void inserirBebidas (Bebidas valor) throws BebidaExistenteException; 
	
	public void removerBebidas (Bebidas bebida) throws BebidaInexistenteException;
	
	public Bebidas procurarBebidas (Bebidas bebida) throws BebidaInexistenteException;
	
	public boolean existeBebidas (Bebidas bebida);
	
	public void atualizarBebidas (Bebidas bebida) throws BebidaInexistenteException;
		
	
}
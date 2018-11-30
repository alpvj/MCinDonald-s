package phrp;
public interface RepositorioBebidas {
	
	public void inserir (Bebidas valor) throws BebidaExistenteException; 
	
	public void remover (Bebidas bebida) throws BebidaInexistenteException;
	
	public Bebidas procurar (Bebidas bebida) throws BebidaInexistenteException;
	
	public boolean existe (Bebidas bebida);
	
	public void atualizar (Bebidas bebida) throws BebidaInexistenteException;
		
	
}
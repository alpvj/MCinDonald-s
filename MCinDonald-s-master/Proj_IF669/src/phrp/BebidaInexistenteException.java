package phrp;

public class BebidaInexistenteException extends Exception{
	
	public BebidaInexistenteException() {
		super("Essa bebida nao esta cadastrada no Sistema!");
	}

}

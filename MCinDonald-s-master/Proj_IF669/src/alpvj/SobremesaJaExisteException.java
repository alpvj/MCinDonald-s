package alpvj;

public class SobremesaJaExisteException extends Exception{
	
	public SobremesaJaExisteException() {
		super("Erro ao tentar adicionar uma Sobremesa. Motivo: Sobremesa ja existe");
	}
	
}

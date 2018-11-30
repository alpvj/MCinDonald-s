package alpvj;

public class SobremesaInexistenteException extends Exception {

	public SobremesaInexistenteException() {
		super("Erro ao tentar remover uma Sobremesa. Motivo: Sobremesa inexistente");
	}
}

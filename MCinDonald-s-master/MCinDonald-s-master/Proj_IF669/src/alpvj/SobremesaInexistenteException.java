package alpvj;

public class SobremesaInexistenteException extends Exception {

	public SobremesaInexistenteException() {
		super("Erro ao tentar acessar uma Sobremesa. Motivo: Sobremesa inexistente");
	}
}

package dvcc;

public class CafeDaManhaInexistenteException extends Exception {

	public CafeDaManhaInexistenteException() {
		super("Erro. O produto nao foi adicionado");
	}
}

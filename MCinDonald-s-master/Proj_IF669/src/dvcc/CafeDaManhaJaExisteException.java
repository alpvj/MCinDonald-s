package dvcc;

public class CafeDaManhaJaExisteException extends Exception {

	public CafeDaManhaJaExisteException() {
		super("Erro. O Produto ja foi adcionado");
	}
}
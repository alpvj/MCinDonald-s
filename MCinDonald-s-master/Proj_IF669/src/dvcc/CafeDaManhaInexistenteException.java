package dvcc;

public class CafeDaManhaInexistenteException extends Exception {


	public CafeDaManhaInexistenteException() {
		super("Erro ao tentar remover um cafe da manha. Motivo: Cafe da manha inexistente");
	}
}

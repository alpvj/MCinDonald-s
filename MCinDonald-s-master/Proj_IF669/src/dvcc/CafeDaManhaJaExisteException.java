package dvcc;

public class CafeDaManhaJaExisteException extends Exception{
	
	public CafeDaManhaJaExisteException() {
		super("Erro ao tentar adicionar um cafe da manha. Motivo: Cafe da manha ja existe");
	}

}

package jbmn2;

public class CPFInvalidoException extends Exception{
	public CPFInvalidoException() {
		super("CPF Invalido, escreva corretamento com 11 digitos.");
	}
}

package jbmn2;

public class PessoaJaCadastradaException extends Exception{
	public PessoaJaCadastradaException(String cpf) {
		super("Pessoa de CPF "+cpf+" ja cadastrada");
	}
}

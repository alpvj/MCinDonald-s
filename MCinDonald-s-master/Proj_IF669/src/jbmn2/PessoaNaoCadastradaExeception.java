package jbmn2;

public class PessoaNaoCadastradaExeception extends Exception{
	public PessoaNaoCadastradaExeception(String cpf) {
		super("CPF "+cpf+" Nao Cadastrado");
	}
}

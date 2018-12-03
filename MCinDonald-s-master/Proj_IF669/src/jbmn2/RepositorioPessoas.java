package jbmn2;

public interface RepositorioPessoas {
	public void inserir(Cliente pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception,CPFInvalidoException;
	public Cliente procurarCliente(String cpf) throws PessoaNaoCadastradaExeception;
	public void atualizar(Cliente pessoa) throws PessoaNaoCadastradaExeception;
	public void removerCliente(String cpf) throws PessoaNaoCadastradaExeception;

	//Funcionario
	public void inserir(Funcionario pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception, GerenteJaExistenteException, CPFInvalidoException;
	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoCadastradaExeception;
	public void atualizar(Funcionario pessoa) throws PessoaNaoCadastradaExeception;
	public void removerFuncionario(String cpf) throws PessoaNaoCadastradaExeception;
	
	public boolean existeCliente(String cpf) throws PessoaNaoCadastradaExeception;
	public boolean existeFuncionario(String cpf) throws PessoaNaoCadastradaExeception;
	
	public boolean getGerenteState();
}

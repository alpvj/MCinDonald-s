package jbmn2;

public class NegociosPessoas  {
	private RepositorioPessoas repositorio;

	public NegociosPessoas(RepositorioPessoas repositorio){
		this.repositorio = repositorio;
	}
	
//	public NegociosPessoas(int escolha) {
//		if(escolha == 0) {
//			repositorio = new RepositorioPessoasLista();
//		}
//		else if(escolha == 1) {
//			repositorio = new RepositorioPessoasArray();
//		}
//	}
	
	public void inserir(Cliente pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception, CPFInvalidoException {
		if(pessoa.getCpf().length() != 11) {
			throw new CPFInvalidoException();
		}
		else {
			this.repositorio.inserir(pessoa);
		}
	}
	
	public void inserir(Funcionario pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception, GerenteJaExistenteException, CPFInvalidoException {
		if(pessoa.getCpf().length() != 11) {
			throw new CPFInvalidoException();
		}
		else if(this.repositorio.getGerenteState() && pessoa.getCargo().equals("Gerente")) {
			throw new GerenteJaExistenteException();
		}
		else {
			this.repositorio.inserir(pessoa);
		}
	}
	
	
	public void removerCliente(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if(cpf.length() != 11) {
			throw new CPFInvalidoException();
		}
		else {
			this.repositorio.removerCliente(cpf);
		}
	}
	
	public void removerFuncionario(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if(cpf.length() != 11) {
			throw new CPFInvalidoException();
		}
		else {
			this.repositorio.removerFuncionario(cpf);
		}
	}
	
	public Cliente procurarCliente(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if(cpf.length() != 11) {
			throw new CPFInvalidoException();
		}
		else {
			return this.repositorio.procurarCliente(cpf);
		}
	}
	
	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if(cpf.length() != 11) {
			throw new CPFInvalidoException();
		}
		else {
			return this.repositorio.procurarFuncionario(cpf);
		}
	}
	
	public void atualizar(Funcionario pessoa) throws PessoaNaoCadastradaExeception{
		this.repositorio.atualizar(pessoa);
	}
	
	public void atualizar(Cliente pessoa) throws PessoaNaoCadastradaExeception{
		this.repositorio.atualizar(pessoa);
	}

	public boolean getGerenteState() {
		return this.repositorio.getGerenteState();
	}
	
	public boolean existeCliente(String cpf) throws PessoaNaoCadastradaExeception{
		return this.repositorio.existeCliente(cpf);
	}
	
	public boolean existeFuncionario(String cpf) throws PessoaNaoCadastradaExeception{
		return this.repositorio.existeFuncionario(cpf);
	}
}

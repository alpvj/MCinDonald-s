package jbmn2;

public class RepositorioPessoasLista implements RepositorioPessoas{
	
	private Pessoas valor;
	private RepositorioPessoasLista proximo;
	private boolean gerente = false;
	
	public RepositorioPessoasLista() {
		this.valor = null;
		this.proximo = null;
	}
	
	public void inserir(Cliente pessoa) throws PessoaNaoCadastradaExeception,PessoaJaCadastradaException{
		try {
			procurarCliente(pessoa.getCpf());
			throw new PessoaJaCadastradaException(pessoa.getCpf());
		}
		catch(PessoaNaoCadastradaExeception e) {
			if (this.valor == null) {
				this.valor = pessoa;
				this.proximo = new RepositorioPessoasLista();
			} else {
				this.proximo.inserir(pessoa);
			}
		}
	}


	public void removerCliente(String cpf) throws PessoaNaoCadastradaExeception{
		if (this.proximo != null) {
			String cpfPessoa = this.valor.getCpf();
			if (cpfPessoa.equals(cpf)) {
				this.valor = this.proximo.valor;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerCliente(cpf);
			}
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
		
	}


	public Cliente procurarCliente(String cpf) throws PessoaNaoCadastradaExeception{
		boolean achou = false;
		Pessoas pessoaAchada = null;
		
		if (this.proximo != null) {
			String cpfPessoa = this.valor.getCpf();
			if (cpfPessoa.equals(cpf)) {
				achou = true;
				pessoaAchada = this.valor;
			} else {
				return this.proximo.procurarCliente(cpf);
			}
		}

		if(achou) {
			return (Cliente) pessoaAchada;
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
	}

	public void atualizar(Cliente pessoa) throws PessoaNaoCadastradaExeception {
		String cpfPessoa = pessoa.getCpf();
		if(this.proximo != null) {
			if(this.valor.getCpf().equals(cpfPessoa)) {
				this.valor.setNome(pessoa.getNome());
				this.valor.setIdade(pessoa.getIdade());
				this.valor.setCpf(pessoa.getCpf());
				((Cliente) this.valor).setPratoPreferido(pessoa.getPratoPreferido());
			}
			else {
				this.proximo.atualizar(pessoa);
			}
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpfPessoa);
		}
		
	}
	
// -------------------------------------------- Funcionario --------------------------------------------------------------------	
	
	public void inserir(Funcionario pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception,GerenteJaExistenteException {
		// TODO Auto-generated method stub
		try {
			procurarFuncionario(pessoa.getCpf());
			throw new PessoaJaCadastradaException(pessoa.getCpf());
		}
		catch(PessoaNaoCadastradaExeception e) {
			if (this.valor == null) {
				this.valor = pessoa;
				this.proximo = new RepositorioPessoasLista();
				
				if(pessoa.getCargo().equals("Gerente")) {
					this.gerente = true;
				}
				
			} else {
				this.proximo.inserir(pessoa);
			}
		}
	}

	
	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoCadastradaExeception {
		boolean achou = false;
		Pessoas pessoaAchada = null;
		
		if (this.proximo != null) {
			String cpfPessoa = this.valor.getCpf();
			if (cpfPessoa.equals(cpf)) {
				achou = true;
				pessoaAchada = this.valor;
			} else {
				return this.proximo.procurarFuncionario(cpf);
			}
		}

		if(achou) {
			return (Funcionario) pessoaAchada;
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
	}

	
	public void atualizar(Funcionario pessoa) throws PessoaNaoCadastradaExeception {
		String cpfPessoa = pessoa.getCpf();
		if(this.proximo != null) {
			if(this.valor.getCpf().equals(cpfPessoa)) {
				this.valor.setNome(pessoa.getNome());
				this.valor.setIdade(pessoa.getIdade());
				this.valor.setCpf(pessoa.getCpf());
				((Funcionario) this.valor).setAntecedentesCriminais(pessoa.getAntecedentesCriminais());
				((Funcionario) this.valor).setCargo(pessoa.getCargo());
				((Funcionario) this.valor).setEndereco(pessoa.getEndereco());
				((Funcionario) this.valor).setEstadoCivil(pessoa.getEstadoCivil());
				((Funcionario) this.valor).setRg(pessoa.getRg());
			}
			else {
				this.proximo.atualizar(pessoa);
			}
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpfPessoa);
		}
		
	}

	public void removerFuncionario(String cpf) throws PessoaNaoCadastradaExeception{
		if (this.proximo != null) {
			String cpfPessoa = this.valor.getCpf();
			if (cpfPessoa.equals(cpf)) {
				
				if((((Funcionario) this.valor).getCargo()).equals("Gerente")) {
					this.gerente = false;
				}
				
				this.valor = this.proximo.valor;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.removerCliente(cpf);
			}
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
		
	}
	
	public boolean getGerenteState() {
		return this.gerente;
	}

	
	public boolean existeCliente(String cpf) throws PessoaNaoCadastradaExeception {
		try {
			procurarCliente(cpf);
			return true;
		}
		catch(PessoaNaoCadastradaExeception e){
			return false;
		}	
	}

	
	public boolean existeFuncionario(String cpf) throws PessoaNaoCadastradaExeception {
		try {
			procurarFuncionario(cpf);
			return true;
		}
		catch(PessoaNaoCadastradaExeception e){
			return false;
		}	
	}
}

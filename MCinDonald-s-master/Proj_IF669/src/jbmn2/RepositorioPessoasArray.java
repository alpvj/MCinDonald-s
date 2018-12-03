package jbmn2;

public class RepositorioPessoasArray implements RepositorioPessoas{

	Pessoas[] arrayPessoas = new Pessoas[200];
	private int len = 0;
	private boolean gerente = false;
	
	public void inserir(Cliente pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception{
		try {
			procurarCliente(pessoa.getCpf());
			throw new PessoaJaCadastradaException(pessoa.getCpf());
		}
		catch(PessoaNaoCadastradaExeception e) {
			this.arrayPessoas[this.len] = pessoa;
			this.len += 1;
		}
		
	}

	// Cliente e Funcionarios
	public void removerCliente(String cpf) throws PessoaNaoCadastradaExeception {
		Cliente pessoa = procurarCliente(cpf);
		int pessoaIndex = -1;
		
		for(int i=0; i< this.len; i++) {
			if(this.arrayPessoas[i].getCpf().equals(pessoa.getCpf())) {
				pessoaIndex = i;
			}
		}
		
		if (pessoaIndex != -1) {
			for (int i = pessoaIndex; i < this.len - 1; i++) {
				this.arrayPessoas[i] = this.arrayPessoas[i + 1];
			}
		}
		else {
			throw new PessoaNaoCadastradaExeception(cpf);
		}

		
	}
	
	
	public Cliente procurarCliente(String cpf) throws PessoaNaoCadastradaExeception {
		boolean find = false;
		Cliente pessoaAchada = null;
		for (int i = 0; i < this.len; i++) {
			if (!find) {
				String cpfPessoa = this.arrayPessoas[i].getCpf();
				if (cpfPessoa.equals(cpf)) {
					find = !find;
					pessoaAchada = (Cliente) this.arrayPessoas[i];
				}
			}
		}
		
		if(pessoaAchada == null) {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
		else {
			return pessoaAchada;
		}
	}


	public void atualizar(Cliente pessoa) throws PessoaNaoCadastradaExeception {
		
		int pessoaIndex = -1;
		
		for(int i=0; i< this.len; i++) {
			if(this.arrayPessoas[i].getCpf().equals(pessoa.getCpf())) {
				pessoaIndex = i;
			}
		}
		
		if(pessoaIndex == -1) {
			throw new PessoaNaoCadastradaExeception(pessoa.getCpf());
		}
		else {
			this.arrayPessoas[pessoaIndex] = pessoa;
		}
		
	}


// -------------------------------------------- Funcionario --------------------------------------------------------------------	
	
	public void inserir(Funcionario pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception,GerenteJaExistenteException {
		try {
			procurarFuncionario(pessoa.getCpf());
			throw new PessoaJaCadastradaException(pessoa.getCpf());
		}
		catch(PessoaNaoCadastradaExeception e) {
			if(pessoa.getCargo().equals("Gerente")) {
				this.gerente = true;
			}
			this.arrayPessoas[this.len] = pessoa;
			this.len += 1;
		}
		
		
	}

	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoCadastradaExeception {
		boolean find = false;
		Funcionario pessoaAchada = null;
		for (int i = 0; i < this.len; i++) {
			if (!find) {
				String cpfPessoa = this.arrayPessoas[i].getCpf();
				if (cpfPessoa.equals(cpf)) {
					find = !find;
					//System.out.println(cpfPessoa);
					//System.out.println(cpf);
					pessoaAchada = (Funcionario) this.arrayPessoas[i];
				}
			}
		}
		
		if(pessoaAchada == null) {
			throw new PessoaNaoCadastradaExeception(cpf);
		}
		else {
			return pessoaAchada;
		}
	}

	public void atualizar(Funcionario pessoa) throws PessoaNaoCadastradaExeception {
		int pessoaIndex = -1;
				
		for(int i=0; i< this.len; i++) {
			if(this.arrayPessoas[i].getCpf().equals(pessoa.getCpf())) {
				pessoaIndex = i;
			}
		}
		
		if(pessoaIndex == -1) {
			throw new PessoaNaoCadastradaExeception(pessoa.getCpf());
		}
		else {
			this.arrayPessoas[pessoaIndex] = pessoa;
		}
		
	}

	public void removerFuncionario(String cpf) throws PessoaNaoCadastradaExeception {
		Funcionario pessoa = procurarFuncionario(cpf);
		int pessoaIndex = -1;
		
		for(int i=0; i< this.len; i++) {
			if(this.arrayPessoas[i].getCpf().equals(pessoa.getCpf())) {
				pessoaIndex = i;
			}
		}
		
		if (pessoaIndex != -1) {
			if(((Funcionario) this.arrayPessoas[pessoaIndex]).getCargo().equals("Gerente")) {
				this.gerente = false;
			}
			for (int i = pessoaIndex; i < this.len - 1; i++) {
				this.arrayPessoas[i] = this.arrayPessoas[i + 1];
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

package fachada;

import alpvj.*;
import mvpn.*;
import dvcc.*;
import phrp.*;
import jbmn2.*;

public class MCin_Donalds {
	NegociosSobremesas sobremesas;
	NegociosCafeManha cafeManha;
	NegociosHamburguers hamburguers;
	NegociosBebidas bebidas;
	NegociosPessoas pessoas;

	public MCin_Donalds(RepositorioSobremesas repSobremesas, RepositorioCafeManha repCafeManha,
			RepositorioHamburguers repHamburguers, RepositorioBebidas repBebidas, RepositorioPessoas repPessoas) {

		this.sobremesas = new NegociosSobremesas(repSobremesas);
		this.cafeManha = new NegociosCafeManha(repCafeManha);
		this.hamburguers = new NegociosHamburguers(repHamburguers);
		this.bebidas = new NegociosBebidas(repBebidas);
		this.pessoas = new NegociosPessoas(repPessoas);

	}

	// Negocio Sobremesas

	public Sobremesas procurarSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException {
		return sobremesas.procurarSobremesa(nome_Sobremesa);
	}

	public boolean verificarSobremesa(String nome_Sobremesa) {
		return sobremesas.verificarSobremesa(nome_Sobremesa);
	}

	public void adicionarSobremesa(Sobremesas sobremesa) throws SobremesaJaExisteException {
		sobremesas.adicionarSobremesa(sobremesa);
	}

	public void removerSobremesa(String nome_Sobremesa) throws SobremesaInexistenteException {
		sobremesas.removerSobremesa(nome_Sobremesa);
	}

	public void atualizarNomeSobremesa(String nome_Antigo, String nome_Novo)
			throws SobremesaInexistenteException, SobremesaJaExisteException {
		sobremesas.atualizarNomeSobremesa(nome_Antigo, nome_Novo);
	}

	public void atualizarPrecoSobremesa(String nome, double preco) throws SobremesaInexistenteException {
		sobremesas.atualizarPrecoSobremesa(nome, preco);
	}

	public void atualizarSobremesa(String nome, Sobremesas sobremesa)
			throws SobremesaInexistenteException, SobremesaJaExisteException {
		sobremesas.atualizarSobremesa(nome, sobremesa);
	}

	// Negocio Hamburguers

	public void inserir(Hamburguer hamburguer) throws HamburguerExistenteException {

		if (!this.hamburguers.checarHamburguer(hamburguer.getNome())) {
			this.hamburguers.inserir(hamburguer);
		} else {
			throw new HamburguerExistenteException();
		}
	}

	public void remover(String nome) throws HamburguerInexistenteException {

		if (this.hamburguers.checarHamburguer(nome)) {
			this.hamburguers.remover(nome);
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public void atualizar(String nomeAntigo, String nomeNovo, double preco) throws HamburguerInexistenteException {

		if (this.hamburguers.checarHamburguer(nomeAntigo)) {
			this.hamburguers.atualizar(nomeAntigo, nomeNovo, preco);

		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public Hamburguer procurar(String nome) throws HamburguerInexistenteException {

		if (this.hamburguers.checarHamburguer(nome)) {
			return this.hamburguers.procurar(nome);
		} else {
			throw new HamburguerInexistenteException();
		}
	}

	public boolean checarHamburguer(String nome) {
		return false;
	}

	// Negocio Bebidas

	public void inserirBebidas(Bebidas bebida) throws BebidaExistenteException {

		if (!bebidas.existeBebidas(bebida)) {
			bebidas.inserirBebidas(bebida);
		} else {
			throw new BebidaExistenteException();
		}
	}

	public void removerBebidas(Bebidas bebida) throws BebidaInexistenteException {

		if (bebidas.existeBebidas(bebida)) {
			bebidas.removerBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public Bebidas procurarBebidas(Bebidas bebida) throws BebidaInexistenteException {
		if (bebidas.existeBebidas(bebida)) {
			return bebidas.procurarBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	public boolean existeBebidas(Bebidas bebida) {
		if (bebidas.existeBebidas(bebida)) {
			return true;
		} else {
			return false;
		}
	}

	public void atualizarBebidas(Bebidas bebida) throws BebidaInexistenteException {
		if (bebidas.existeBebidas(bebida)) {
			bebidas.atualizarBebidas(bebida);
		} else {
			throw new BebidaInexistenteException();
		}
	}

	// Negocio CafeManha

	public CafeManha encontrarCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		return cafeManha.encontrarCafeManha(nomeDoProduto);
	}

	public boolean checarCafeManha(String nomeDoProduto) {
		return cafeManha.checarCafeManha(nomeDoProduto);
	}

	public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException {
		cafeManha.adicionarCafeManha(cafemanha);
	}

	public void removerCafeManha(String nomeDoProduto) throws CafeDaManhaInexistenteException {
		cafeManha.removerCafeManha(nomeDoProduto);
	}

	public void atualizarNome(String nomeDesatualizado, String nomeAtual)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		cafeManha.atualizarNome(nomeDesatualizado, nomeAtual);
	}

	public void atualizarValor(String nomeDoproduto, double valor) throws CafeDaManhaInexistenteException {
		cafeManha.atualizarValor(nomeDoproduto, valor);
	}

	public void atualizarCafeManha(String nomeDoproduto, CafeManha cafemanha)
			throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException {
		cafeManha.atualizarCafeManha(nomeDoproduto, cafemanha);
	}

	// Negocio Pessoas

	public void inserir(Cliente pessoa)
			throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception, CPFInvalidoException {
		if (pessoa.getCpf().length() != 11) {
			throw new CPFInvalidoException();
		} else {
			this.pessoas.inserir(pessoa);
		}
	}

	public void inserir(Funcionario pessoa) throws PessoaJaCadastradaException, PessoaNaoCadastradaExeception,
			GerenteJaExistenteException, CPFInvalidoException {
		if (pessoa.getCpf().length() != 11) {
			throw new CPFInvalidoException();
		} else if (this.pessoas.getGerenteState()) {
			throw new GerenteJaExistenteException();
		} else {
			this.pessoas.inserir(pessoa);
		}
	}

	public void removerCliente(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if (cpf.length() != 11) {
			throw new CPFInvalidoException();
		} else {
			this.pessoas.removerCliente(cpf);
		}
	}

	public void removerFuncionario(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if (cpf.length() != 11) {
			throw new CPFInvalidoException();
		} else {
			this.pessoas.removerFuncionario(cpf);
		}
	}

	public Cliente procurarCliente(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if (cpf.length() != 11) {
			throw new CPFInvalidoException();
		} else {
			return this.pessoas.procurarCliente(cpf);
		}
	}

	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoCadastradaExeception, CPFInvalidoException {
		if (cpf.length() != 11) {
			throw new CPFInvalidoException();
		} else {
			return this.pessoas.procurarFuncionario(cpf);
		}
	}

	public void atualizar(Funcionario pessoa) throws PessoaNaoCadastradaExeception {
		this.pessoas.atualizar(pessoa);
	}

	public void atualizar(Cliente pessoa) throws PessoaNaoCadastradaExeception {
		this.pessoas.atualizar(pessoa);
	}

	public boolean getGerenteState() {
		return this.pessoas.getGerenteState();
	}

	public boolean existeCliente(String cpf) throws PessoaNaoCadastradaExeception {
		return this.pessoas.existeCliente(cpf);
	}

	public boolean existeFuncionario(String cpf) throws PessoaNaoCadastradaExeception {
		return this.pessoas.existeFuncionario(cpf);
	}

}
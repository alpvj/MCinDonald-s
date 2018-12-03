package fachada;

import alpvj.*;
import mvpn.*;
import dvcc.*;
import phrp.*;
import jbmn2.*;

public class Programa {
	public static void main(String[] args)
			throws HamburguerExistenteException, HamburguerInexistenteException, BebidaExistenteException,
			BebidaInexistenteException, SobremesaInexistenteException, SobremesaJaExisteException,
			CafeDaManhaInexistenteException, CafeDaManhaJaExisteException, PessoaJaCadastradaException,
			PessoaNaoCadastradaExeception, GerenteJaExistenteException, CPFInvalidoException {

		// Testanto as Sobremesas (alpvj)

		RepositorioListaSobremesas repositorioSobremesasLista = new RepositorioListaSobremesas();
		NegociosSobremesas negLista = new NegociosSobremesas(repositorioSobremesasLista);

		RepositorioArraySobremesas repositorioSobremesasArray = new RepositorioArraySobremesas();
		NegociosSobremesas negArray = new NegociosSobremesas(repositorioSobremesasArray);

		// LISTA //
		System.out.println("--------------COMECANDO O TESTE DAS SOBREMESAS--------------\nRepositorio em Lista:");
		Sobremesas sunday = new Sobremesas();
		sunday.setNome("Sunday");
		sunday.setPreco(6.49);

		Sobremesas mcFlurry = new Sobremesas();
		mcFlurry.setNome("McFlurry");
		mcFlurry.setPreco(11.01);

		Sobremesas mcColosso = new Sobremesas();
		mcColosso.setNome("McColosso");
		mcColosso.setPreco(3.49);

		Sobremesas casquinha = new Sobremesas();
		casquinha.setNome("Casquinha");
		casquinha.setPreco(2.49);

		negLista.adicionarSobremesa(sunday);
		negLista.adicionarSobremesa(mcFlurry);
		negLista.adicionarSobremesa(mcColosso);
		negLista.adicionarSobremesa(casquinha);
		if (negLista.verificarSobremesa(sunday.getNome()) && negLista.verificarSobremesa(mcFlurry.getNome())
				&& negLista.verificarSobremesa(mcColosso.getNome())
				&& negLista.verificarSobremesa(casquinha.getNome())) {
			System.out.println("Sobremesa " + sunday.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + mcFlurry.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + mcColosso.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + casquinha.getNome() + " adicionada com sucesso!\n");
		}

		negLista.removerSobremesa("Sunday");
		if (!negLista.verificarSobremesa("Sunday"))
			System.out.println("Sobremesa Sunday removida com sucesso!\n");
		else
			System.out.println("A sobremesa Sunday ainda esta no repositorio.\n");

		System.out.println(
				"O preco da Sobremesa McFlurry e: R$ " + negLista.procurarSobremesa("McFlurry").getPreco() + "\n");

		negLista.atualizarPrecoSobremesa("McColosso", 0.35);
		negLista.atualizarNomeSobremesa("McColosso", "McColossoEmPromocao");
		System.out.println(
				"Novo nome do McColosso: " + mcColosso.getNome() + "\nNovo preco do McColosso " + mcColosso.getPreco());

		Sobremesas mcColosso2 = new Sobremesas();
		mcColosso2.setNome("McColosso");
		mcColosso2.setPreco(3.49);
		negLista.atualizarSobremesa(mcColosso.getNome(), mcColosso2);

		System.out.println(
				"O nome do McColosso voltou a ser: " + mcColosso.getNome() + ". E o preco: " + mcColosso.getPreco());

		// ARRAY //
		System.out.println("\nRepositorio em Array:");
		Sobremesas iceCream = new Sobremesas();
		iceCream.setNome("IceCream");
		iceCream.setPreco(1.99);

		Sobremesas applePie = new Sobremesas();
		applePie.setNome("Apple Pie");
		applePie.setPreco(0.99);

		Sobremesas freshApple = new Sobremesas();
		freshApple.setNome("Apple");
		freshApple.setPreco(0.51);

		negArray.adicionarSobremesa(iceCream);
		negArray.adicionarSobremesa(applePie);
		negArray.adicionarSobremesa(freshApple);
		if (negArray.verificarSobremesa(iceCream.getNome()) && negArray.verificarSobremesa(applePie.getNome())
				&& negArray.verificarSobremesa(freshApple.getNome())) {
			System.out.println("Sobremesa " + iceCream.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + applePie.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + freshApple.getNome() + " adicionada com sucesso!\n");
		}

		negArray.removerSobremesa(freshApple.getNome());
		if (!negArray.verificarSobremesa("Apple"))
			System.out.println("Sobremesa Apple removida com sucesso!\n");
		else
			System.out.println("A sobremesa Apple ainda esta no repositorio.\n");

		System.out.println("O preco de um IceCream e: $" + iceCream.getPreco());
		negArray.atualizarNomeSobremesa(iceCream.getNome(), "IceCreamPromotional");
		negArray.atualizarPrecoSobremesa(iceCream.getNome(), 0.99);

		System.out.println("Nome promocional para a sobremesa IceCream e: " + iceCream.getNome() + ". E o preco e: "
				+ iceCream.getPreco() + "\n");

		Sobremesas iceCream2 = new Sobremesas();
		iceCream2.setNome("IceCream");
		iceCream2.setPreco(1.99);
		negArray.atualizarSobremesa(iceCream.getNome(), iceCream2);
		System.out.println("Acabou a promocao! O nome voltou a ser: " + iceCream.getNome() + ". E o preco: "
				+ iceCream.getPreco());
		System.out.println("--------------ACABOU O TESTE DAS SOBREMESAS--------------\n");

		// TESTE DOS HAMBURGUERES (mvpn)

		RepositorioHamburguersLista repLista = new RepositorioHamburguersLista();
		NegociosHamburguers negListaHamburguer = new NegociosHamburguers(repLista);

		RepositorioHamburguersArray repArray = new RepositorioHamburguersArray();
		NegociosHamburguers negArrayHamburguer = new NegociosHamburguers(repArray);

		// TESTANDO A LISTA

		System.out.println("TESTANDO A LISTA");
		Hamburguer McFish = new Hamburguer(null, 0);
		Hamburguer Cheddar = new Hamburguer(null, 0);
		Hamburguer BigMc = new Hamburguer(null, 0);

		McFish.setNome("McFish");
		McFish.setPreco(10);
		Cheddar.setNome("Cheddar");
		Cheddar.setPreco(15);
		BigMc.setNome("BigMc");
		BigMc.setPreco(20);

		System.out.println("Inserindo os hamburgueres no repositorio!\n");
		negListaHamburguer.inserir(McFish);
		negListaHamburguer.inserir(Cheddar);
		negListaHamburguer.inserir(BigMc);

		if (negListaHamburguer.checarHamburguer(McFish.getNome())
				&& negListaHamburguer.checarHamburguer(Cheddar.getNome())
				&& negListaHamburguer.checarHamburguer(BigMc.getNome())) {
			System.out.println(
					"O hamburguer " + negListaHamburguer.procurar("McFish").getNome() + " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + negListaHamburguer.procurar("Cheddar").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + negListaHamburguer.procurar("BigMc").getNome()
					+ " foi adicionado com sucesso!\n");
		}

		System.out.println("Removendo hamburgueres!\n");
		negListaHamburguer.remover("McFish");
		if (!negListaHamburguer.checarHamburguer("McFish")) {
			System.out.println("O hamburguer foi removido!\n");
		} else {
			System.out.println("O hamburguer nao foi removido!\n");
		}

		System.out.println("Atualizando um hamburguer!\n");
		String nomeAuxLista = negListaHamburguer.procurar("Cheddar").getNome();
		double precoAuxLista = negListaHamburguer.procurar("Cheddar").getPreco();
		negListaHamburguer.atualizar("Cheddar", "McCrispy", 100.75);
		System.out.println("O nome do hamburguer era " + nomeAuxLista + " e o preco era " + precoAuxLista
				+ ". Agora, o nome foi atualizado para " + negListaHamburguer.procurar("McCrispy").getNome()
				+ " e o preco para " + negListaHamburguer.procurar("McCrispy").getPreco() + ("!\n"));

		// TESTANDO O ARRAY

		System.out.println("TESTANDO O ARRAY");
		Hamburguer Veggie = new Hamburguer(null, 0);
		Hamburguer Quarteirao = new Hamburguer(null, 0);
		Hamburguer McChicken = new Hamburguer(null, 0);

		Veggie.setNome("McVeggie");
		Veggie.setPreco(22.5);
		Quarteirao.setNome("Quarteirao");
		Quarteirao.setPreco(17);
		McChicken.setNome("McChicken");
		McChicken.setPreco(14.99);

		System.out.println("Inserindo os hamburgueres no repositorio!\n");
		negArrayHamburguer.inserir(Veggie);
		negArrayHamburguer.inserir(Quarteirao);
		negArrayHamburguer.inserir(McChicken);

		if (negArrayHamburguer.checarHamburguer(Veggie.getNome())
				&& negArrayHamburguer.checarHamburguer(Quarteirao.getNome())
				&& negArrayHamburguer.checarHamburguer(McChicken.getNome())) {
			System.out.println("O hamburguer " + negArrayHamburguer.procurar("McVeggie").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + negArrayHamburguer.procurar("Quarteirao").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + negArrayHamburguer.procurar("McChicken").getNome()
					+ " foi adicionado com sucesso!\n");
		}

		System.out.println("Removendo hamburgueres!\n");
		negArrayHamburguer.remover("McVeggie");
		if (!negArrayHamburguer.checarHamburguer("McVeggie")) {
			System.out.println("O hamburguer foi removido!\n");
		} else {
			System.out.println("O hamburguer nao foi removido!\n");
		}

		System.out.println("Atualizando um hamburguer!\n");
		String nomeAuxArray = negArrayHamburguer.procurar("McChicken").getNome();
		double precoAuxArray = negArrayHamburguer.procurar("McChicken").getPreco();
		negArrayHamburguer.atualizar("McChicken", "DiretoriaLixo", 33.99);
		System.out.println("O nome do hamburguer era " + nomeAuxArray + " e o preco era " + precoAuxArray
				+ ". Agora, o nome foi atualizado para " + negArrayHamburguer.procurar("DiretoriaLixo").getNome()
				+ " e o preco para " + negArrayHamburguer.procurar("DiretoriaLixo").getPreco() + ("!\n"));
		System.out.println("FIM DOS TESTE DOS HAMBURGUERES");
		
		// Testanto as Pessoas (jbmn2)

				RepositorioPessoasLista repositorioPessoasLista = new RepositorioPessoasLista();
				NegociosPessoas negPessoasLista = new NegociosPessoas(repositorioPessoasLista);

				RepositorioPessoasArray repositorioPessoasArray = new RepositorioPessoasArray();
				NegociosPessoas negPessoasArray = new NegociosPessoas(repositorioPessoasArray);

				// LISTA //
				System.out.println("--------------COMECANDO O TESTE DAS PESSOAS--------------");
				System.out.println("Repositorio em Lista:");
				
				Cliente cliente1 = new Cliente("", "", 0, "");
				cliente1.setNome("Jose Bezerra");
				cliente1.setIdade(18);
				cliente1.setCpf("13384332458");
				cliente1.setPratoPreferido("Big Mac");

				Cliente cliente2 = new Cliente("", "", 0, "");
				cliente2.setNome("Pedro Ribeiro");
				cliente2.setIdade(24);
				cliente2.setCpf("00000000002");
				cliente2.setPratoPreferido("Angus Bacon");
				
				Funcionario funcionario1 = new Funcionario("", "", 0, 0, "", "", "", "");
				funcionario1.setNome("Andre Vasconcelos");
				funcionario1.setIdade(19);
				funcionario1.setCpf("00000000001");
				funcionario1.setAntecedentesCriminais("NENHUM");
				funcionario1.setCargo("Gerente");
				funcionario1.setEndereco("R. Visconde de Jequitinhonha 1140");
				funcionario1.setEstadoCivil("NAMORANDO");
				
				Funcionario funcionario2 = new Funcionario("", "", 0, 0, "", "", "", "");
				funcionario2.setNome("Marcos Pryston");
				funcionario2.setIdade(18);
				funcionario2.setCpf("00000000003");
				funcionario2.setAntecedentesCriminais("NENHUM");
				funcionario2.setCargo("Caixa");
				funcionario2.setEndereco("R. Visconde de Jequitinhonha 0001");
				funcionario2.setEstadoCivil("NAMORANDO");
				

				negPessoasLista.inserir(cliente1);
				negPessoasLista.inserir(cliente2);
				negPessoasLista.inserir(funcionario1);
				negPessoasLista.inserir(funcionario2);
				
				if (negPessoasLista.existeCliente(cliente1.getCpf()) 
					&& negPessoasLista.existeCliente(cliente2.getCpf())
						&& negPessoasLista.existeFuncionario(funcionario1.getCpf())
						&& negPessoasLista.existeFuncionario(funcionario2.getCpf())) {
					System.out.println("Cliente " + cliente1.getNome() + " adicionado com sucesso!");
					System.out.println("Cliente " + cliente2.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario1.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario2.getNome() + " adicionado com sucesso!\n");
				}

				negPessoasLista.removerCliente(cliente1.getCpf());
				negPessoasLista.removerFuncionario(funcionario2.getCpf());
				
				if (!negPessoasLista.existeCliente(cliente1.getCpf()))
					System.out.println("Cliente " +cliente1.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Cliente " +cliente1.getNome()+" ainda existe no repositorio!\n");

				
				if (!negPessoasLista.existeFuncionario(funcionario2.getCpf()))
					System.out.println("Funcionario " +funcionario2.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Funcionario " +funcionario2.getNome()+" ainda existe no repositorio!\n");
				
				
				System.out.println("O prato preferido de "+ cliente2.getNome() +" e "+cliente2.getPratoPreferido());

				Cliente cliente2Atualizado = new Cliente(cliente2.getCpf(),cliente2.getNome(),cliente2.getIdade(), "Angus Deluxe");
				
				negPessoasLista.atualizar(cliente2Atualizado);
				
				System.out.println("O prato preferido de "+ cliente2.getNome() +" e "+cliente2.getPratoPreferido());

				System.out.println("");
				
				System.out.println("O cargo de "+ funcionario1.getNome() +" e "+funcionario1.getCargo());
				
				Funcionario funcionario1Atualizado = new Funcionario(funcionario1.getCpf(), funcionario1.getNome(), funcionario1.getIdade(), funcionario1.getRg(), "Servicos Gerais", funcionario1.getEndereco(), funcionario1.getEstadoCivil(), funcionario1.getAntecedentesCriminais());
				
				negPessoasLista.atualizar(funcionario1Atualizado);
				
				System.out.println("O cargo de "+ funcionario1.getNome() +" e "+funcionario1.getCargo());
				
				
				
				// ARRAY //
				System.out.println("\nRepostorio em Array:\n");
				Cliente cliente1Array = new Cliente("", "", 0, "");
				cliente1Array.setNome("Jose Bezerra");
				cliente1Array.setIdade(18);
				cliente1Array.setCpf("13384332458");
				cliente1Array.setPratoPreferido("Big Mac");
				
				Cliente cliente2Array = new Cliente("", "", 0, "");
				cliente2Array.setNome("Pedro Ribeiro");
				cliente2Array.setIdade(24);
				cliente2Array.setCpf("00000000001");
				cliente2Array.setPratoPreferido("Angus Bacon");
				
				Funcionario funcionario1Array = new Funcionario("", "", 0, 0, "", "", "", "");
				funcionario1Array.setNome("Andre Vasconcelos");
				funcionario1Array.setIdade(19);
				funcionario1Array.setCpf("00000000002");
				funcionario1Array.setAntecedentesCriminais("NENHUM");
				funcionario1Array.setCargo("Gerente");
				funcionario1Array.setEndereco("R. Visconde de Jequitinhonha 1140");
				funcionario1Array.setEstadoCivil("NAMORANDO");
				
				Funcionario funcionario2Array = new Funcionario("", "", 0, 0, "", "", "", "");
				funcionario2Array.setNome("Marcos Pryston");
				funcionario2Array.setIdade(18);
				funcionario2Array.setCpf("00000000003");
				funcionario2Array.setAntecedentesCriminais("NENHUM");
				funcionario2Array.setCargo("Caixa");
				funcionario2Array.setEndereco("R. Visconde de Jequitinhonha 0001");
				funcionario2Array.setEstadoCivil("NAMORANDO");
				
				negPessoasArray.inserir(cliente1Array);
				negPessoasArray.inserir(cliente2Array);
				negPessoasArray.inserir(funcionario1Array);
				negPessoasArray.inserir(funcionario2Array);
				
				if (negPessoasArray.existeCliente(cliente1Array.getCpf()) 
					&& negPessoasArray.existeCliente(cliente2Array.getCpf())
						&& negPessoasArray.existeFuncionario(funcionario1Array.getCpf())
						&& negPessoasArray.existeFuncionario(funcionario2Array.getCpf())) {
					System.out.println("Cliente " + cliente1Array.getNome() + " adicionado com sucesso!");
					System.out.println("Cliente " + cliente2Array.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario1Array.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario2Array.getNome() + " adicionado com sucesso!\n");
				}

				negPessoasArray.removerCliente(cliente1Array.getCpf());
				negPessoasArray.removerFuncionario(funcionario2Array.getCpf());
				
				if (!negPessoasArray.existeCliente(cliente1Array.getCpf()))
					System.out.println("Cliente " +cliente1Array.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Cliente " +cliente1Array.getNome()+" ainda existe no repositorio!\n");

				
				if (!negPessoasArray.existeFuncionario(funcionario2Array.getCpf()))
					System.out.println("Funcionario " +funcionario2Array.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Funcionario " +funcionario2Array.getNome()+" ainda existe no repositorio!\n");
				
				
				System.out.println("O prato preferido de "+ cliente2Array.getNome() +" e "+cliente2Array.getPratoPreferido());

				Cliente cliente2AtualizadoArray = new Cliente(cliente2Array.getCpf(),cliente2Array.getNome(),cliente2Array.getIdade(), "Angus Deluxe");
				
				negPessoasArray.atualizar(cliente2AtualizadoArray);
				
				System.out.println("O prato preferido de "+ cliente2Array.getNome() +" e "+cliente2Array.getPratoPreferido());

				System.out.println("");
				
				System.out.println("O cargo de "+ funcionario1Array.getNome() +" e "+funcionario1Array.getCargo());
				
				Funcionario funcionario1AtualizadoArray = new Funcionario(funcionario1Array.getCpf(), funcionario1Array.getNome(), funcionario1Array.getIdade(), funcionario1Array.getRg(), "Servicos Gerais", funcionario1Array.getEndereco(), funcionario1Array.getEstadoCivil(), funcionario1Array.getAntecedentesCriminais());
				
				negPessoasArray.atualizar(funcionario1AtualizadoArray);
				
				System.out.println("O cargo de "+ funcionario1.getNome() +" e "+funcionario1.getCargo());
				
				
				System.out.println("--------------ACABOU O TESTE DAS PESSOAS--------------\n");
				
	}
}

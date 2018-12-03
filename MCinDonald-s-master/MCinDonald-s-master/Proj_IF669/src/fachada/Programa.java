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
		RepositorioArraySobremesas repositorioSobremesasArray = new RepositorioArraySobremesas();
		//
		RepositorioHamburguersLista repLista = new RepositorioHamburguersLista();
		RepositorioHamburguersArray repArray = new RepositorioHamburguersArray();
		//
		RepositorioPessoasLista repositorioPessoasLista = new RepositorioPessoasLista();
		RepositorioPessoasArray repositorioPessoasArray = new RepositorioPessoasArray();
	
		//
		RepositorioBebidasLista repositorioBebidasLista = new RepositorioBebidasLista();
		RepositorioBebidasArray repositorioBebidasArray = new RepositorioBebidasArray();

		//
		RepositorioListaCafeManha repositorioCafeManhaLista = new RepositorioListaCafeManha();
		RepositorioArrayCafeManha repositorioCafeManhaArray = new RepositorioArrayCafeManha();

		
		MCin_Donalds admLista = new MCin_Donalds(repositorioSobremesasLista, repositorioCafeManhaLista, repLista, repositorioBebidasLista,repositorioPessoasLista );
		MCin_Donalds admArray = new MCin_Donalds(repositorioSobremesasArray, repositorioCafeManhaArray, repArray, repositorioBebidasArray,repositorioPessoasArray );

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

		admLista.adicionarSobremesa(sunday);
		admLista.adicionarSobremesa(mcFlurry);
		admLista.adicionarSobremesa(mcColosso);
		admLista.adicionarSobremesa(casquinha);
		if (admLista.verificarSobremesa(sunday.getNome()) && admLista.verificarSobremesa(mcFlurry.getNome())
				&& admLista.verificarSobremesa(mcColosso.getNome())
				&& admLista.verificarSobremesa(casquinha.getNome())) {
			System.out.println("Sobremesa " + sunday.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + mcFlurry.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + mcColosso.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + casquinha.getNome() + " adicionada com sucesso!\n");
		}

		admLista.removerSobremesa("Sunday");
		if (!admLista.verificarSobremesa("Sunday"))
			System.out.println("Sobremesa Sunday removida com sucesso!\n");
		else
			System.out.println("A sobremesa Sunday ainda esta no repositorio.\n");

		System.out.println(
				"O preco da Sobremesa McFlurry e: R$ " + admLista.procurarSobremesa("McFlurry").getPreco() + "\n");

		admLista.atualizarPrecoSobremesa("McColosso", 0.35);
		admLista.atualizarNomeSobremesa("McColosso", "McColossoEmPromocao");
		System.out.println(
				"Novo nome do McColosso: " + mcColosso.getNome() + "\nNovo preco do McColosso " + mcColosso.getPreco());

		Sobremesas mcColosso2 = new Sobremesas();
		mcColosso2.setNome("McColosso");
		mcColosso2.setPreco(3.49);
		admLista.atualizarSobremesa(mcColosso.getNome(), mcColosso2);

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

		admArray.adicionarSobremesa(iceCream);
		admArray.adicionarSobremesa(applePie);
		admArray.adicionarSobremesa(freshApple);
		if (admArray.verificarSobremesa(iceCream.getNome()) && admArray.verificarSobremesa(applePie.getNome())
				&& admArray.verificarSobremesa(freshApple.getNome())) {
			System.out.println("Sobremesa " + iceCream.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + applePie.getNome() + " adicionada com sucesso!");
			System.out.println("Sobremesa " + freshApple.getNome() + " adicionada com sucesso!\n");
		}

		admArray.removerSobremesa(freshApple.getNome());
		if (!admArray.verificarSobremesa("Apple"))
			System.out.println("Sobremesa Apple removida com sucesso!\n");
		else
			System.out.println("A sobremesa Apple ainda esta no repositorio.\n");

		System.out.println("O preco de um IceCream e: $" + iceCream.getPreco());
		admArray.atualizarNomeSobremesa(iceCream.getNome(), "IceCreamPromotional");
		admArray.atualizarPrecoSobremesa(iceCream.getNome(), 0.99);

		System.out.println("Nome promocional para a sobremesa IceCream e: " + iceCream.getNome() + ". E o preco e: "
				+ iceCream.getPreco() + "\n");

		Sobremesas iceCream2 = new Sobremesas();
		iceCream2.setNome("IceCream");
		iceCream2.setPreco(1.99);
		admArray.atualizarSobremesa(iceCream.getNome(), iceCream2);
		System.out.println("Acabou a promocao! O nome voltou a ser: " + iceCream.getNome() + ". E o preco: "
				+ iceCream.getPreco());
		System.out.println("--------------ACABOU O TESTE DAS SOBREMESAS--------------\n");

		// TESTE DOS HAMBURGUERES (mvpn)

		System.out.println("--------------COMECANDO O TESTE DOS HAMBURGERS--------------\n");

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
		admLista.inserir(McFish);
		admLista.inserir(Cheddar);
		admLista.inserir(BigMc);

		if (admLista.checarHamburguer(McFish.getNome())
				&& admLista.checarHamburguer(Cheddar.getNome())
				&& admLista.checarHamburguer(BigMc.getNome())) {
			System.out.println(
					"O hamburguer " + admLista.procurar("McFish").getNome() + " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + admLista.procurar("Cheddar").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + admLista.procurar("BigMc").getNome()
					+ " foi adicionado com sucesso!\n");
		}

		System.out.println("Removendo hamburgueres!\n");
		admLista.remover("McFish");
		if (!admLista.checarHamburguer("McFish")) {
			System.out.println("O hamburguer foi removido!\n");
		} else {
			System.out.println("O hamburguer nao foi removido!\n");
		}

		System.out.println("Atualizando um hamburguer!\n");
		String nomeAuxLista = admLista.procurar("Cheddar").getNome();
		double precoAuxLista = admLista.procurar("Cheddar").getPreco();
		admLista.atualizar("Cheddar", "McCrispy", 100.75);
		System.out.println("O nome do hamburguer era " + nomeAuxLista + " e o preco era " + precoAuxLista
				+ ". Agora, o nome foi atualizado para " + admLista.procurar("McCrispy").getNome()
				+ " e o preco para " + admLista.procurar("McCrispy").getPreco() + ("!\n"));

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
		admArray.inserir(Veggie);
		admArray.inserir(Quarteirao);
		admArray.inserir(McChicken);

		if (admArray.checarHamburguer(Veggie.getNome())
				&& admArray.checarHamburguer(Quarteirao.getNome())
				&& admArray.checarHamburguer(McChicken.getNome())) {
			System.out.println("O hamburguer " + admArray.procurar("McVeggie").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + admArray.procurar("Quarteirao").getNome()
					+ " foi adicionado com sucesso!");
			System.out.println("O hamburguer " + admArray.procurar("McChicken").getNome()
					+ " foi adicionado com sucesso!\n");
		}

		System.out.println("Removendo hamburgueres!\n");
		admArray.remover("McVeggie");
		if (!admArray.checarHamburguer("McVeggie")) {
			System.out.println("O hamburguer foi removido!\n");
		} else {
			System.out.println("O hamburguer nao foi removido!\n");
		}

		System.out.println("Atualizando um hamburguer!\n");
		String nomeAuxArray = admArray.procurar("McChicken").getNome();
		double precoAuxArray = admArray.procurar("McChicken").getPreco();
		admArray.atualizar("McChicken", "DiretoriaLixo", 33.99);
		System.out.println("O nome do hamburguer era " + nomeAuxArray + " e o preco era " + precoAuxArray
				+ ". Agora, o nome foi atualizado para " + admArray.procurar("DiretoriaLixo").getNome()
				+ " e o preco para " + admArray.procurar("DiretoriaLixo").getPreco() + ("!\n"));
		System.out.println("FIM DOS TESTE DOS HAMBURGUERES");
		
		System.out.println("--------------ACABOU O TESTE DOS HAMBURGUERS--------------\n");
		
		// Testanto as Pessoas (jbmn2)

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
				

				admLista.inserir(cliente1);
				admLista.inserir(cliente2);
				admLista.inserir(funcionario1);
				admLista.inserir(funcionario2);
				
				if (admLista.existeCliente(cliente1.getCpf()) 
					&& admLista.existeCliente(cliente2.getCpf())
						&& admLista.existeFuncionario(funcionario1.getCpf())
						&& admLista.existeFuncionario(funcionario2.getCpf())) {
					System.out.println("Cliente " + cliente1.getNome() + " adicionado com sucesso!");
					System.out.println("Cliente " + cliente2.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario1.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario2.getNome() + " adicionado com sucesso!\n");
				}

				admLista.removerCliente(cliente1.getCpf());
				admLista.removerFuncionario(funcionario2.getCpf());
				
				if (!admLista.existeCliente(cliente1.getCpf()))
					System.out.println("Cliente " +cliente1.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Cliente " +cliente1.getNome()+" ainda existe no repositorio!\n");

				
				if (!admLista.existeFuncionario(funcionario2.getCpf()))
					System.out.println("Funcionario " +funcionario2.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Funcionario " +funcionario2.getNome()+" ainda existe no repositorio!\n");
				
				
				System.out.println("O prato preferido de "+ cliente2.getNome() +" e "+cliente2.getPratoPreferido());

				Cliente cliente2Atualizado = new Cliente(cliente2.getCpf(),cliente2.getNome(),cliente2.getIdade(), "Angus Deluxe");
				
				admLista.atualizar(cliente2Atualizado);
				
				System.out.println("O prato preferido de "+ cliente2.getNome() +" e "+cliente2.getPratoPreferido());

				System.out.println("");
				
				System.out.println("O cargo de "+ funcionario1.getNome() +" e "+funcionario1.getCargo());
				
				Funcionario funcionario1Atualizado = new Funcionario(funcionario1.getCpf(), funcionario1.getNome(), funcionario1.getIdade(), funcionario1.getRg(), "Servicos Gerais", funcionario1.getEndereco(), funcionario1.getEstadoCivil(), funcionario1.getAntecedentesCriminais());
				
				admLista.atualizar(funcionario1Atualizado);
				
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
				funcionario1Array.setCargo("SG");
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
				
				admArray.inserir(cliente1Array);
				admArray.inserir(cliente2Array);
				admArray.inserir(funcionario1Array);
				admArray.inserir(funcionario2Array);
				
				if (admArray.existeCliente(cliente1Array.getCpf()) 
					&& admArray.existeCliente(cliente2Array.getCpf())
						&& admArray.existeFuncionario(funcionario1Array.getCpf())
						&& admArray.existeFuncionario(funcionario2Array.getCpf())) {
					System.out.println("Cliente " + cliente1Array.getNome() + " adicionado com sucesso!");
					System.out.println("Cliente " + cliente2Array.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario1Array.getNome() + " adicionado com sucesso!");
					System.out.println("Funcionario " + funcionario2Array.getNome() + " adicionado com sucesso!\n");
				}

				admArray.removerCliente(cliente1Array.getCpf());
				admArray.removerFuncionario(funcionario2Array.getCpf());
				
				if (!admArray.existeCliente(cliente1Array.getCpf()))
					System.out.println("Cliente " +cliente1Array.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Cliente " +cliente1Array.getNome()+" ainda existe no repositorio!\n");

				
				if (!admArray.existeFuncionario(funcionario2Array.getCpf()))
					System.out.println("Funcionario " +funcionario2Array.getNome()+" removido com sucesso!\n");
				else
					System.out.println("Funcionario " +funcionario2Array.getNome()+" ainda existe no repositorio!\n");
				
				
				System.out.println("O prato preferido de "+ cliente2Array.getNome() +" e "+cliente2Array.getPratoPreferido());

				Cliente cliente2AtualizadoArray = new Cliente(cliente2Array.getCpf(),cliente2Array.getNome(),cliente2Array.getIdade(), "Angus Deluxe");
				
				admArray.atualizar(cliente2AtualizadoArray);
				
				System.out.println("O prato preferido de "+ cliente2Array.getNome() +" e "+cliente2Array.getPratoPreferido());

				System.out.println("");
				
				System.out.println("O cargo de "+ funcionario1Array.getNome() +" e "+funcionario1Array.getCargo());
				
				Funcionario funcionario1AtualizadoArray = new Funcionario(funcionario1Array.getCpf(), funcionario1Array.getNome(), funcionario1Array.getIdade(), funcionario1Array.getRg(), "Servicos Gerais", funcionario1Array.getEndereco(), funcionario1Array.getEstadoCivil(), funcionario1Array.getAntecedentesCriminais());
				
				admArray.atualizar(funcionario1AtualizadoArray);
				
				System.out.println("O cargo de "+ funcionario1.getNome() +" e "+funcionario1.getCargo());
				
				
				System.out.println("--------------ACABOU O TESTE DAS PESSOAS--------------\n");
				
				
				// Testanto as Bebidas (phrp)



				// LISTA
				System.out.println("--------------COMECANDO O TESTE DAS BEBIDAS--------------\nRepositorio em Lista:");

				Bebidas cocaCola = new Bebidas("", "",' ',0.0);
				cocaCola.setTipo("Refrigerante");
				cocaCola.setSabor("Coca-Cola");
				cocaCola.setTamanho('G');
				cocaCola.setPreco(9.99);

				Bebidas capuccino = new Bebidas("", "",' ' ,0.0);
				capuccino.setTipo("Cafe");
				capuccino.setSabor("Capuccino");
				capuccino.setTamanho('P');
				capuccino.setPreco(4.99);

				Bebidas sucoLaranja = new Bebidas("", "",' ' ,0.0);
				sucoLaranja.setTipo("Suco");
				sucoLaranja.setSabor("Laranja");
				sucoLaranja.setTamanho('M');
				sucoLaranja.setPreco(5.99);

				Bebidas agua = new Bebidas("", "",' ' ,0.0);
				agua.setTipo("Agua");
				agua.setSabor("Agua sem gas");
				agua.setTamanho('G');
				agua.setPreco(2.99);

				admLista.inserirBebidas(cocaCola);
				admLista.inserirBebidas(capuccino);
				admLista.inserirBebidas(sucoLaranja);
				admLista.inserirBebidas(agua);
				
				if (admLista.existeBebidas(cocaCola) && admLista.existeBebidas(capuccino)
						&& admLista.existeBebidas(sucoLaranja)
						&& admLista.existeBebidas(agua)) {
					System.out.println("A Bebida " + cocaCola.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + capuccino.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + sucoLaranja.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + agua.getSabor() + " foi adicionada com sucesso!\n");
				}

				admLista.removerBebidas(sucoLaranja);
				if (!admLista.existeBebidas(sucoLaranja))
					System.out.println("A Bebida Suco de Laranja foi removida com sucesso!\n");
				else
					System.out.println("A Bebida Suco de Laranja nao foi removida.\n");

				System.out.println("O preco da Bebida Coca-Cola e: R$ " + cocaCola.getPreco());
				
				Bebidas cocaColaAtualizada = new Bebidas("", "",' ',0.0);
				cocaColaAtualizada.setTipo("Refrigerante");
				cocaColaAtualizada.setSabor("Coca-Cola");
				cocaColaAtualizada.setTamanho('G');
				cocaColaAtualizada.setPreco(7.99);
				
				admLista.atualizarBebidas(cocaColaAtualizada);
				
				System.out.println("Novo Preco da Coca-Cola: R$ " + cocaColaAtualizada.getPreco() + "\n");
				
				System.out.println("O preco da Bebida Capuccino e: R$ " + capuccino.getPreco());

				Bebidas capuccinoAtualizado = new Bebidas("", "",' ',0.0);
				capuccinoAtualizado.setTipo("Cafe");
				capuccinoAtualizado.setSabor("Capuccino");
				capuccinoAtualizado.setTamanho('P');
				capuccinoAtualizado.setPreco(3.99);
				
				admLista.atualizarBebidas(capuccinoAtualizado);
				
				System.out.println("Novo Preco do Capuccino: " + capuccinoAtualizado.getPreco() + "\n");

				// ARRAY //
				
				System.out.println("\nRepositorio em Array:");
				Bebidas fantaUva = new Bebidas("", "",' ',0.0);
				fantaUva.setTipo("Refrigerante");
				fantaUva.setSabor("Fanta Uva");
				fantaUva.setTamanho('M');
				fantaUva.setPreco(7.99);

				Bebidas espresso = new Bebidas("", "",' ' ,0.0);
				espresso.setTipo("Cafe");
				espresso.setSabor("Espresso");
				espresso.setTamanho('M');
				espresso.setPreco(4.99);

				Bebidas sucoMaracuja = new Bebidas("", "",' ' ,0.0);
				sucoMaracuja.setTipo("Suco");
				sucoMaracuja.setSabor("Maracuja");
				sucoMaracuja.setTamanho('G');
				sucoMaracuja.setPreco(7.99);

				Bebidas aguaComGas = new Bebidas("", "",' ' ,0.0);
				aguaComGas.setTipo("Agua");
				aguaComGas.setSabor("Agua com gas");
				aguaComGas.setTamanho('M');
				aguaComGas.setPreco(3.99);

				admArray.inserirBebidas(fantaUva);
				admArray.inserirBebidas(espresso);
				admArray.inserirBebidas(sucoMaracuja);
				admArray.inserirBebidas(aguaComGas);
				if (admArray.existeBebidas(fantaUva) && admArray.existeBebidas(espresso)
						&& admArray.existeBebidas(sucoMaracuja)
						&& admArray.existeBebidas(aguaComGas)) {
					System.out.println("A Bebida " + fantaUva.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + espresso.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + sucoMaracuja.getSabor() + " foi adicionada com sucesso!");
					System.out.println("A Bebida " + aguaComGas.getSabor() + " foi adicionada com sucesso!\n");
				}

				admArray.removerBebidas(espresso);
				if (!admArray.existeBebidas(espresso))
					System.out.println("A Bebida Espresso foi removida com sucesso!\n");
				else
					System.out.println("A Bebida Espresso nao foi removida.\n");

				System.out.println("O preco da Agua Com Gas e: R$ " + aguaComGas.getPreco());
				
				Bebidas aguaComGasAtualizada = new Bebidas("", "",' ',0.0);
				aguaComGasAtualizada.setTipo("Agua");
				aguaComGasAtualizada.setSabor("Agua com gas");
				aguaComGasAtualizada.setTamanho('M');
				aguaComGasAtualizada.setPreco(4.99);
				
				admArray.atualizarBebidas(aguaComGasAtualizada);
				
				System.out.println("Novo Preco da Agua Com Gas: R$ " + aguaComGasAtualizada.getPreco() + "\n");
				
				System.out.println("O preco da Bebida Suco de Maracuja e: R$ " + sucoMaracuja.getPreco());

				Bebidas sucoMaracujaAtualizado = new Bebidas("", "",' ' ,0.0);
				sucoMaracujaAtualizado.setTipo("Suco");
				sucoMaracujaAtualizado.setSabor("Maracuja");
				sucoMaracujaAtualizado.setTamanho('G');
				sucoMaracujaAtualizado.setPreco(7.99);
				
				admArray.atualizarBebidas(sucoMaracujaAtualizado);
				
				System.out.println("Novo Preco do Suco de Maracuja: " + sucoMaracujaAtualizado.getPreco() + "\n");
				
				System.out.println("--------------ACABOU O TESTE DAS BEBIDAS--------------\n");
				
				
				System.out.println("--------------COMECANDO O TESTE DO CAFE DA MANHA--------------\nRepositorio em Lista:");		
				CafeManha Torrada = new CafeManha();
				Torrada.setNome("Torrada");
				Torrada.setValor(0.49);
				
				CafeManha Pao = new CafeManha();
				Pao.setNome("Pao");
				Pao.setValor(1.20);
					
				CafeManha Mamao = new CafeManha();
				Mamao.setNome("Mamao");
				Mamao.setValor(3.49);
					
				CafeManha Melao = new CafeManha();
				Melao.setNome("Melao");
				Melao.setValor(4.99);
					admLista.adicionarCafeManha(Torrada);
				admLista.adicionarCafeManha(Pao);
				admLista.adicionarCafeManha(Mamao);
				admLista.adicionarCafeManha(Melao);
				if (admLista.checarCafeManha(Torrada.getNome()) && admLista.checarCafeManha(Pao.getNome())
						&& admLista.checarCafeManha(Mamao.getNome())
						&& admLista.checarCafeManha(Melao.getNome())) {
					System.out.println(Torrada.getNome() + " adicionada com sucesso!");
					System.out.println(Pao.getNome() + " adicionada com sucesso!");
					System.out.println(Mamao.getNome() + " adicionada com sucesso!");
					System.out.println(Melao.getNome() + " adicionada com sucesso!\n");
				}
				
					System.out.println("Tem bebida");
					admLista.removerCafeManha("Torrada");
				if (!admLista.checarCafeManha("Torrada"))
					System.out.println("A Torrada foi removida com sucesso!\n");
				else
					System.out.println("A Torrada ainda esta no repositorio.\n");
					System.out.println("O preco do Pao e: R$ " + admLista.encontrarCafeManha("Pao").getValor() + "\n");
					
				admLista.atualizarValor("Mamao", 2.49);
				admLista.atualizarNome("Mamao", "Mamao em promocao");
				System.out.println("Novo nome do Mamao: " + Mamao.getNome() + "\nNovo preco do Mamao " + Mamao.getValor());
					
				CafeManha Mamao2 = new CafeManha();
				Mamao2.setNome("Mamao");
				Mamao2.setValor(3.49);
				admLista.atualizarCafeManha(Mamao.getNome(), Mamao2);
				
				System.out.println("O nome do Mamao voltou a ser: " + Mamao.getNome() + ". E o preco: " + Mamao.getValor());
				System.out.println("\nRepositorio em Array:");
				
				CafeManha Bolo = new CafeManha();
				Bolo.setNome("Bolo de chocolate");
				Bolo.setValor(1.99);
				admArray.adicionarCafeManha(Bolo);
					
				CafeManha Omelete = new CafeManha();
				Omelete.setNome("Omelete verde");
				Omelete.setValor(0.99);
				admArray.adicionarCafeManha(Omelete);
					
				CafeManha Brownie = new CafeManha();
				Brownie.setNome("Brownie de frigideira");
				Brownie.setValor(0.51);
				admArray.adicionarCafeManha(Brownie);
						
				if (admArray.checarCafeManha(Bolo.getNome()) && admArray.checarCafeManha(Omelete.getNome())
						&& admArray.checarCafeManha(Brownie.getNome())) {
					System.out.println("Refeicao " + Bolo.getNome() + " adicionada com sucesso!");
					System.out.println("Refeicao " + Omelete.getNome() + " adicionada com sucesso!");
					System.out.println("Refeicao " + Brownie.getNome() + " adicionada com sucesso!\n");
				}
					admArray.removerCafeManha(Bolo.getNome());
				if (!admArray.checarCafeManha("Brownie de frigideira"))
					System.out.println("Brownie de frigideira foi removido com sucesso!\n");
				else
					System.out.println("Brownie de frigideira ainda esta no repositorio.\n");
					System.out.println("O preco de um bolo e: $" + Bolo.getValor());


					System.out.println("--------------ACABOU O TESTE DO CAFE DA MANHA--------------\n");
	}
}

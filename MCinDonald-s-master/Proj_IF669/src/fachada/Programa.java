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
	}
}

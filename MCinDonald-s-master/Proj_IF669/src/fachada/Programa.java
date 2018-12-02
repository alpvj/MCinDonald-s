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

	}
}

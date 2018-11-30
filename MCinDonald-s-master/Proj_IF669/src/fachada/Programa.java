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
		
		RepositorioHamburguersLista rep1 = new RepositorioHamburguersLista();
		RepositorioBebidasLista rep2 = new RepositorioBebidasLista();

		NegociosHamburguers neg1 = new NegociosHamburguers(rep1);
		NegociosBebidas neg2 = new NegociosBebidas(rep2);

		Hamburguer objeto1 = new Hamburguer(null, 0);
		objeto1.setNome("McChest");
		objeto1.setPreco(10);

		Bebidas objeto2 = new Bebidas(null, null, '0', 0);
		objeto2.setSabor("Coca-Cola");
		objeto2.setTipo("Refri");
		objeto2.setPreco(7);
		objeto2.setTamanho('M');

		neg1.inserir(objeto1);
		neg2.inserir(objeto2);
		
		if(neg1.checarHamburguer("McChest")) {
			System.out.println("Tem hambur");
		}
		
		if(neg2.existe(objeto2)) {
			System.out.println("Tem bebida");
		}
	}
}

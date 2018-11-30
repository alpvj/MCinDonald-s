package alpvj;

public class mainTeste {

	public static void main(String[] args) throws SobremesaInexistenteException, SobremesaJaExisteException {
		RepositorioListaSobremesas rep = new RepositorioListaSobremesas();
		NegociosSobremesas neg = new NegociosSobremesas(rep);
		
		Sobremesas teste = new Sobremesas();
		teste.setNome("Sunday");
		teste.setPreco(10);
		
		neg.adicionarSobremesa(teste);
		System.out.println(neg.verificarSobremesa("Sunday"));
		
		//neg.adicionarSobremesa(teste);
		
		//neg.removerSobremesa("Sunday");
		neg.removerSobremesa(neg.procurarSobremesa("Sunday").getNome());
		System.out.println(neg.verificarSobremesa("Sunday"));
		
		//neg.removerSobremesa("Sunday");
		
		
	}
}
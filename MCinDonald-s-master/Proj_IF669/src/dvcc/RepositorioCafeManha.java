package dvcc;

public interface RepositorioCafeManha {
	
public CafeManha procurarCafeManha(String nome_CafeManha) throws CafeDaManhaInexistenteException;

public boolean verificarCafeManha(String nome_CafeManha);

public void adicionarCafeManha(CafeManha cafemanha) throws CafeDaManhaJaExisteException;

public void removerCafeManha(String nome_CafeManha) throws CafeDaManhaInexistenteException;

public void atualizarNome(String nome_Antigo, String nome_Novo) throws CafeDaManhaInexistenteException, CafeDaManhaJaExisteException;

public void atualizarPreco(String nome, double preco) throws CafeDaManhaInexistenteException;

public void atualizarCafeManha(String nome, CafeManha cafemanha) throws CafeDaManhaInexistenteException,  CafeDaManhaJaExisteException;
}

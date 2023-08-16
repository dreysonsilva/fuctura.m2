package br.com.fuctura.m2.dao;
import java.util.List;
import br.com.fuctura.m2.model.Conta;

public interface ContaDAO {
	
	public void salvar(Conta conta);
	
	public void alterar(Conta conta);
	
	public void remover(int numero);
	
	public Conta pesquisarPorNumero(int numero);
	
	public List<Conta> listarTodos();

}

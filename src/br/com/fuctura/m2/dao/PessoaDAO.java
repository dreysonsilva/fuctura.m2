package br.com.fuctura.m2.dao;

import java.util.List;

import br.com.fuctura.m2.model.Pessoa;

public interface PessoaDAO {
	
	public void salvar(Pessoa pessoa);
	
	public void alterar(Pessoa pessoa);
	
	public void remover(String cpf);
	
	public Pessoa pesquisarPessoaPorId(String cpf);
	
	public List<Pessoa> listarTodosPessoa();
}

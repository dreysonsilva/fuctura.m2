package br.com.fuctura.m2.dao;

import java.util.List;

import br.com.fuctura.m2.model.Endereco;

public interface EnderecoDAO {
	
	public Integer salvar(Endereco endereco);
	
	public void alterar(Endereco endereco);
	
	public void remover(int id);
	
	public Endereco pesquisarEnderecoPorId(Integer id);
	
	public List<Endereco> listarTodosEndereco();
	
}

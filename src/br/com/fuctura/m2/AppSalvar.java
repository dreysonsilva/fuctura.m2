package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppSalvar {
	public static void main(String[] args) { 		 
		Conta conta = new Conta();
		ContaDAO contaDAO = new ContaDAOImpl();
		
		conta.setNumero(1004);
		conta.setSaldo(100.0);
		conta.setLimite(400.0);
		contaDAO.salvar(conta);
		
		/* 
		Endereco endereco = new Endereco();		
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
		
		endereco.setId(endereco.getId());
		endereco.setRua("Rua Toni Carrado");
		endereco.setNumero("3458");
		endereco.setComplemento("Próxmo a CHEST");
		enderecoDAO.salvar(endereco);
		**/
		
	}

}

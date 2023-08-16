package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppSalvar {
	public static void main(String[] args) {
		Conta conta2 = new Conta();
		ContaDAO contaDao = new ContaDAOImpl();
		conta2.setNumero(1004);
		conta2.setSaldo(100.0);
		conta2.setLimite(400.0);
		contaDao.salvar(conta2);
	}

}

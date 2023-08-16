package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppAlterar {

	public static void main(String[] args) {
		ContaDAO contaDao = new ContaDAOImpl();
		Conta contaAlterar = new Conta();
		contaAlterar.setSaldo(1000);
		contaAlterar.setLimite(15222);
		contaDao.alterar(contaAlterar);
	}

}

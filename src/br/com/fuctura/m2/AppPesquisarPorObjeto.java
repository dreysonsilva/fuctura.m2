package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppPesquisarPorObjeto {

	public static void main(String[] args) {
		ContaDAO contaDao = new ContaDAOImpl();
		Conta conta = contaDao.pesquisarPorNumero(1003);
		
		System.out.println(conta.toString());
	}

}

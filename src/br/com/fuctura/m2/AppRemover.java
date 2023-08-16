package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;

public class AppRemover {

	public static void main(String[] args) {
		ContaDAO contaDao = new ContaDAOImpl();
		contaDao.remover(1003);

	}

}

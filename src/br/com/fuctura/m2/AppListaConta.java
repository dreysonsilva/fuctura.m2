package br.com.fuctura.m2;

import java.util.List;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppListaConta {

	public static void main(String[] args) {
		ContaDAO contaDao = new ContaDAOImpl();

		List<Conta> listaContas = contaDao.listarTodos();
		
		System.out.println("-----------------------------------------");
		for (Conta contas : listaContas) {
			System.out.println(contas.toString());
		}
		System.out.println("\n-----------------------------------------");
		//MAIS DUAS FORMAS DE LISTAR
		for (Conta contas : listaContas) {
			System.out.println(contas.toString());
		}
	}
}
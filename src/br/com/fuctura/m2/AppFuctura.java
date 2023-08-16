package br.com.fuctura.m2;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.impl.ContaDAOImpl;
import br.com.fuctura.m2.model.Conta;

public class AppFuctura {
	public static void main(String[] args) {
		
//		Conta conta2 = new Conta();
		ContaDAO contaDao = new ContaDAOImpl();
		
//		//INSERINDO DADOS NA TABELA
//		conta2.setNumero(1004);
//		conta2.setSaldo(100.0);
//		conta2.setLimite(400.0);
//		contaDao.salvar(conta2);
		
		//ALTERAR VALOR
		Conta contaAlterar = new Conta();
		contaAlterar.setSaldo(200);
		contaAlterar.setSaldo(300);
		contaDao.alterar(contaAlterar);
		
//		//REMOVER
//		contaDao.remover(1003);
//		
//		//PESQUISAR 1 OBJETO
//		conta1 =contaDao.pesquisar(1003);
//		
//		//PESQUISAR LISTA DE CONTAS
//		List<Conta> listaContas = contaDao.listarTodos();
//		
//		for(Conta contas:listaContas) {
//			System.out.println(contas.toString());
//		}
//		
//		for(int i=0;i<listaContas.size();i++) {
//			System.out.println(listaContas);
//		}
//		//FORMA 2
//		listaContas.forEach(System.out::println);
//		//FORMA3
//		listaContas.forEach(variavel-> System.out.println(variavel));

	}

}
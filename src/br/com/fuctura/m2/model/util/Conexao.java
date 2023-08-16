package br.com.fuctura.m2.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String url = "jdbc:mysql://localhost:3306/fucturatwo?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "#root";
	
	Connection conn = null;
	
	//METODO ABRIR CONEXAO
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null) {
				System.out.println("Conectado!");
			}
		}catch(Exception e) {
			System.out.println("Erro:\n "+e.getMessage());
		}
		return conn;

	}
	
	//FECHAR CONEXAO
	public void fecharConexao(Connection conn) {
		try {
			if(conn !=null) {
				conn.close();
			}
		}catch(Exception e) {
			System.out.println("Erro ao fechar conexao. "+e.getMessage());
		}
	}
	
}
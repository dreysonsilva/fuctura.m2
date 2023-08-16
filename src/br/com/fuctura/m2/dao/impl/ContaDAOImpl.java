package br.com.fuctura.m2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.model.Conta;
import br.com.fuctura.m2.model.util.Conexao;

public class ContaDAOImpl implements ContaDAO {
	Conexao conexao = new Conexao();
	@Override
	public void salvar(Conta conta) {
		Connection conn = conexao.getConnection();
		String sql = "INSERT INTO CONTA(NUMERO, SALDO, LIMITE)" + "VALUES(?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conta.getNumero());
			ps.setDouble(2, conta.getSaldo());
			ps.setDouble(3, conta.getLimite());
			ps.execute();
			System.out.println("Conta inserida com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro SQL: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public void alterar(Conta conta) {
		Conexao conexao = new Conexao();
		Connection conn = conexao.getConnection();
		String sql = "UPDATE CONTA SET SALDO=?, LIMITE=? WHERE NUMERO=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, conta.getNumero());
			ps.setDouble(2, conta.getSaldo());
			ps.setDouble(3, conta.getLimite());
			ps.execute();
			System.out.println("Conta atualizada com sucesso");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public void remover(int numero) {
		Connection conn = conexao.getConnection();

		String sql = "DELETE FROM CONTA WHERE NUMERO=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ps.execute();
			System.out.println("Conta removida com sucesso");
		} catch (SQLException e) {
			System.out.println("ERRO SQLExc " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERRO Exception: " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	@Override
	public Conta pesquisarPorNumero(int numero) {
		Connection conn = conexao.getConnection();
		
		Conta conta = new Conta();

		String sql = "SELECT * FROM CONTA WHERE NUMERO=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numero);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				conta.setNumero(rs.getInt("NUMERO"));
				conta.setSaldo(rs.getDouble("SALDO"));
				conta.setLimite(rs.getDouble("LIMITE"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao pesquisar Conta" + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
		return conta;
	}

	@Override
	public List<Conta> listarTodos() {
		Connection conn = conexao.getConnection();
			
		List<Conta> retorno = new ArrayList<Conta>();
		
		String sql = "SELECT * FROM CONTA";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Conta conta = new Conta();
				conta.setNumero(rs.getInt("NUMERO"));
				conta.setSaldo(rs.getDouble("SALDO"));
				conta.setLimite(rs.getDouble("LIMITE"));
				retorno.add(conta);

			}
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
		return retorno;
	}

}

package br.com.fuctura.m2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fuctura.m2.dao.EnderecoDAO;
import br.com.fuctura.m2.model.Endereco;
import br.com.fuctura.m2.model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {
	Conexao conexao = new Conexao();
	Endereco endereco = new Endereco();
	@Override
	public void salvar(Endereco endereco) {

		Connection conn = conexao.getConnection();
		String sql = "INSERT INTO ENDERECO(RUA, NUMERO, COMPLEMENTO) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			conexao.fecharConexao(conn);
		}
		
	}

	@Override
	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco pesquisarEnderecoPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarTodosEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

}

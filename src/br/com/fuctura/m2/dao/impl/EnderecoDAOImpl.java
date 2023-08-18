package br.com.fuctura.m2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.fuctura.m2.dao.EnderecoDAO;
import br.com.fuctura.m2.model.Endereco;
import br.com.fuctura.m2.model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {
	Conexao conexao = new Conexao();
	Endereco endereco = new Endereco();
	
	@Override
	public Integer salvar(Endereco endereco) {
		Connection conn = conexao.getConnection();
		Integer id = null;
		
		String sql = "INSERT INTO ENDERECO(RUA, NUMERO, COMPLEMENTO) "
				+ "VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getComplemento());
			ps.executeUpdate();
			
			System.out.println("Endereco cadastrado com sucesso!");
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(4);
				System.out.println("Inserted ID="+id);//Disply insertd record
			}
		}catch(SQLException e) {
			System.err.println("Erro: "+e.getMessage());			
		}finally {
			conexao.fecharConexao(conn);
		}
		return id;
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
	public Endereco pesquisarEnderecoPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarTodosEndereco() {
		// TODO Auto-generated method stub
		return null;
	}

}

package br.com.fuctura.m2.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.m2.dao.EnderecoDAO;
import br.com.fuctura.m2.model.Endereco;
import br.com.fuctura.m2.model.util.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {
	Conexao conexao = new Conexao();
	Connection conn = conexao.getConnection();
	Endereco endereco = new Endereco();
	
	/**-------------------------------------------------------------------------------------------------------------
	 * SALVAR ENDERECO 
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	@Override
	public Integer salvar(Endereco endereco) {		
		
		Integer id = null;
		
		String sql = "INSERT INTO ENDERECO(RUA, NUMERO, COMPLEMENTO) "
				+ "VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//Statement.RETURN_GENERATED_KEYS Utilizado pois o banco esta gerando automatico a chave
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
			System.err.println("Erro ao inserir endereco no banco. "+e.getMessage());			
		}finally {
			conexao.fecharConexao(conn);
		}
		return id;
	}

	/**-------------------------------------------------------------------------------------------------------------
	 * ALTERAR ENDERECO
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	
	@Override
	public void alterar(Endereco endereco) {	
		
		String sql = "UPDATE ENDERECO SET RUA = ?, NUMERO=?, COMPLEMENTO=? WHERE ID_ENDERECO=?";
		
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3,endereco.getComplemento());
			ps.setInt(4, endereco.getId());
			ps.executeUpdate();
			System.out.println("Endereco atualizado com sucesso.");
		}catch(Exception e) {
			System.out.println("Erro ao atualizar endereco no banco. "+e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
	}

	/**-------------------------------------------------------------------------------------------------------------
	 * REMOVER ENDERECO
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	@Override
	public void remover(int id) {	
		
		String sql = "DELETE FROM ENDERECO WHERE ID=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Endereco deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao deletar endereco no banco. "+ e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro Exception. "+ e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	/**-------------------------------------------------------------------------------------------------------------
	 * PESQUISAR_ENDERECO_POR_ID ENDERECO
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	@Override
	public Endereco pesquisarEnderecoPorId(Integer id) {
		
		String sql = "SELECT * FROM ENDERECO WHERE ID_ENDERECO=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				endereco.setId(rs.getInt("ID_ENDERECO"));
				endereco.setRua(rs.getString("RUA"));
				endereco.setNumero(rs.getString("NUMERO"));	
				endereco.setComplemento(rs.getString("COMPLEMENTO"));
			}
		}catch(Exception e) {
			System.out.println("Erro ao pesquisar Endereco "+e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}	
		
		return endereco;
	}
	
	/**-------------------------------------------------------------------------------------------------------------
	 * LISTA_TODOS ENDERECO
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	@Override
	public List<Endereco> listarTodosEndereco() {
		List<Endereco> retorno = new ArrayList<Endereco>();
		
		String sql ="SELECT * FROM ENDERECO";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("ID_ENDERECO"));
				endereco.setRua(rs.getString("RUA"));
				endereco.setComplemento(rs.getString("COMPLEMENTO"));
				endereco.setNumero(rs.getString("NUMERO"));
				retorno.add(endereco);
				ps.executeUpdate();				
			}			
		}catch(Exception e) {
			System.out.println("Erro ao listar Endereco no banco. "+e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
		
		return retorno;
	}
}
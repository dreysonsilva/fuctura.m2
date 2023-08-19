package br.com.fuctura.m2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.fuctura.m2.dao.ContaDAO;
import br.com.fuctura.m2.dao.EnderecoDAO;
import br.com.fuctura.m2.dao.PessoaDAO;
import br.com.fuctura.m2.model.Pessoa;
import br.com.fuctura.m2.model.util.Conexao;

public class PessoaDAOImpl implements PessoaDAO {
	
	Conexao conexao = new Conexao();
	
	Connection conn = conexao.getConnection();
	
	Pessoa pessoa = new Pessoa();
	
	EnderecoDAO enderecoDAO = new EnderecoDAOImpl();
	
	ContaDAO contaDAO = new ContaDAOImpl();

	/**
	 * -------------------------------------------------------------------------------------------------------------
	 * SALVAR PESSOA
	 * 
	 * @author DREYSON SANTIAGO
	 *         -------------------------------------------------------------------------------------------------------------*
	 */

	@Override
	public void salvar(Pessoa pessoa) {

		String sql = "INSERT INT PESSOA(NOME,CPF,SEXO, IDADE, ID_ENDERECO,NUMERO_CONTA) VALUES (?,?,?,?,?,?)";

		try {
			Integer id = this.enderecoDAO.salvar(pessoa.getEndereco());
			this.contaDAO.salvar(pessoa.getConta());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getSexo());
			ps.setInt(4, pessoa.getIdade());
			ps.setInt(5, id);
			ps.setInt(6, pessoa.getConta().getNumero());
			ps.execute();
			System.out.println("inserido com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao inserir no banco" + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	/**
	 * -------------------------------------------------------------------------------------------------------------
	 * ALTERA PESSOA
	 * 
	 * @author DREYSON SANTIAGO
	 *         -------------------------------------------------------------------------------------------------------------*
	 */
	@Override
	public void alterar(Pessoa pessoa) {

		String sql = "UPDATE PESSOA SET NOME=?, CPF=?, IDADE=?, SEXO=?, ID_ENDERECO=?, NUMERO_CONTA=? WHERE CPF=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setInt(3, pessoa.getIdade());
			ps.setString(4, pessoa.getSexo());
			ps.setInt(5, pessoa.getEndereco().getId()); 
			ps.setInt(6, pessoa.getConta().getNumero());
			System.out.println("Pessoa atualizada com sucesso. ");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar pessoa no banco. " +e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	/**
	 * -------------------------------------------------------------------------------------------------------------
	 * REMOVER PESSOA
	 * 
	 * @author DREYSON SANTIAGO
	 *         -------------------------------------------------------------------------------------------------------------*
	 */

	@Override
	public void remover(String cpf) {
		Pessoa p = pesquisarPessoaPorId(cpf);
		String sql = "DELET FROM PESSOA WHERE CPF = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			contaDAO.remover(p.getConta().getNumero());
			enderecoDAO.remover(p.getEndereco().getId());
			System.out.println("Pessoa deletada com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao remover pessoa " + e.getMessage());
		} finally {
			conexao.fecharConexao(conn);
		}
	}

	/**-------------------------------------------------------------------------------------------------------------
	 * PESQUISAR_PESSOA_POR_ID PESSOA
	 * @author DREYSON SANTIAGO
	 -------------------------------------------------------------------------------------------------------------* */
	@Override
	public Pessoa pesquisarPessoaPorId(String cpf) {
		
		String sql = "SELECT * FROM PESSOA WHERE CPF=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pessoa.setNome(rs.getString("NOME"));
				pessoa.setCpf(rs.getString("CPF"));
				pessoa.setSexo(rs.getString("SEXO"));
				pessoa.setIdade(rs.getInt(0));
			}
		}catch(Exception e) {
			System.out.println("Erro ao pesquisar pessoa "+e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
		}
	return pessoa;
	}

	/**
	 * -------------------------------------------------------------------------------------------------------------
	 * LISTA_TODOS PESSOA
	 * 
	 * @author DREYSON SANTIAGO
	 *         -------------------------------------------------------------------------------------------------------------*
	 */
	@Override
	public List<Pessoa> listarTodosPessoa() {
		// TODO Auto-generated method stub
		return null;
	}

}

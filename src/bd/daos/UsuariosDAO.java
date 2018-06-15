package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbo.*;


/**
 * A classe permite que sejam criados os m�todos que rodas comandos SQL. 
 */

public class UsuariosDAO {
	
	/**
	 * Returna boolean.
	 * O m�todo verifica se o usu�rio j� possui cadastrado no banco de dados
	 */
	public boolean cadastrado(String email, String senha) throws Exception {
		boolean retorno = false;
		try {
			String sql;
			sql = "SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";

			BD.COMANDO.prepareStatement(sql);
			BD.COMANDO.setString(1, email);
			BD.COMANDO.setString(2, senha);

			MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();
			retorno = resultado.first();

		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar usuario");
		}

		return retorno;
	}

	/**	 
	 * O m�todo permite que um novo usu�rio seja inserido no banco de dados.
	 */

	public void inserir(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("Usuario nao fornecido");

		try {
			String sql;

			sql = "INSERT INTO USUARIO(EMAIL, NOME, SENHA) VALUES (?, ?, ?);";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, usuario.getEmail());
			BD.COMANDO.setString(2, usuario.getNome());
			BD.COMANDO.setString(3, usuario.getSenha());

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao inserir usuario");
		}
	}
	
	
	/**	 
	 * O m�todo permite que um usu�rio seja excluido no banco de dados.
	 */

	public void excluir(String email, String senha) throws Exception {
		if (!cadastrado(email, senha))
			throw new Exception("Nao cadastrado");

		try {
			String sql;

			sql = "DELETE FROM USUARIO WHERE EMAIL=?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao excluir usuario");
		}
	}
	
	/**	 
	 * O m�todo permite que os dados do usu�rio sejam alterados e salvos no banco de dados.
	 */
	public void alterar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("Usuario nao fornecido");

		if (!cadastrado(usuario.getEmail(), usuario.getSenha()))
			throw new Exception("Nao cadastrado");

		try {
			String sql;

			sql = "UPDATE USUARIO " + "SET NOME=? " + "SET SENHA=? " + "WHERE EMAIL= ?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, usuario.getNome());
			BD.COMANDO.setString(2, usuario.getSenha());
			BD.COMANDO.setString(3, usuario.getEmail());

			BD.COMANDO.executeUpdate();
			BD.COMANDO.commit();
		} catch (SQLException erro) {
			throw new Exception("Erro ao atualizar dados de usuario");
		}
	}

	/**
	 * Retorna um usu�rio.	 
	 * O m�todo permite que os dados do usu�rio sejam puxados do banco de dados atrav�s do email.
	 */

	public Usuario getUsuario(String email) throws Exception {
		Usuario usuario = null;

		try {
			String sql;

			sql = "SELECT * " + "FROM USUARIO " + "WHERE EMAIL = ?";

			BD.COMANDO.prepareStatement(sql);

			BD.COMANDO.setString(1, email);

			MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();

			if (!resultado.first())
				throw new Exception("Nao cadastrado");

			usuario = new Usuario(resultado.getString("EMAIL"), resultado.getString("NOME"),
					resultado.getString("SENHA"));
		} catch (SQLException erro) {
			throw new Exception("Erro ao procurar usuario");
		}

		return usuario;
	}

	/**
	 * Retorna todos os usu�rios cadastrados.	 
	 * O m�todo permite que os todos os dados de todos os usu�rios sejam puxados do banco de dados.
	 */

	public MeuResultSet getUsuarios() throws Exception {
		MeuResultSet resultado = null;

		try {
			String sql;

			sql = "SELECT * " + "FROM USUARIO";

			BD.COMANDO.prepareStatement(sql);

			resultado = (MeuResultSet) BD.COMANDO.executeQuery();
		} catch (SQLException erro) {
			throw new Exception("Erro ao recuperar usuarios");
		}

		return resultado;
	}
}

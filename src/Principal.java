import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

import bd.*;
import bd.dbo.*;
import bd.daos.*;
import interfaceGrafica.*;

public class Principal {
    
    private static UsuariosDAO usuarios;
    
    public static void main(String[] args) throws Exception
    {
        //Teste();
        
        BD bd = new BD();
        usuarios = bd.Usuarios;        
        new Cliente(usuarios).setVisible(true);

	}
    	
	private static Connection ConectarBD() {
		
		final String address = "127.0.0.1:3306";
		final String database = "login";
		final String jdbcConnectionLink = "jdbc:mysql://" + address + "/" + database;
		
		final String username = "root";
		final String password = "Jo$i220792";
		
		
		try {
			Connection connection = (Connection) DriverManager.getConnection(jdbcConnectionLink, username, password);
			return connection;
		} catch (SQLException e) {
			throw new IllegalStateException("Falha ao se conectar ao banco de dados.", e);
		}
	}

	private static void InserirDadosBD() {
		
		Connection SQL = ConectarBD();
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO usuario(email, nome, senha) VALUES (?, ?, ?);");
		
		PreparedStatement preparedQuery;
		
		try {
			preparedQuery = SQL.prepareStatement(query.toString());
			preparedQuery.setString(1, "emailTeste3");
			preparedQuery.setString(2, "emailTeste3");
			preparedQuery.setString(3, "emailTeste3");
			preparedQuery.executeUpdate();
			System.out.println("Sucesso ao executar a consulta, foram alteradas [" + preparedQuery.getUpdateCount() + "] linhas.");
		} catch (SQLException e) {
			throw new IllegalStateException("Falha ao preparar a consulta.", e);
		}
		
	}

	private static void Teste() throws Exception
	{
		String email = "testeEmail5";
		String nome = "testeNome5";
		String senha = "testeSenha5";
		
		Usuario usuario = new Usuario(email, nome, senha);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		BD bd = new BD();
		
		bd.Usuarios.inserir(usuario);
		System.out.println("gravado");
		
		
	}

}

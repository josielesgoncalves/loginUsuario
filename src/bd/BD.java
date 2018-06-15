package bd;

import bd.core.*;
import bd.daos.*;

/**
 * A classe cria a conexão com o bando de dados.    
 */
public class BD {
	public static final MeuPreparedStatement COMANDO;
	public static final UsuariosDAO Usuarios;

	static {
		UsuariosDAO usuarios = null;
		MeuPreparedStatement comando = null;

		try {
			comando = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
					"jdbc:sqlserver://fs5:1433;databasename=poo201849", "poo201849", "Opkvs8");
			
			usuarios = new UsuariosDAO();
		} catch (Exception erro) {
			System.err.println("Problemas de conexao com o BD");
			System.exit(0);
		}
		COMANDO = comando;
		Usuarios = usuarios;
	}

}

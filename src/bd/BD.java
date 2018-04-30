package bd;

import bd.core.*;
import bd.daos.*;

public class BD 
{
    public static final MeuPreparedStatement COMANDO;
    public static final UsuariosDAO Usuarios;

    static
    {
        UsuariosDAO usuarios  = null; 
        MeuPreparedStatement comando = null;
	    
        try
	{
            /*String driverName = "com.mysql.jdbc.Driver";
	    String username = "root";        
	    String password = "Jo$i220792";
	    		
	    comando = new MeuPreparedStatement (driverName, 
                      "jdbc:mysql://127.0.0.1:3306/login", username, password);*/
            
            comando = new MeuPreparedStatement (	            
	        "com.microsoft.sqlserver.jdbc.SQLServerDriver",
	        "jdbc:sqlserver://FS5:1433;databasename=poo201849",
	        "poo201849", "Opkvs8");

	    usuarios = new UsuariosDAO ();
	}
	catch (Exception erro)
	{
	    System.err.println ("Problemas de conexao com o BD");
	    System.exit(0);
	}
	        
	COMANDO = comando;
	Usuarios  = usuarios;
	}
	
}

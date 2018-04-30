/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Josiele
 */
public class Servidor 
{
    //Projeto C: uso de sockets em autenticação de login: validar login
    //receber senha e procurar no banco, o outro socket deve responder se encontrou o login no banco
    //Uso de thread para fazer diversas verificações ao mesmo tempo
    //Pedir conexao, criar thread
    //Thread cuida dos sockets
    //Cliente e Servidor -> ambos deverão ter transmissor e receptor

    
    //Protocolo de requisição Cliente-Servidor para cadastro de usuario deve exibir CAD na mensagem
    //Protocolo de requisição Cliente-Servidor para login de usuario deve exibir LOG na mensagem
    
    //TODO: implementar socket de Servidor
    //Porta do servidor: 1433
    public Servidor()
    {
    }
    
    public void Transmissor(String porta)
    {
    }
    
    public void Receptor(String porta)
    {
        try 
        {
            ServerSocket pedido = new ServerSocket(11111);			
            Socket conexao = pedido.accept();			
			
            ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());
            String mensagem = null;
			
            do 
            {
                mensagem = (String)receptor.readObject();
		System.out.println(mensagem);
				
            } while (!mensagem.toUpperCase().equals("FIM"));
			
            receptor.close();
            conexao.close();
            pedido.close();
			
			
			
	} catch (Exception e)
        {
            System.err.println(e.getMessage());
	}
    }
    
}

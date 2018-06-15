/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Josiele
 */
public class Cliente {
	private String host;
	private int port;
	private Solicitacao solicitacao;
	private Solicitacao resposta;

	public Cliente(String _host, int _port, Solicitacao _solicitacao) {
		host = _host;
		port = _port;
		solicitacao = _solicitacao;
	}
	
	/**
	 * O método permite que o cliente envie um pedido de conexão para o servidor através da criação do socket cliente. 
	 * Ao receber a resposta do servidor, ela é enviada para a view e informar o usuário.    
	 */

	public void conectar() // transmissor
	{
		try {
			Socket cliente = new Socket(host, port);
			// cliente conectado

			ObjectOutputStream transmissor = new ObjectOutputStream(cliente.getOutputStream());
			
			transmissor.writeObject(solicitacao);
			transmissor.flush();
			
	
			ObjectInputStream server = new ObjectInputStream(cliente.getInputStream());
			resposta = (Solicitacao) server.readObject();		
			
			System.out.println(resposta);

			
			
			transmissor.close();
			cliente.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	/**
	 * O método retorna o tipo de resposta que o seridor enviou ao cliente.     
	 */
	public Solicitacao getResposta()
	{
		return this.resposta;
	}

}
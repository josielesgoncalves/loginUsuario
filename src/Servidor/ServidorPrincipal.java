/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Josiele
 */
public class ServidorPrincipal {

	private static int porta = 5000;

	/**
	 * O método permite que o servidor rode a thread que recebe pedidos de conexão com o servidor.
	 *     
	 */
	public static void main(String[] args) {
		try {
			AssassinoDeServidor assassino = new AssassinoDeServidor();

			assassino.start();

			ServerSocket pedido = new ServerSocket(porta);

			for (;;) {

				Socket conexao = pedido.accept();

				TratamentoConexao tratadora = new TratamentoConexao(conexao);
				tratadora.start();

			}
		} catch (Exception erro) {
			System.err.println("Problemas em subir o servidor");
		}
	}

}

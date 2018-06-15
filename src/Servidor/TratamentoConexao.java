package Servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import javax.swing.JOptionPane;

import Cliente.Solicitacao;
import bd.BD;
import bd.dbo.Usuario;

public class TratamentoConexao extends Thread {

	private Socket conexao;
	
	/**
	 * O construtor recebe o socket de conexão do cliente.  
	 */
	public TratamentoConexao(Socket cnx) throws Exception {
		if (cnx == null)
			throw new Exception("Conexao ausente");

		this.conexao = cnx;
	}

	/**
	 * O método permite que o servidor receba o tipo de solicitação que está sendo pedida pelo Cliente.
	 * Os tipos de solicitação variam entre: LOG e CAD(Login ou Cadastro).
	 * Uma resposta sempre é enviada pelo servidor para o cliente, sendo essa resposta SUC ou ERR (Sucesso,ou Erro).    
	 */
	public void run() {
		try {
			ObjectOutputStream _obj = new ObjectOutputStream(conexao.getOutputStream());
			ObjectInputStream obj = new ObjectInputStream(this.conexao.getInputStream());
			
			

			Solicitacao solicitacao = (Solicitacao) obj.readObject();
			String ipCliente = this.conexao.getInetAddress().getHostAddress();
			
			Solicitacao resposta;
			
			System.out.println("Solicitacao " + solicitacao.getComando() + " de " + ipCliente);
			

			if (solicitacao.getComando().equals("LOG")) {
				if (BD.Usuarios.cadastrado(solicitacao.getEmail(), solicitacao.getSenha()))
					resposta = new Solicitacao("SUC", "Usuario logado com sucesso");
				else
					resposta = new Solicitacao("ERR", "Usuario nao cadastrado");

			}

			else if (solicitacao.getComando().equals("CAD")) {
				if (BD.Usuarios.cadastrado(solicitacao.getEmail(), solicitacao.getSenha()))
					resposta = new Solicitacao("ERR", "Usuario ja cadastrado");
				else {
					Usuario usuario = new Usuario(solicitacao.getEmail(), solicitacao.getNome(),
							solicitacao.getSenha());
					BD.Usuarios.inserir(usuario);
					resposta = new Solicitacao("SUC", "Usuario cadastrado com sucesso!");
				}
			}

			else {
				resposta = new Solicitacao("ERR", "Solicitacao invalida");
			}
			
			System.out.println("Resposta da solicitacao enviada: " + resposta.getMessage());

			_obj.writeObject(resposta);
			_obj.flush();
			_obj.close();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

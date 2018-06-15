/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;
import java.util.Objects;

/**
 * A classe permite que sejam criados tipos de solicitação que serão enviados para o servidor.
 * Possui metodos getters e setters para cada variavel existente.
 * Implementa também os métodos hashCode, toString e equals.
 */
public class Solicitacao implements Serializable {

	private String comando;
	private String email;
	private String nome;
	private String senha;
	private String message;

	/**
	 * O construtor permite que o cliente faça a solicitação enviando o comando, email e senha para logar.
	 */

	public Solicitacao(String _comando, String _email, String _senha) {
		setComando(_comando);
		setEmail(_email);
		setSenha(_senha);
		
	}

	/**
	 * O construtor permite que o cliente faça a solicitação enviando o comando, email e senha para se cadastrar.
	 */
	public Solicitacao(String _comando, String _email, String _nome, String _senha) {
		setComando(_comando);
		setEmail(_email);
		setNome(_nome);
		setSenha(_senha);
	}

	/**
	 * O construtor permite que a resposta se erro ou sucesso seja enviada ao cliente, juntos com uma mensagem.
	 */
	public Solicitacao(String _comando, String _message) {
		setComando(_comando);
		setMessage(_message);
	}

	public String getComando() {
		return this.comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + Objects.hashCode(this.comando);
		hash = 83 * hash + Objects.hashCode(this.email);
		hash = 83 * hash + Objects.hashCode(this.nome);
		hash = 83 * hash + Objects.hashCode(this.senha);
		hash = 83 * hash + Objects.hashCode(this.message);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Solicitacao other = (Solicitacao) obj;
		if (!Objects.equals(this.comando, other.comando)) {
			return false;
		}
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		if (!Objects.equals(this.senha, other.senha)) {
			return false;
		}
		if (!Objects.equals(this.message, other.message)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Solicitacao{" + "comando=" + comando + ", email=" + email + ", nome=" + nome + ", senha=" + senha
				+ ", message=" + message + '}';
	}

}

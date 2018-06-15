package bd.dbo;


/**
 * A classe implementa os m�todos getters e setters para as vari�veis que ser�o usadas para conectar ou cadastrar um usu�rio. 
 */
public class Usuario {
	
	private String email;
	private String nome;
	private String senha;

	public Usuario(String email, String nome, String senha) throws Exception {
		this.setEmail(email);
		this.setNome(nome);
		this.setSenha(senha);
	}

	public void setEmail(String email) throws Exception {
		if (email == null || email.equals(""))
			throw new Exception("Email invalido");

		this.email = email;
	}

	public void setNome(String nome) throws Exception {
		if (nome == null || nome.equals(""))
			throw new Exception("Nome nao fornecido");

		this.nome = nome;
	}

	public void setSenha(String senha) throws Exception {
		if (senha == null || senha.equals(""))
			throw new Exception("Senha invalido");

		this.senha = senha;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSenha() {
		return this.senha;
	}
}

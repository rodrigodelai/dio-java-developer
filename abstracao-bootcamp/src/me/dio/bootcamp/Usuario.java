package me.dio.bootcamp;

import javax.naming.AuthenticationException;

public abstract class Usuario {

	private static long usuariosCadastrados = 0;
	private long id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {
		Usuario.usuariosCadastrados++;
		this.id = usuariosCadastrados;
	}

	public Usuario(String login, String senha, String nome) {
		Usuario.usuariosCadastrados++;
		this.id = usuariosCadastrados;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return this.nome + " (" + this.id + ")";
	}

	public static long getQntUsuarios() {
		return usuariosCadastrados;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String atual, String nova) throws AuthenticationException {
		if (atual == this.senha)
			this.senha = nova;
		else 
			throw new AuthenticationException("Senha inválida.");
	}

}

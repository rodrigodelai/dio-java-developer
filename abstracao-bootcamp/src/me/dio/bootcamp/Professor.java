package me.dio.bootcamp;

import java.util.Set;

public class Professor extends Usuario {

	private Set<Bootcamp> compoeEquipes;
	private Set<Conteudo> ministrados;
	
	public Professor() {}
	
	public Professor(String login, String senha, String nome) {
		super(login, senha, nome);
	}
	
}

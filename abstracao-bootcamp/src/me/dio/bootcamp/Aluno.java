package me.dio.bootcamp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Aluno extends Usuario {

	private Set<Bootcamp> bootcampsInscritos = new LinkedHashSet<Bootcamp>();
	private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<Bootcamp>();
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<Conteudo>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<Conteudo>();

	public Aluno() {}
	
	public Aluno(String login, String senha, String nome) {
		super(login, senha, nome);
	}
	
	public boolean addBootcamp(Bootcamp boot) {
		return bootcampsInscritos.add(boot);
	}
	
	public boolean addConteudos(Collection<Conteudo> cont) {
		return conteudosInscritos.addAll(cont);
	} 
	
	public void exibirConteudosInscritos() {
		System.out.println("Conteúdos inscritos de " + super.getNome() + ":");
		
		if (conteudosInscritos.isEmpty())
			System.out.println("- Não há conteúdos cadastrados.");
		else
			this.conteudosInscritos.stream().forEach(comp -> System.out.println("- " + comp + ";"));
		
		System.out.println();
	}
	
	public void exibirBootcampsInscritos() {
		System.out.println("Bootcamps inscritos de " + super.getNome() + ":");
		
		if (bootcampsInscritos.isEmpty())
			System.out.println("- Não há bootcamps cadastrados.");
		else
			this.bootcampsInscritos.stream().forEach(comp -> System.out.println("- " + comp + ";"));
		
		System.out.println();
	}
	
	public Set<Bootcamp> getBootcampsInscritos() {
		return bootcampsInscritos;
	}

	public Set<Bootcamp> getBootcampsConcluidos() {
		return bootcampsConcluidos;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setBootcampsInscritos(Set<Bootcamp> bootcampsInscritos) {
		this.bootcampsInscritos = bootcampsInscritos;
	}

}

package me.dio.bootcamp;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Conteudo {

	private String titulo;
	private String descricao;
	private int duracaoEmMin;
	private Set<Aluno> inscritos = new LinkedHashSet<>();

	public Conteudo() {}
	
	public Conteudo(String titulo, String descricao, int duracaoEmMin) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracaoEmMin = duracaoEmMin;
	}

	public boolean inscrever(Aluno aluno) {
		return inscritos.add(aluno);
	}
	
	public boolean desinscrever(Aluno aluno) {
		return inscritos.remove(aluno);
	}
	
	public void exibirInscritos() {
		String classe = this.getClass().getSimpleName().toString().toLowerCase();
		char genero = 'o';
		
		if (classe.charAt(classe.length() - 1) != 'o')
			genero = 'a';
			
		System.out.println("Alunos inscritos n" + genero + " " +
							classe +" \"" + this.titulo + "\":");
		
		if (inscritos.isEmpty())
			System.out.println("- Não há alunos cadastrados.");
		else
			this.inscritos.stream().forEach(aluno -> System.out.println("- " + aluno + ";"));
		
		System.out.println();
	}
	
	@Override
	public String toString() {
		return this.titulo + " (" + formatarDuracao() + ")";
	}
	
	private String formatarDuracao() {
		return String.format("%02dh%02d", this.duracaoEmMin / 60, this.duracaoEmMin % 60);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getDuracaoEmMin() {
		return duracaoEmMin;
	}

	public Set<Aluno> getInscritos() {
		return inscritos;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDuracaoEmMin(int duracaoEmMin) {
		this.duracaoEmMin = duracaoEmMin;
	}

}

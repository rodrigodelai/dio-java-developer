package me.dio.bootcamp;

public class Curso extends Conteudo {

	private Professor professor;

	public Curso() {}
	
	public Curso(String titulo, String descricao, int duracaoEmMin) {
		super(titulo, descricao, duracaoEmMin);
	}
	
	public Curso(String titulo, String descricao, int duracaoEmMin, Professor professor) {
		super(titulo, descricao, duracaoEmMin);
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		return "Curso: " + super.toString();
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
}

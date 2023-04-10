package me.dio.bootcamp;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mentoria extends Conteudo {

	private LocalDate data;
	private LocalTime horario;
	private Professor mentor; 
	
	public Mentoria() {}
	
	public Mentoria(String titulo, String descricao, int duracaoEmMin) {
		super(titulo, descricao, duracaoEmMin);
	}
	
	public Mentoria(String titulo, String descricao, int duracaoEmMin,
					LocalDate data, LocalTime horario, Professor mentor) {
		super(titulo, descricao, duracaoEmMin);
		this.data = data;
		this.horario = horario;
		this.mentor = mentor;
	}
	
	@Override
	public String toString() {
		return "Mentoria: " + super.toString();
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Professor getMentor() {
		return mentor;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setMentor(Professor mentor) {
		this.mentor = mentor;
	}
}

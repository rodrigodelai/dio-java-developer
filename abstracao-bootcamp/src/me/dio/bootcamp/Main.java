package me.dio.bootcamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

public class Main {

	public static void main(String[] args) {

		Bootcamp java = popularBootcamp();

		java.exibirEmenta();
		java.exibirInstrutores();
		java.exibirInscritos();
		
		Aluno a1 = (Aluno) obterElementoAleatorio(java.getInscritos());
		a1.exibirBootcampsInscritos();
		a1.exibirConteudosInscritos();
		
		java.desmatricular(a1, true);
		java.exibirInscritos();
		a1.exibirBootcampsInscritos();
		
		Conteudo c1 = (Conteudo) obterElementoAleatorio(java.getEmenta());
		
		c1.exibirInscritos();
		
	}
	
	public static Bootcamp popularBootcamp() {
		
		Bootcamp b1 = new Bootcamp("Java Developer",
								   "Aprenda ferramentas essenciais para atuar como um desenvolvedor Java.",
								   LocalDate.now().minusDays(15),
								   LocalDate.now().plusDays(45));
		
		Professor p1 = new Professor("cami-la@dio.me", "12321", "Camila Cavalcante");
		Professor p2 = new Professor("carlos@dio.me", "02030", "Carlos Lacerda");
		
		Conteudo c1 = new Curso("Conheça a Linguagem de Programação Java", "Descrição do Curso", 567, p1);
		Conteudo c2 = new Curso("Estruturas de Dados com Java", "Descrição do Curso", 872, p1);
		Conteudo c3 = new Curso("Orientação a Objetos com Java", "Descrição do Curso", 672, p1);
		Conteudo c4 = new Mentoria("SOLID e Boas Práticas", "Descrição da Mentoria", 60, LocalDate.now().plusDays(3), LocalTime.of(19,30), p1);		
		Conteudo c5 = new Curso("Bancos de Dados SQL e NoSQL", "Descrição do Curso", 472, p2);
		Conteudo c6 = new Curso("Spring Framework", "Descrição do Curso", 736, p2);
		Conteudo c7 = new Mentoria("Overview de Computação em Nuvem", "Descrição da Mentoria", 60, LocalDate.now().plusDays(33), LocalTime.of(19,30), p2);
		
		Aluno a1 = new Aluno("rodrigo@dio.me", "12345", "Rodrigo Delai");
		Aluno a2 = new Aluno("maria@dio.me", "13579", "Maria Júlia");
		Aluno a3 = new Aluno("tulipa@dio.me", "14703", "Tulipa");
		Aluno a4 = new Aluno("morfeu@dio.me", "00123", "Morfeu");
		Aluno a5 = new Aluno("binho@dio.me", "09821", "Binho");
		
		b1.incluirConteudos(new Conteudo[] {c1,c2,c3,c4,c5,c6,c7});
		
		try {
			for (Aluno aluno : new Aluno[]{a1,a2,a3,a4,a5})
				b1.matricular(aluno);
		} catch (NoSuchMethodException exception) {
			System.out.println(exception.getMessage());
		}
		
		return b1;
	}
	
	public static Object obterElementoAleatorio(Collection c) {
		return c.stream().skip((long)(c.size() * Math.random())).findFirst().orElse(null);
	}
}

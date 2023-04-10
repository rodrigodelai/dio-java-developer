package me.dio.bootcamp;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Bootcamp {

	private String titulo;
	private String descricao;
	private LocalDate inicio;
	private LocalDate fim;
	private List<Conteudo> ementa = new LinkedList<Conteudo>();;
	private Set<Professor> instrutores = new LinkedHashSet<Professor>();
	private Set<Aluno> inscritos = new LinkedHashSet<Aluno>();

	public Bootcamp() {}

	public Bootcamp(String titulo, String descricao, LocalDate inicio, LocalDate fim) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public void matricular(Aluno aluno) throws NoSuchMethodException {
		if (this.fim.compareTo(LocalDate.now()) < 0)
			throw new NoSuchMethodException("Não é possível matricular-se após o fim do bootcamp.");
		
		this.inscritos.add(aluno);
		aluno.addBootcamp(this);
		aluno.addConteudos(ementa);
		ementa.stream().forEach(conteudo -> conteudo.inscrever(aluno));
	}
	
	public void desmatricular(Aluno aluno, boolean exibir) {
		this.inscritos.remove(aluno);
		aluno.getBootcampsInscritos().remove(this);
		aluno.getConteudosInscritos().removeAll(ementa);
		ementa.stream().forEach(conteudo -> conteudo.desinscrever(aluno));
		
		if (exibir)
			System.out.println("O aluno " + aluno.getNome() + " foi desmatriculado do bootcamp " +
							   this.titulo + ".\n");
	}
	
	public void incluirConteudo(Conteudo conteudo) {
		ementa.add(conteudo);
		
		if (conteudo instanceof Curso)
			 this.instrutores.add(((Curso) conteudo).getProfessor());
	}
	
	public void incluirConteudos(Conteudo conteudos[]) {
		for (Conteudo conteudo : conteudos)
			this.incluirConteudo(conteudo);
	}
	
	public void exibirEmenta() {
		System.out.println("Ementa do bootcamp " + this.titulo + ":");
		
		if (ementa.isEmpty())
			System.out.println("- Não há conteúdos cadastrados.");
		else
			this.ementa.stream().forEach(comp -> System.out.println("- " + comp + ";"));
		
		System.out.println();
	}
	
	public void exibirInstrutores() {
		System.out.println("Intrutores do bootcamp " + this.titulo + ":");
		
		if (instrutores.isEmpty())
			System.out.println("- Não há instrutores cadastrados.");
		else
			this.instrutores.stream().forEach(instrutor -> System.out.println("- " + instrutor + ";"));
		
		System.out.println();
	}
	
	public void exibirInscritos() {
		System.out.println("Alunos inscritos no bootcamp " + this.titulo + ":");
		
		if (inscritos.isEmpty())
			System.out.println("- Não há alunos cadastrados.");
		else
			this.inscritos.stream().forEach(aluno -> System.out.println("- " + aluno + ";"));
		
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Bootcamp: " + titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public List<Conteudo> getEmenta() {
		return ementa;
	}

	public Set<Professor> getInstrutores() {
		return instrutores;
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

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

}

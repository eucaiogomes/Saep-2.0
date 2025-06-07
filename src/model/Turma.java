package model;

public class Turma {

	private int idTurma;
	private String nome;
	private String descricao;
	private Professor professor; 
	



	public Turma(int idTurma, String nome, String descricao, Professor professor) {
		super();
		this.idTurma = idTurma;
		this.nome = nome;
		this.descricao = descricao;
		this.professor = professor;
	}

	public Professor getProfessor() {
	    return professor;
	}

	public void setProfessor(Professor professor) {
	    this.professor = professor;
	}

	public Turma() {
		
	}
	
	
	public Turma(int idTurma, String nome) {
		
		this.idTurma = idTurma;
		this.nome = nome;
	}
	public Turma(int idTurma, String nome, String descricao) {
		
		this.idTurma = idTurma;
		this.nome = nome;
		this.descricao = descricao;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

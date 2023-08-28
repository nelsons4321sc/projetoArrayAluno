package br.com.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Aluno extends Pessoa{
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public double getMediaNota() {
		
		double somaNotas = 0.0;
		
		for(Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota();
		}
		
		return somaNotas / disciplinas.size();
	}
	
	public String getAlunoAprovado() {
		double media = this.getMediaNota();
		if(media >= 5) {
			if(media >=7) {
				return "APROVADO";
			}else {
				return "Recuperação";
			}
		} else {
			return "REPROVADO";
		}
	}

}

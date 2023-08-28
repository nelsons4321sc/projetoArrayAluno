package br.com.executar;

import javax.swing.JOptionPane;

import br.com.model.Aluno;
import br.com.model.Disciplina;

public class Executar {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
		
		//referêncua	//intância
		Aluno aluno1 = new Aluno();
		
		for(int pos =1; pos<=2; pos++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+" ?");
			String nomeNota = JOptionPane.showInputDialog("Nome da nota "+pos+" ?");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.parseDouble(nomeNota));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
		
		if(escolha == 0) {
			String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina: 1 ou 2??");
			aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - 1);
		}
				
		aluno1.setNome(nome);
		System.out.println(aluno1.getNome());
		System.out.println("Media do Aluno: "+ aluno1.getMediaNota());
		System.out.println("Resultado: "+ aluno1.getAlunoAprovado());
		
		
		

	}

}

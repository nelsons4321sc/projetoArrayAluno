package br.com.executar;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.model.Aluno;
import br.com.model.Disciplina;

public class Executar {

	public static void main(String[] args) {
		
		
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		for(int qtd=1; qtd<=2; qtd++) {
		
		
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+qtd+ "?" );
			
			//referêncua	//intância
			Aluno aluno1 = new Aluno();
			
			aluno1.setNome(nome);
			
			for(int pos =1; pos<=2; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+" ?");
				String nomeNota = JOptionPane.showInputDialog("Valor da Nota"+pos+" ?");
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.parseDouble(nomeNota));
				
				aluno1.getDisciplinas().add(disciplina);
			}
			
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
			
			
			if(escolha == 0) {
				
				int contRemover = 0;
				//foi adicionada essa variável para não estourar o array com um número estático -1
				int posicao = 1;
				
				while(contRemover == 0){
					String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina: 1, 2, 3 ou 4??");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					//se torna dinámico
					posicao ++;
					contRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover??");
				}
			}
			
			alunos.add(aluno1);
		}
		//vericando a posição do aluno
		for(int pos = 0; pos < alunos.size(); pos ++) {
			
			Aluno aluno = alunos.get(pos);
			
			System.out.println("Aluno "+aluno.getNome());
			System.out.println("Resultado: "+ aluno.getAlunoAprovado());
						
			for(Disciplina disciplina : aluno.getDisciplinas() ) {
				System.out.println(" Sua Matéria: "+disciplina.getDisciplina() + " e Nota= "+disciplina.getNota());
			}
			System.out.println("---------------------------------------------------------------------");
		}
		/*	
		for (Aluno aluno : alunos) {
			if(aluno.getNome().equalsIgnoreCase("nelson")) {
				
				alunos.remove(aluno);
			break;
			}else {
				System.out.println(aluno.getNome());
				System.out.println("Media do Aluno: "+ aluno.getMediaNota());
				System.out.println("Resultado: "+ aluno.getAlunoAprovado());
				System.out.println("---------------------------------------------------------------------");
			}
		}
		*/		
	}	

}

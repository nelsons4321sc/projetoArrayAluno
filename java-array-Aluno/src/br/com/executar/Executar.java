package br.com.executar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.constante.StatusAluno;
import br.com.model.Aluno;
import br.com.model.Disciplina;

public class Executar {

	public static void main(String[] args) {
		
		
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		//é uma lista que dentro dela temos uma chave que identifica uma sequência de valores também
		HashMap<String, List<Aluno>> maps  = new HashMap<String, List<Aluno>>();
		
		//Retirado as listas de alunos
		
		
		for(int qtd=1; qtd<=5; qtd++) {
		
		
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+qtd+ "?" );
			
			//referêncua	//intância
			Aluno aluno1 = new Aluno();
			
			aluno1.setNome(nome);
			
			for(int pos =1; pos<=1; pos++) {
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
		//no lugar da lista retirada
		//está setando as chaves com uma lista vazia de valores, iniciando os valores 
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		
		for (Aluno aluno : alunos) {
			if(aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)	) {
				//recupera a chave e adiciona o aluno
				maps.get(StatusAluno.APROVADO).add(aluno);
			} else
				if(aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);	
				}else {
					maps.get(StatusAluno.REPROVADO).add(aluno);
			}
		}
		
		
		System.out.println("------------------Lista de Alunos Aprovados------------------------------");
		// o mapa pega a chave que faz referência a lista de status do aluno
		for(Aluno aluno1 : maps.get(StatusAluno.APROVADO)) {
			System.out.println("Resultado = "+aluno1.getAlunoAprovado()+" com média = "+ aluno1.getMediaNota());
		}
		
		System.out.println("------------------Lista de Alunos Recuperação------------------------------");
		for(Aluno aluno1 : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println("Resultado = "+aluno1.getAlunoAprovado()+" com média = "+ aluno1.getMediaNota());
		}
		
		System.out.println("------------------Lista de Alunos Reprovados------------------------------");
		for(Aluno aluno1 : maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Resultado = "+aluno1.getAlunoAprovado()+" com média = "+ aluno1.getMediaNota());
		}
		
		//vericando a posição do aluno
		/*
		for(int pos = 0; pos < alunos.size(); pos ++) {
			
			Aluno aluno = alunos.get(pos);
			if(aluno.getNome().equalsIgnoreCase("Nelson")) {
				
				Aluno trocar = new Aluno();
				trocar.setNome(" nome "+aluno.getNome()+ " foi trocado");
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina("Matemática");
				disciplina.setNota(8.2);
				
				trocar.getDisciplinas().add(disciplina);
				
				alunos.set(pos, trocar);
				aluno = alunos.get(pos);
			}
			
			
			
			
			
			System.out.println("Aluno "+aluno.getNome());
			System.out.println("Media do Aluno: "+ aluno.getMediaNota());
			System.out.println("Resultado: "+ aluno.getAlunoAprovado());
						
			for(int posd = 0;  posd < aluno.getDisciplinas().size(); posd ++ ) {
				
				Disciplina disc = aluno.getDisciplinas().get(posd);
				System.out.println(" Sua Matéria: "+disc.getDisciplina() + " e Nota= "+disc.getNota());
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

package Escola;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Escola escola = new Escola();
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        

        do{
            
            System.out.printf("O que deseja realizar?\n");
            System.out.printf("\n1 - Cadastrar um aluno.\n");
            System.out.printf("2 - Inserir notas.\n");
            System.out.printf("3 - Exibir média geral da turma.\n");
            System.out.printf("0 - Encerrar o programa.\n");
            opcao = input.nextInt();

            switch(opcao){
                case 1:

                Aluno aluno = new Aluno();
                System.out.printf("Insira o seu nome: \n");
                aluno.setNome(input.next());
                System.out.printf("Bem vindo à Minha Escolinha, %s.\n", aluno.getNome());
                System.out.printf("Você está matriculado. Sua matrícula é: [%s]", aluno.gerarMatricula());
                alunos.add(aluno);
                System.out.println("\nCadastro realizado com sucesso.");
                break;

                case 2: 

                System.out.printf("Informe o nome do aluno: \n");
                String nome = input.next();

                Aluno find = null;
                for (int i = 0; i < alunos.size(); i++) {
                    Aluno a = alunos.get(i);
                    if (a.getNome().equalsIgnoreCase(nome)) {
                        find = a;
                        break;
                    }
                }

                if(find == null){
                    System.out.printf("\nAluno não encontrado.\n");
                }else {
                    System.out.printf("Insira a 1º nota:\n");
                    find.setNota1(input.nextDouble()); 
                    System.out.printf("Insira a 2º nota:\n");
                    find.setNota2(input.nextDouble());
                    System.out.printf("Insira a 3º nota:\n");
                    find.setNota3(input.nextDouble());
                    find.getMedia();
                    System.out.printf("Média do aluno %s: %.2f\n", find.getNome(), find.getMedia());
                    System.out.printf("Situação: %s", find.status());
                    break;
                }

                case 3:

                if (alunos.isEmpty()) {
                    System.out.println("Não há alunos cadastrados na turma.");
                } else {
                    double somaDasMedias = 0.0;

                    System.out.println("Média de cada aluno:");
                    for (int i = 0; i < alunos.size(); i++) {
                        Aluno a = alunos.get(i);
                        System.out.printf("Aluno: %s, Média: %.2f\n", a.getNome(), a.getMedia());
                        somaDasMedias += a.getMedia();
                    }

                    double mediaGeral = somaDasMedias / alunos.size();
                    System.out.printf("A média geral da turma é: %.2f\n", mediaGeral);
                }

                break;
            }

        }while(opcao != 0);

    }
}

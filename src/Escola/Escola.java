package Escola;

import java.util.ArrayList;
import java.util.Random;

public class Escola {
    private ArrayList<Aluno> Alunos;
    private int qtdAluno;

    public ArrayList<Aluno> getAlunos() {
        return Alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        Alunos = alunos;
    }

    protected Aluno buscaAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        for (int i = 0; i < this.qtdAluno; i++) {
            if (this.Alunos.get(i).compareTo(aluno) == 0) {
                return this.Alunos.get(i);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.Alunos.isEmpty();
    }

}

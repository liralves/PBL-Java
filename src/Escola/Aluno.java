package Escola;

import java.util.Random;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;
    private double media;

    public Aluno(String nome, String matricula, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calcularMedia();
    }

    public Aluno() {
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setNota1(double nota1){
        this.nota1 = nota1;
        calcularMedia();
    }
    public void setNota2(double nota2){
        this.nota2 = nota2;
        calcularMedia();
    }

    public void setNota3(double nota3){
        this.nota3 = nota3;
        calcularMedia();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void calcularMedia() {
        this.media = (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    public String gerarMatricula() {
        Random rand = new Random();
        int x = rand.nextInt(999999);
        return String.format("%06d", x);
    }

    public String status(){
        if(this.media >= 7){
            return "Aprovado por média (AM)\n.";
        }else if(this.media >= 5){
            return "Aprovado (AP).\n";
        }else{
            return "Reprovado.\n";
        }
    }

    @Override
    public int compareTo(Aluno aluno) {
        return this.matricula.compareTo(aluno.getMatricula());
    }
}

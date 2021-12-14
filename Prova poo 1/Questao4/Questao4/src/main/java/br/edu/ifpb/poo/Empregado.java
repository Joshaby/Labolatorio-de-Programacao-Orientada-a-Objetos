package br.edu.ifpb.poo;

public class Empregado {
    private String nome;
    private int idade;
    private double salario;

    public Empregado() { this("--sem nome--", 30, 890.90); }
    public Empregado(String nome, int idade, double salario) {
        setNome(nome);
        setIdade(idade);
        setSalario(salario);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) {
        this.idade = (idade >= 18) ? idade : 30;
    }

    public double getSalario() { return salario; }
    public void setSalario(double salario) {
        this.salario = (salario > 0) ? salario : 0;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nIdade: %d\nSalârio: %.2f\n",
                getNome(), getIdade(), getSalario());
    }
}

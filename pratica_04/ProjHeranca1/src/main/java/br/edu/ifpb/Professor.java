package br.edu.ifpb;

public class Professor extends Funcionario {
    private int numeroHoras;

    public Professor() {
        super(0, "--sem endereco--", "--sem nome--", 790.90, 0);
        setNumeroHoras(8);
    }

    public Professor(int idade, String endereco, String nome, double salario, int numeroHoras, int matricula) {
        super(idade, endereco, nome, salario, matricula);
        setNumeroHoras(numeroHoras);
    }

    public int getNumeroHoras() { return numeroHoras; }
    public void setNumeroHoras(int numeroHoras) { if (numeroHoras > 0) this.numeroHoras = numeroHoras; }

    @Override
    public double getSalario() {
        return super.getSalario() + (5 * getNumeroHoras()); 
    }

    @Override
    public String toString() {
        return " Tipo funcionário: " + TiposFuncionario.PROFESSOR + "\n" +
                super.toString() +
               "  Horas trabalhadas: " + getNumeroHoras() + "\n" +
               "  Salário final: " + getSalario() + "\n";
    }
}
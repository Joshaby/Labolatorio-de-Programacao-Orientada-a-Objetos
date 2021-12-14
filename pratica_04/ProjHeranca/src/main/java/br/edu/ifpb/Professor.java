package br.edu.ifpb;

public class Professor {
    private static int matriculaG = 0;
    private int matricula = Professor.matriculaG ++;
    private int idade;
    private String endereco;
    private String nome;
    private int numeroHoras;
    private double salario;

    public Professor() { this(0, "--sem endereço--", "--sem nome--", 8, 480); }

    public Professor(int idade, String endereco, String nome, int numeroHoras, double salario) {
        setIdade(idade);
        setEndereco(endereco);
        setNome(nome);
        setNumeroHoras(numeroHoras);
        setSalario(salario);
    }

    public int getMatricula() { return matricula; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { if (idade > 18) this.idade = idade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumeroHoras() { return numeroHoras; }
    public void setNumeroHoras(int numeroHoras) { if(numeroHoras > 0) this.numeroHoras = numeroHoras; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { if(salario > 0) this.salario = salario; }

    @Override
    public String toString() {
        return  "Matrícula: " + matricula +
                " Idade: " + idade +
                " Endereco: " + endereco +
                " Nome: " + nome +
                " Número de horas: " + numeroHoras +
                " Sálario: " + salario + "\n";
    }
}

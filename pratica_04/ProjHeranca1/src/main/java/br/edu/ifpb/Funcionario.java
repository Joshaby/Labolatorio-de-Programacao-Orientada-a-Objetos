package br.edu.ifpb;

public abstract class Funcionario {
    private int matricula;
    private int idade;
    private String endereco;
    private String nome;
    private double salario;

    public Funcionario() { this(0, "--sem endereço--", "--sem nome--", 480, 0); }

    public Funcionario(int idade, String endereco, String nome, double salario, int matricula) {
        setIdade(idade);
        setEndereco(endereco);
        setNome(nome);
        setSalario(salario);
        setMatricula(matricula);
    }

    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { if (matricula >= 0) this.matricula = matricula; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { if (idade >= 18) this.idade = idade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { if(salario > 0) this.salario = salario; }

    @Override
    public String toString() {
        return  "  Matrícula: " + matricula + "\n" +
                "  Idade: " + idade + "\n" +
                "  Endereco: " + endereco + "\n" +
                "  Nome: " + nome + "\n" +
                "  Sálario: " + salario + "\n";
    }
}

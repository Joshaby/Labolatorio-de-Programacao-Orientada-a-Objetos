package br.edu.ifpb.poo;

public class Diretor extends Empregado {
    private String departamento;

    public Diretor(String departamento) {
        super();
        setDepartamento("-sem departamento");
    }
    public Diretor(String nome, int idade, double salario, String departamento) {
        super(nome, idade, salario);
        setDepartamento(departamento);
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public String toString() {
        return String.format("%sTipo empregado: %s\n", super.toString(), "Diretor");
    }
}

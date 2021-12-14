package br.edu.ifpb;

public class Gerente extends Funcionario {
    private double comissao;

    public Gerente() {
        super(0, "--sem endereco--", "--sem nome--", 790.90, 0);
        setComissao(1.1);
    }

    public Gerente(int idade, String endereco, String nome, double salario, int matricula, double comissao) {
        super(idade, endereco, nome, salario, matricula);
        setComissao(comissao);
    }

    public double getComissao() { return comissao; }
    public void setComissao(double comissao) { if (comissao > 1)this.comissao = comissao; }
    
    @Override
    public double getSalario() {
        return super.getSalario() * getComissao(); 
    }

    @Override
    public String toString() {
        return " Tipo funcionário: " + TiposFuncionario.GERENTE + "\n" +
                super.toString() +
               "  Comissão: " + getComissao() + "%" + "\n" +
               "  Salário final: " + getSalario() + "\n";
    }
}
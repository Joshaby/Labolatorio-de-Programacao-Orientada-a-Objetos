package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
    private String nomeInst = "IFPB";
    private List<Funcionario> funcionarios;
    private int qtdeFuncionarios = 0;

    public Instituto() { setFuncionarios(); }

    private void setFuncionarios() { funcionarios = new ArrayList<Funcionario>(); }

    public int getQtdeFuncionarios() { return qtdeFuncionarios; }

    public boolean adicionarFuncionario(Funcionario funcionario) {
        for (Funcionario funcionario1 : funcionarios) {
            if (funcionario1.getMatricula() == funcionario.getMatricula()) return false;
        }
        funcionarios.add(funcionario);
        qtdeFuncionarios ++;
        return true;
    }
    public boolean removerFuncionario(int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                funcionarios.remove(funcionario);
                qtdeFuncionarios --;
                return true;
            }
        }
        return false;
    }
    public Funcionario buscarFuncionario(int matricula) {
        for(Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) return funcionario;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder conc = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            conc.append(funcionario);
        }
        return conc.toString();
    }
}

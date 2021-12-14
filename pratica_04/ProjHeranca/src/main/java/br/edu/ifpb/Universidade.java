package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private String nomeUniversidade;
    private int qtdeFuncionarios = 0;
    private List <Professor> funcionarios;

    public Universidade(String nomeUniversidade) {
        setNomeUniversidade(nomeUniversidade);
        funcionarios = new ArrayList<Professor>();
    }

    public String getNomeUniversidade() { return nomeUniversidade; }

    public void setNomeUniversidade(String nomeUniversidade) { this.nomeUniversidade = nomeUniversidade; }

    public boolean adicionarProfessor(int idade, String endereco, String nome, int numeroHoras, double salario) {
        boolean cond = true;
        Professor p = buscarProfessor(nome);
        funcionarios.add(new Professor(idade, endereco, nome, numeroHoras, salario));
        qtdeFuncionarios ++;
        return cond;
    }

    public boolean removerProfessor(String nome) {
        if (funcionarios.size() == 0) return false;
        else {
            boolean cond = true;
            Professor p = buscarProfessor(nome);
            if (p.getNome() == nome) funcionarios.remove(p);
            else cond = false;
            qtdeFuncionarios--;
            return cond;
        }
    }

    public Professor buscarProfessor(String nome) {
        Professor p = null;
        for (int i = 0; i < funcionarios.size(); i ++) {
            if (funcionarios.get(i).getNome() == nome) p = funcionarios.get(i);
        }
        return p;
    }

    @Override
    public String toString() {
        String todosProfessores = null;
        for (int i = 0; i < funcionarios.size(); i ++) {
            todosProfessores += (funcionarios.get(i).toString() + "\n");
        }
        return todosProfessores;
    }
}

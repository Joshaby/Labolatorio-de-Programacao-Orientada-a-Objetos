package br.edu.ifpb.poo;

import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
    private int num;
    private String nome;
    private String sobrenome;

    public Cliente(int num, String nome, String sobrenome) {
        setNum(num);
        setNome(nome);
        setSobrenome(sobrenome);
    }

    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    @Override
    public String toString() { return String.format("%d %s %s", getNum(), getNome(), getSobrenome()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return num == cliente.num;
    }

    @Override
    public int hashCode() { return Objects.hash(num); }

    @Override
    public int compareTo(Cliente cliente) { return Integer.compare(getNum(), cliente.getNum()); }
}

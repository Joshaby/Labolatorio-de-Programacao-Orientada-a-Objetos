package br.edu.ifpb.poo;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private String endereco;
    private String cidade;
    private String estado;
    private int codigoPostal;

    public Cliente(int codigo, String nome, String sobrenome, int idade, String endereco, String cidade, String estado, int codigoPostal) {
        setCodigo(codigo);
        setNome(nome);
        setSobrenome(sobrenome);
        setIdade(idade);
        setEndereco(endereco);
        setCidade(cidade);
        setEstado(estado);
        setCodigoPostal(codigoPostal);
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo;
    }

    @Override
    public int hashCode() { return Objects.hash(codigo); }

    @Override
    public int compareTo(Cliente cliente) {
        return Integer.compare(getCodigo(), cliente.getCodigo());
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %d %s %s %s %d"
                , getCodigo(), getNome(), getSobrenome(), getIdade(), getEndereco(), getCidade(), getEstado(), getCodigoPostal());
    }
}

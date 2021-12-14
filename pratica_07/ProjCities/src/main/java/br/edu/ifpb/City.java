package br.edu.ifpb;

import java.util.Objects;

public class City implements Comparable<City> {
    String nome;
    String estado;
    String cep;

    public City(String nome, String estado, String cep) {
        setNome(nome);
        setEstado(estado);
        setCep(cep);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    @Override
    public int compareTo(City city) { return getNome().compareTo(city.getNome()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(nome, city.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() { return String.format("%s, %s, %s", getNome(), getEstado(), getCep()); }
}
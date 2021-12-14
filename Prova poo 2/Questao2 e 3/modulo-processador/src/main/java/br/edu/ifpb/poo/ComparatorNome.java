package br.edu.ifpb.poo;

import java.util.Comparator;

public class ComparatorNome implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente, Cliente t1) {
        return cliente.getNome().compareTo(t1.getNome());
    }
}
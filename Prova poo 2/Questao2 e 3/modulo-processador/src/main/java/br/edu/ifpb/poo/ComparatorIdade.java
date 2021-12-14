package br.edu.ifpb.poo;

import java.util.Comparator;

public class ComparatorIdade implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente, Cliente t1) {
        return Integer.compare(cliente.getIdade(), t1.getIdade());
    }
}

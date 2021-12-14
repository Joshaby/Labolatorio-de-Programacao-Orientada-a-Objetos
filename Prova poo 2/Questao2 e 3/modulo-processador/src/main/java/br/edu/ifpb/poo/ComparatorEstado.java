package br.edu.ifpb.poo;

import java.util.Comparator;

public class ComparatorEstado implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente, Cliente t1) {
        return cliente.getEstado().compareTo(t1.getEstado());
    }
}
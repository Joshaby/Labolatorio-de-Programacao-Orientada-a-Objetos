package br.edu.ifpb.poo;

import java.util.ArrayList;
import java.util.Arrays;

public class UsarProcessadorProduto {
    public static void main(String[] args) {
        ArrayList<Produto> listaprodutos = new ArrayList<>(
                Arrays.asList(
                        new Produto (1, "Maçã", "Guarabira", 2.00, 30),
                        new Produto (2, "Banana", "Guarabira", 1.00, 15),
                        new Produto (3, "Laranja", "Guarabira", 4.00, 40),
                        new Produto (4, "Maçã", "Natal", 10.00, 25)));
        ProcessadorProdutos p = new ProcessadorProdutos(listaprodutos);
        p.imprimirRelatorio();
    }
}

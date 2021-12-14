package br.edu.ifpb.poo;

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessadorProdutos {
    private ArrayList<Produto> produtos;

    public ProcessadorProdutos() {
        this(new ArrayList<Produto>(Arrays.asList(new Produto(), new Produto())));
    }
    public ProcessadorProdutos(ArrayList<Produto> produtos) {
        setProdutos(produtos);
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void imprimirRelatorio() {
        String s = "---------- Vendas por Cidade ----------\n- Cidade           - R$ -\n";
        String s1 = "---------- Vendas por Produto ----------\n- Produto            - R$ -\n";
        ArrayList <String> frutas = new ArrayList<>();
        ArrayList <String> cidade = new ArrayList<>();
        for (Produto produto : produtos) {
            boolean cond = true, cond1 = true;
            for (String f : frutas) {
                if (f.equalsIgnoreCase(produto.getDescricao())) {
                    cond = false;
                }
            }
            if (cond) frutas.add(produto.getDescricao());
            for (String c : cidade) {
                if (c.equalsIgnoreCase(produto.getCidadeOrigem())) {
                    cond1 = false;
                }
            }
            if (cond1) cidade.add(produto.getCidadeOrigem());
            cond = true;
            cond1 = true;
        }
        for (String f : frutas) {
            double v = 0.0;
            for (Produto produto : produtos) {
                if (f.equalsIgnoreCase(produto.getDescricao())) {
                    v += (produto.getQuantidade() * produto.getPreco());
                }
            }
            s1 += String.format("-%6s           - %.0f -\n", f, v);
        }
        for (String c : cidade) {
            double v = 0.0;
            for (Produto produto : produtos) {
                if (c.equalsIgnoreCase(produto.getCidadeOrigem())) {
                    v += (produto.getQuantidade() * produto.getPreco());
                }
            }
            s += String.format("-%6s            - %.0f -\n", c, v);
        }
        System.out.println(s + s1);
    }
}
package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpb.Livro;

public class Catalogo {
    private int qtde_Livros = 0;
    private List<Livro> livros;
    private String nome_Catalogo = null;
    public Catalogo(String nome_Catalogo) {
        setNome_Catalogo(nome_Catalogo);
        livros = new ArrayList<Livro>();
    }
    public void setNome_Catalogo(String nome_catalogo) { this.nome_Catalogo = nome_Catalogo; }
    public int getQtde_Livros() {
        return qtde_Livros;
    }
    public String getNome_Catalogo() {
        return nome_Catalogo;
    }
    public boolean adicionar_Livro(String nome_Livro, int qtde_Página, String gênero, String autor) {
        boolean cond = true;
        if (buscar_Livro(nome_Livro)) cond = false;
        else {
            livros.add(new Livro(nome_Livro, qtde_Página, gênero, autor));
            qtde_Livros ++;
        }
        return cond;
    }
    public boolean remover_Livro(String nome_Livro) {
        boolean cond = false;
        for (int i = 0; i < livros.size(); i ++) {
            if (livros.get(i).getNome_Livro().equalsIgnoreCase(nome_Livro)) {
                livros.remove(livros.get(i));
                qtde_Livros --;
                cond = true;
            }
        }
        return cond;
    }
    public boolean buscar_Livro(String nome_Livro) {
        boolean cond = false;
        for (int i = 0; i < livros.size(); i ++) {
            if (livros.get(i).getNome_Livro().equalsIgnoreCase(nome_Livro)) {
                cond = true;
                break;
            }
        }
        return cond;
    }
    @Override
    public String toString() {
        String livro = String.format("Catálogo: %s\n\n", nome_Catalogo);
        for (int i = 0; i < livros.size(); i ++) {
            livro += String.format("Livro: %s\n" +
                            "Qtde. de páginas: %s\n" +
                            "Gênero: %s\n" +
                            "Autor: %s\n\n",
                    livros.get(i).getNome_Livro(),
                    livros.get(i).getQtde_Página(),
                    livros.get(i).getGênero(),
                    livros.get(i).getAutor());
        }
        return livro;
    }
    public String livro_Por_Gênero(String gênero) {
        String livro = String.format("Catálogo: %s\n\n", nome_Catalogo);
        for (int i = 0; i < livros.size(); i ++) {
            if (livros.get(i).getGênero() == gênero)
                livro += String.format("Livro: %s\n" +
                                "Qtde. de páginas: %s\n" +
                                "Gênero: %s\n" +
                                "Autor: %s\n\n",
                        livros.get(i).getNome_Livro(), livros.get(i).getQtde_Página(),
                        livros.get(i).getGênero(), livros.get(i).getAutor());
        }
        return livro;
    }
    public String livro_Por_Autor(String autor) {
        String livro = String.format("Catálogo: %s\n\n", nome_Catalogo);
        for (int i = 0; i < livros.size(); i ++) {
            if (livros.get(i).getGênero() == autor)
                livro += String.format("Livro: %s\n" +
                                "Qtde. de páginas: %s\n" +
                                "Gênero: %s\n" +
                                "Autor: %s\n\n",
                        livros.get(i).getNome_Livro(), livros.get(i).getQtde_Página(),
                        livros.get(i).getGênero(), livros.get(i).getAutor());
        }
        return livro;
    }
}

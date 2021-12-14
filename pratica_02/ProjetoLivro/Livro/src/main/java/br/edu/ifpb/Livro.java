package br.edu.ifpb;

public class Livro {
    private String nome_Livro;
    private int qtde_Página;
    private String gênero;
    private String autor;
    public String getNome_Livro() { return nome_Livro; }
    public void setNome_Livro(String nome_Livro) { this.nome_Livro = nome_Livro; }
    public int getQtde_Página() { return qtde_Página; }
    public void setQtde_Página(int qtde_Página) { this.qtde_Página = qtde_Página; }
    public String getGênero() { return gênero; }
    public void setGênero(String gênero) { this.gênero = gênero; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Livro(String nome_Livro, int qtde_Página, String gênero, String autor) {
        setNome_Livro(nome_Livro);
        setQtde_Página(qtde_Página);
        setGênero(gênero);
        setAutor(autor);
    }
}

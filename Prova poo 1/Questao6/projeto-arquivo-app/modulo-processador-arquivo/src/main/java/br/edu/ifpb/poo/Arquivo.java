package br.edu.ifpb.poo;

public class Arquivo {
    private String caminho;

    public Arquivo() {
        this("--sem caminho--");
    }
    public Arquivo(String caminho) {
        setCaminho(caminho);
    }

    public String getCaminho() { return caminho; }
    public void setCaminho(String caminho) { this.caminho = caminho; }

    public String getNomeArquivo() {
        String d[] = caminho.split("/");
        String arquivo = d[d.length - 1];
        int posiPonto = arquivo.lastIndexOf(".");
        return arquivo.substring(0, posiPonto);
    }

    public String extensao() {
        int posiPonto = caminho.lastIndexOf(".");
        return caminho.substring(posiPonto + 1, (caminho.length()));
    }

    public String path() {
        String d[] = caminho.split("/");
        String path = "/" + d[1];
        for (int i = 2; i < d.length - 1; i ++) {
            if ((d[i + 1].lastIndexOf(".") != -1) || (d[i + 1].lastIndexOf(".") == -1)) {
                path += ("/" + d[i]);
            }
        }
        return path;
    }
}

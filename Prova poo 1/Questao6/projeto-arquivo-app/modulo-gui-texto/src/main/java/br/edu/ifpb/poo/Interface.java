package br.edu.ifpb.poo;

import br.edu.ifpb.poo.Arquivo;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        exibirInterface();
    }
    public static void exibirInterface() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo: ");
        String caminho = input.nextLine();
        Arquivo a = new Arquivo(caminho);
        System.out.printf("Resultado do processamento: \n\nExtensão: %s\nNome do arquivo: %s\nPath: %s\n",a.extensao(), a.getNomeArquivo(), a.path());
    }
}

package br.edu.ifpb;

import java.util.Scanner;

public class TestCatalogo {
    public static void main(String[] args) {
        iniciar_Catálogo();
    }
    private static void exibir_Menu() {
        System.out.print("------Catálogo de livros------\n\n" +
                   "\t1. Criar catálogo\n" +
                   "\t2. Adicionar livro\n" +
                   "\t3. Remover livro\n" +
                   "\t4. Verificar livro\n" +
                   "\t5. Mostrar qtde. de livros\n" +
                   "\t6. Mostrar livros\n" +
                   "\t7. Mostrar livros por gênero\n" +
                   "\t8. Mostrar livros por autor\n" +
                   "\t9. Sair\n\n" +
                   "\tDigite uma opção: ");
    }
    private static void iniciar_Catálogo() {
        Catalogo c = null;
        Scanner input = new Scanner(System.in);
        while (true) {
            int cond = 0;
            if (cond != 0) break;
            else {
                exibir_Menu();
                int inpt = input.nextInt();
                switch (inpt) {
                    case 1:
                        if (c == null) {
                            System.out.print("\tDigite um nome para o catálogo: ");
                            String nome_Catalogo = input.next();
                            c = new Catalogo(nome_Catalogo);
                        } else {
                            System.out.println("\tCatálogo já criado!\n");
                        }
                        break;
                    case 2:
                        System.out.print("\tDigite o nome do livro: ");
                        String nome_Livro = input.next();
                        System.out.print("\tDigite a qtde. de páginas: ");
                        int qtde_Página = input.nextInt();
                        System.out.print("\tDigite o gênero: ");
                        String gênero = input.next();
                        System.out.print("\tDigite o autor: ");
                        String autor = input.next();
                        if (c.adicionar_Livro(nome_Livro, qtde_Página, gênero, autor))
                            System.out.println("\tLivro adicionado!\n");
                        else System.out.println("\tUm livro com mesmo nome já adicionado!\n");
                        break;
                    case 3:
                        System.out.print("\tDigite o nome do livro: ");
                        String nome_Livro1 = input.next();
                        if (c.remover_Livro(nome_Livro1)) System.out.println("\tLivro removido!\n");
                        else System.out.println("\tLivro não esta no catálogo ou já foi removido!\n");
                        break;
                    case 4 :
                        System.out.print("\tDigite o nome do livro: ");
                        String nome_Livro2 = input.next();
                        if (c.buscar_Livro(nome_Livro2)) System.out.println("\tLivro está no catálogo!\n");
                        else System.out.println("\tLivro não esta no catálogo ou já foi removido!\n");
                        break;
                    case 5 :
                        System.out.printf("\tQtde. de livros: %i\n\n", c.getQtde_Livros());
                        break;
                    case 6 :
                        System.out.println(c);
                        break;
                    case 7 :
                        System.out.print("\tDigite o gênero: ");
                        String gênero1 = input.next();
                        System.out.println(c.livro_Por_Gênero(gênero1));
                        break;
                    case 8 :
                        System.out.print("\tDigite o autor: ");
                        String autor1 = input.next();
                        System.out.println(c.livro_Por_Autor(autor1));
                        break;
                    case 9 :
                        cond = 1;
                        break;
                }
            }
        }
    }
}

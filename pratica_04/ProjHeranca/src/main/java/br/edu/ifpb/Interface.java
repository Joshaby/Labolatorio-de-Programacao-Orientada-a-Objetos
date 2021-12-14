package br.edu.ifpb;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        iniciarUniversidade();
    }

    public static void exibirMenu() {
        System.out.println(
                "----Universidade----\n\n\n" +
                "Escolha uma opção:\n\n" +
                "1. Criar universidade\n" +
                "2. Adicionar professor\n" +
                "3. Remover professor\n" +
                "4. Exibir todos os professores\n" +
                "5. Sair\n\n" +
                "  Digite um opção: ");
    }

    public static void iniciarUniversidade() {
        Scanner input = new Scanner(System.in);
        int cond = 0;
        Universidade uni = null;
        while (cond != 5) {
            exibirMenu();
            cond = input.nextInt();
            if (cond == 1) {
                if (uni == null) {
                    Scanner input1 = new Scanner(System.in);
                    System.out.print("Digite um nome: ");
                    String nome = input1.nextLine();
                    uni = new Universidade(nome);
                    System.out.println("Universidade criada!\n\n");
                } else System.out.println("Universidade já criada!\n\n");
            }
            else if (cond == 2) {
                if (uni != null) {
                    Scanner input1 = new Scanner(System.in);
                    System.out.print("Digite um nome: ");
                    String nome = input1.nextLine();
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("Digite uma idade: ");
                    int idade = input2.nextInt();
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("Digite um endereço: ");
                    String endereco = input3.nextLine();
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("Digite uma carga horária: ");
                    int numeroHoras = input4.nextInt();
                    Scanner input5 = new Scanner(System.in);
                    System.out.print("Digite um salário: ");
                    double salario = input5.nextDouble();
                    if (uni.adicionarProfessor(idade, endereco, nome, numeroHoras, salario))
                        System.out.println("Professor adicionado!\n");
                    else System.out.println("Professor não adicionado!\n");
                }
                else System.out.println("Crie primeiro a universidade!\n");
            }
            else if (cond == 3) {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Digite um nome: ");
                String nome = input1.nextLine();
                if (uni.removerProfessor(nome)) System.out.println("Professor removido!\n");
                else System.out.println("Professor não foi removido!\n");
            }
            else if (cond == 4) {
                System.out.println(uni.toString());
            }
        }
    }
}

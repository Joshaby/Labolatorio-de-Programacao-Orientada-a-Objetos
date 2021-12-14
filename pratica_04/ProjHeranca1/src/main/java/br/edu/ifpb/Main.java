package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        iniciarMain();
    }
    public static void exibirMenu() {
        System.out.println(
                " ------ IFPB ------ \n" +
                "  1. Adicionar funcionario\n" +
                "  2. Remover funcionario\n" +
                "  3. Lista todos funcionarios\n" +
                "  4. Sair\n\n" +
                "   Digite uma opção: "
        );
    }

    public static void iniciarMain() {
        int cond = 0;
        Instituto ifpb = new Instituto();
        while (cond != 4) {
            exibirMenu();
            Scanner input = new Scanner(System.in);
            cond = input.nextInt();
            if (cond == 1) {
                Scanner input0 = new Scanner(System.in);
                System.out.print("  Digite um nome: ");
                String nome = input0.nextLine();
                System.out.print("  Digite uma idade: ");
                Scanner input1 = new Scanner(System.in);
                int idade = input1.nextInt();
                System.out.print("  Digite um endereço: ");
                Scanner input2 = new Scanner(System.in);
                String endereco = input2.nextLine();
                System.out.print("  Digite um salário: ");
                Scanner input3 = new Scanner(System.in);
                double salario = input3.nextDouble();
                System.out.print("  Digite uma matrícula: ");
                int matricula = input3.nextInt();
                System.out.print("  Este funcionário é um gerente ou professor? ");
                String tipo = input3.next();
                if (tipo.equalsIgnoreCase("professor")) {
                    System.out.print("  Digite uma carga horária: ");
                    int carga = input3.nextInt();
                    Professor func1 = new Professor(idade, endereco, nome, salario, carga, matricula);
                    if(ifpb.adicionarFuncionario(func1)) System.out.println("  \nFuncionário adicionado!\n");
                    else System.out.println("  \nFuncionário não adicionado!\n");
                }
                else if (tipo.equalsIgnoreCase("gerente")) {
                    System.out.print("  Digite uma comissão: ");
                    double comissao = input3.nextDouble();
                    Gerente func1 = new Gerente(idade, endereco, nome, salario, matricula, comissao);
                    if(ifpb.adicionarFuncionario(func1)) System.out.println("  \nFuncionário adicionado!\n");
                    else System.out.println("  \nFuncionário não adicionado!\n");
                }
            }
            else if (cond == 2) {
                if (ifpb.getQtdeFuncionarios() > 0) {
                    System.out.print("  Digite uma matrícula: ");
                    int matricula = input.nextInt();
                    if (ifpb.removerFuncionario(matricula)) System.out.println("  \nFuncionário removido!\n");
                    else System.out.println("  \nFuncionário não removido!\n");
                }
                else System.out.println("  \nO instituto não possui funcionários!\n");
            }
            else if (cond == 3) {
                System.out.println(ifpb);
            }
        }
    }
}

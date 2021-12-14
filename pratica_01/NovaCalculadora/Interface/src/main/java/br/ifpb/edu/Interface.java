package br.ifpb.edu;

import java.util.Scanner;

import br.ifpb.edu.Calculadora;

public class Interface {
    private void exibir_Menu() {
        System.out.println("\n-------Calculadora Java-------\n");
        System.out.println("\t1 - Somar");
        System.out.println("\t2 - Subtrair");
        System.out.println("\t3 - Multiplicar");
        System.out.println("\t4 - Dividir");
        System.out.println("\t5 - Exibir memória");
        System.out.println("\t6 - Sair\n");
        System.out.print("\tDigite uma opção: ");
    }
    public void iniciar_Calculadora() {
        Scanner input = new Scanner(System.in);
        Calculadora c = new Calculadora();
        while (true) {
            exibir_Menu();
            int i = input.nextInt();
            if (i >= 1 && i <= 4) {
                System.out.print("\n\tDigite o primeiro número: ");
                double num1 = input.nextDouble();
                System.out.print("\tDigite o segundo número: ");
                double num2 = input.nextDouble();
                if (i == 1) System.out.printf("\n\tResultado: %.2f\n\n", c.soma(num1, num2));
                else if (i == 2) System.out.printf("\n\tResultado: %.2f\n\n", c.subtrair(num1, num2));
                else if (i == 3) System.out.printf("\n\tResultado: %.2f\n\n", c.multiplicar(num1, num2));
                else System.out.printf("\n\tResultado: %.2f\n\n", c.dividir(num1, num2));
            }
            else if (i == 5) System.out.printf("\n\tNúmero armazenado: %.2f\n\n", c.GT());
            else if (i == 6) break;
            else if (i >= 7) System.out.println("\n\tComando não encontrado!\n");
        }
    }
}

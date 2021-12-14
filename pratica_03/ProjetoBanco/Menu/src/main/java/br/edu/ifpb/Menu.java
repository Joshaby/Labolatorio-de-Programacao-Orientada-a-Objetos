package br.edu.ifpb;

import java.util.Scanner;
import br.edu.ifpb.Conta;

public class Menu {
    public static void main(String[] args) {
        iniciar_Conta();
    }
    public static void exibir_Menu() {
        System.out.print("\n--------Conta Corrente------\n\n" +
                           "\t1. Definir titular\n" +
                           "\t2. Saque\n" +
                           "\t3. Deposito\n" +
                           "\t4. Saldo\n" +
                           "\t5. Extrato\n" +
                           "\t6. Exibir conta\n" +
                           "\t7. Sair\n\n" +
                           "\tDigite uma opção: ");
    }
    public static void iniciar_Conta() {
        Conta conta = new Conta();
        Scanner input = new Scanner(System.in);
        int entrada = 0;
        while (entrada != 7) {
            exibir_Menu();
            entrada = input.nextInt();
            if (entrada == 1) {
                System.out.print("\tDigite um nome: ");
                String titular = input.next();
                conta.setTitular(titular);
                System.out.println("\tTitular adicionado!\n");
            }
            else if (entrada == 2) {
                System.out.print("\tDigite uma quantia: ");
                double quantia = input.nextDouble();
                boolean cond = conta.sacar(quantia);
                if (cond) System.out.println("\tSaque realizado!\n");
                else System.out.println("\tSaque não realizado!\n");
            }
            else if (entrada == 3) {
                System.out.print("\tDigite uma quantia: ");
                double quantia = input.nextDouble();
                boolean cond = conta.depositar(quantia);
                if (cond) System.out.println("\tDeposito realizado!\n");
                else System.out.println("\tDeposito não realizado!\n");
            }
            else if (entrada == 4) { System.out.printf("\tSaldo: R$ %.2f\n\n", conta.getSaldo()); }
            else if (entrada == 5) { System.out.printf("%s\n", conta.extrato()); }
            else if (entrada == 6) { System.out.printf("%s\n", conta); }
        }
    }
}

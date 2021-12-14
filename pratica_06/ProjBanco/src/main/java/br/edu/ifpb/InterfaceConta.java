package br.edu.ifpb;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class InterfaceConta {
    public static void main(String[] args) throws ContaException {
        showGui();
    }

    public static void gui() {
        System.out.println(
            "Big Cesar Bank - 'Nós cuidamos do seu dinheiro como um filho!'\n\n" +
            "1 - Criar conta\n" +
            "2 - Sacar\n" +
            "3 - Depositar\n" +
            "4 - Extrato\n" +
            "5 - Checar saldo\n" +
            "6 - Exibir todas as informações\n" +
            "7 - Sair\n\n" +
            "  Digite um opção: "
        );
    }

    public static void showGui() throws ContaException {
        int cond = 0;
        Conta conta = null;
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        while (true) {
            try {
                gui();
                cond = input.nextInt();
                if (cond == 7) { break; }
                if (cond == 1) {
                    if (Objects.isNull(conta)) {
                        System.out.print("Digite seu nome: ");
                        String titular = input1.nextLine();
                        System.out.print("Digite seu ID: ");
                        int numero = input1.nextInt();
                        System.out.print("Digite um saldo inicial: ");
                        double saldo = input1.nextDouble();
                        conta = new Conta(titular, numero, saldo);
                    } else throw new ContaException();
                }
                if (!Objects.isNull(conta)) {
                    if (cond == 2) {
                        System.out.print("Digite um saldo para saque: ");
                        int numero = input1.nextInt();
                        conta.sacarSaldo(numero);
                    }
                    if (cond == 3) {
                        System.out.print("Digite um saldo para depositar: ");
                        int numero = input1.nextInt();
                        conta.depositarSaldo(numero);
                    }
                    if (cond == 4) { System.out.println(conta.getExtrato()); }
                    if (cond == 5) { System.out.printf("Saldo: R$ %.2f\n\n", conta.getSaldo()); }
                    if (cond == 6) { System.out.println(conta); }
                }
                else throw new ContaException("A conta não existe!");
            }
            catch (NumeroInvalidoException | QuantiaNegativaException | SaldoInsuficienteException | InputMismatchException e) {
                System.out.println();
                System.out.println("\n" +e.getMessage() + "\n");
                input.nextLine();
                input1.nextLine();
                conta = null;
            }
            catch (ContaException e) { System.out.println("\n" +e.getMessage() + "\n"); }
        }
    }
}
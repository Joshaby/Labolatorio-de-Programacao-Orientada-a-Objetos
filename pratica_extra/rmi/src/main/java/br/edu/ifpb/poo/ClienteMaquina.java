package br.edu.ifpb.poo;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Objects;
import java.util.Scanner;

public class ClienteMaquina {
    public static void exibirMenu() {
        System.out.print(
                "Servidor\n" +
                "1. Adicionar cliente\n" +
                "2. Remover cliente\n" +
                "3. Buscar cliente\n" +
                "4. Listar clientes\n" +
                "5. Sair\n" +
                " Digite um opção: "
        );
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean cond = true;
        MetodosClientes_IF localstub = null;
        while (cond) {
            try {
                System.out.print("Digite um ip: ");
                String ip = in.next();
                Registry registry = LocateRegistry.getRegistry(ip);
                cond = false;
                localstub = (MetodosClientes_IF) registry.lookup("Servidor");
            } catch (RemoteException | NotBoundException e) {
                System.err.println(e.getMessage());
            }
        }
        int cond1 = 0;
        while (cond1 != 5) {
            try {
                exibirMenu();
                cond1 = in.nextInt();
                if (cond1 == 1) {
                    System.out.print("Digite um número: ");
                    int num = in.nextInt();
                    System.out.print("Digite um nome: ");
                    String nome = in.next();
                    System.out.print("Digite um sobrenome: ");
                    String sobrenome = in.next();
                    if (localstub.adicionarCliente(num, nome, sobrenome)) {
                        System.out.println("Cliente adicionado!");
                    }
                    else System.out.println("Cliente não adicionado. Ele já existe!");
                }
                if (cond1 == 2) {
                    System.out.print("Digite um número: ");
                    int num = in.nextInt();
                    if (localstub.removerClientes(num)) {
                        System.out.println("Cliente removido!");
                    }
                    else System.out.println("Cliente não removido. Ele não existe no conjunto!");
                }
                if (cond1 == 3) {
                    System.out.print("Digite um número: ");
                    int num = in.nextInt();
                    System.out.println(localstub.buscarCliente(num));
                }
                if (cond1 == 4) {
                    System.out.println(localstub.listarClientes());
                }
            }
            catch (RemoteException | ClienteException e) {
                System.err.println(e.getMessage());
            }
        }
        localstub.setToTxt();
    }
}

package br.edu.ifpb;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        menu();
    }

    public static void interfaceMenu() {
        System.out.println(
                "Repositório Aeroportos\n\n" +
                "1. Listar aeroportos\n" +
                "2. Exibir aeroporto\n" +
                "3. Editar nome aeroporto\n" +
                "4. Sair\n\n" +
                " Digite uma opção: "
        );
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        boolean cond = true;
        repoAeroportosTXT_IF localstub = null;
        while (cond) {
            try {
                System.out.print("Digite um ip: ");
                String ip = in.next();
                Registry registry = LocateRegistry.getRegistry(ip);
                cond = false;
                localstub = (repoAeroportosTXT_IF) registry.lookup("Servidor");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            try {
                interfaceMenu();
                int ent = in.nextInt();
                if (ent == 1) {
                    System.out.print("Digite uma letra qualquer: ");
                    String letra = in.next();
                    System.out.println(localstub.listarAeroportoPor(letra));
                }
                if (ent == 2) {
                    System.out.print("Digite um ID de um aeroporto: ");
                    String id = in.next();
                    System.out.println(localstub.getNomeAeroporto(id));
                }
                if (ent == 3) {
                    System.out.print("Digite um ID de um aeroporto: ");
                    String id = in.next();
                    System.out.println("Digite um novo nome para o aeroporto: ");
                    String novoNome = in1.nextLine();
                    System.out.println(localstub.editarNomeAeroporto(id, novoNome));
                }
                if (ent == 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

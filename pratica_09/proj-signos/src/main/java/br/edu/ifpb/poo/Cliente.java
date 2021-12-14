package br.edu.ifpb.poo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String ip = "";
        Scanner in = new Scanner(System.in);
        ip = in.next();
        while(true) {
            try {
                Registry registry = LocateRegistry.getRegistry(ip);
                ServidorDeSignos localStub = (ServidorDeSignos) registry.lookup("Signos");
                System.out.printf("Signos disponíveis: %s\n", localStub.getSignosDisponiveis());
                System.out.print("Digite um signo: ");
                String s = in.next();
                System.out.println(localStub.getMensagemSigno(s));
            }
            catch (Exception e) {
                System.err.println("ERROR");
            }
        }
    }
}
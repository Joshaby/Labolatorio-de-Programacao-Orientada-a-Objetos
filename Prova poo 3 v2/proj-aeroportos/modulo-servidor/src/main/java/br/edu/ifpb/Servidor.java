package br.edu.ifpb;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main(String[] args) {
        try {
            repoAeroportosTXT rpat = new repoAeroportosTXT();
            repoAeroportosTXT_IF stub = (repoAeroportosTXT_IF) UnicastRemoteObject.exportObject(rpat, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Servidor", stub);
            System.out.println("Servidor ativado!");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
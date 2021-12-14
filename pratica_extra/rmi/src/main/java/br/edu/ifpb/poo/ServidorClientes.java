package br.edu.ifpb.poo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorClientes {
    public static void main(String[] args) {
        try {
            Servidor s = new Servidor("Servidor de Clientes");
            MetodosClientes_IF stub = (MetodosClientes_IF) UnicastRemoteObject.exportObject(s, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Servidor", stub);
            System.out.println("Servidor ativado...");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

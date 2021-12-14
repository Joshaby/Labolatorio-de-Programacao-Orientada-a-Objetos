package br.edu.ifpb.poo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServidorDeSignos sds = new ServidorDeSignos();
            ServidorDeSignos stub = (ServidorDeSignos) UnicastRemoteObject.exportObject(sds, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Signos", stub);
            System.err.println("Servidor ativado...");
        }
        catch(Exception e) {
            System.err.println("ERROR");
        }
    }
}
package br.edu.ifpb.poo;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MetodosClientes_IF extends Remote {
    boolean adicionarCliente(int num, String nome, String sobrenome) throws RemoteException;
    boolean removerClientes(int num) throws RemoteException;
    String buscarCliente(int num) throws RemoteException, ClienteException;
    String listarClientes() throws RemoteException;
    void txtToSet() throws RemoteException, IOException;
    void setToTxt() throws RemoteException, IOException;
}

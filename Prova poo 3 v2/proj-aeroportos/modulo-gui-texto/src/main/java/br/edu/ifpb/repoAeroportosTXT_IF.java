package br.edu.ifpb;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface repoAeroportosTXT_IF extends Remote {
    String listarAeroportoPor(String letra) throws RemoteException, IOException;
    String getNomeAeroporto(String id) throws RemoteException, IOException;
    String editarNomeAeroporto(String id, String novoNome) throws RemoteException, IOException;
    void txtToMap() throws RemoteException, IOException;
    void mapToTxt() throws RemoteException, IOException;
}

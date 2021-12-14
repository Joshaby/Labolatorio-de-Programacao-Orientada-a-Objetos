import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ObjetosRemotos_IF extends Remote {
    String getMensagemSigno(String signo) throws RemoteException;
    String getSignosDisponiveis() throws RemoteException;
}

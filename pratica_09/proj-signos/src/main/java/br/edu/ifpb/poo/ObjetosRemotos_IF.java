package br.edu.ifpb.poo;

import java.rmi.Remote;
import java.util.List;

public interface ObjetosRemotos_IF extends Remote {
    String getMensagemSigno(String signo);
    String getSignosDisponiveis();
}

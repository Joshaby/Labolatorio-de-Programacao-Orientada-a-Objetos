package br.edu.ifpb.poo;

public class ClienteException extends Exception {
    public ClienteException() { super("Cliente não existe!"); }
    public ClienteException(String message) { super(message); }
}

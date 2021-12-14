package br.edu.ifpb;

public class ContaException extends Exception {
    public ContaException() { super("Conta já existe!"); }
    public ContaException(String message) { super(message); }
}

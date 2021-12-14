package br.edu.ifpb;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
    public SaldoInsuficienteException() {
        super("Saldo insuficiente!");
    }
}
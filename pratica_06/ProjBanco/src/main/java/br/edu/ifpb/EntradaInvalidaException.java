package br.edu.ifpb;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String message) {
        super(message);
    }
    public EntradaInvalidaException() {
        super("Entrada inválida!");
    }
}
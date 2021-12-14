package br.edu.ifpb;

public class NumeroInvalidoException extends Exception {
    public NumeroInvalidoException(String message) {
        super(message);
    }
    public NumeroInvalidoException() {
        super("Número inválido!");
    }
}
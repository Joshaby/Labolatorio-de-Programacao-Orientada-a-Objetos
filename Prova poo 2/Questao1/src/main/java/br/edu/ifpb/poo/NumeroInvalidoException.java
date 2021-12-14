package br.edu.ifpb.poo;

public class NumeroInvalidoException extends Exception {
    public NumeroInvalidoException(String message) {
        super(message);
    }
    public NumeroInvalidoException() {
        super("Número inválido!");
    }
}
package br.edu.ifpb.poo;

import java.util.InputMismatchException;

public class EntradaInvalidaException extends NumberFormatException {
    public EntradaInvalidaException(String message) {
        super(message);
    }
    public EntradaInvalidaException() {
        super("Entrada Inválida");
    }
}

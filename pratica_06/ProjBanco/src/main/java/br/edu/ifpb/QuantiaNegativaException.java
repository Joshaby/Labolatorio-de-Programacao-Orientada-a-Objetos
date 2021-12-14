package br.edu.ifpb;

public class QuantiaNegativaException extends Exception {
    public QuantiaNegativaException(String message) {
        super(message);
    }
    public QuantiaNegativaException() {
        super("Quantia negativa digitada!");
    }
}
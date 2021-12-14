package br.ifpb.edu;

public class TestCalculadora {
    public static void main(String[] args) {
        Calculadora c1 = new Calculadora(10, 90);
        System.out.println("Soma: " + c1.soma());
        System.out.println("Subtração: " + c1.subtrair());
        System.out.println("Multiplicação: " + c1.multiplicar());
        System.out.println("Divisão: " + c1.dividir());
    }
}
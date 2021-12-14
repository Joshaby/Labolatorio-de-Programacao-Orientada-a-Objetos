package br.ifpb.edu;

public class Calculadora
{
    private double gt = 0;
    public double soma(double num1, double num2) {
        gt =  num1 + num2;
        return gt;
    }
    public double subtrair(double num1, double num2) {
        gt =  num1 - num2;
        return gt;
    }
    public double multiplicar(double num1, double num2) {
        gt =  num1 * num2;
        return gt;
    }
    public double dividir(double num1, double num2) {
        gt =  num1 / num2;
        return gt;
    }
    public double GT() { return gt; }
}
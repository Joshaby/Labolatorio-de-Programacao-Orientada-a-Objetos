package br.ifpb.edu;

public class Calculadora {
    private double num;
    private double num1;
    public Calculadora() {
        setNum(0.0);
        setNum1(0.0);
    }
    public Calculadora(double num, double num1) {
        setNum(num);
        setNum1(num1);
    }
    public void setNum(double num) { this.num = num; }
    public void setNum1(double num1) { this.num1 = num1; }
    public double soma() { return num + num1; }
    public double subtrair() { return num - num1; }
    public double multiplicar() { return num * num1; }
    public double dividir() { return num / num1; }

}

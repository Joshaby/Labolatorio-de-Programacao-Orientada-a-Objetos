package br.edu.ifpb;

public class Conta {
    private static int numeroG = 1;
    private int numero = Conta.numeroG ++;
    private String titular;
    private double saldo;
    private String extrato = "\tExtrato:\n\n";
    public Conta() {
        setTitular("sem nome");
        setSaldo(0.0);
    }
    public Conta(int numero, String titular, double saldo) {
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo);
    }
    public boolean setNumero(int numero) {
        boolean cond = true;
        if (numero >= 0) {
            this.numero = numero; 
        }
        else cond = false;
        return cond;
    }
    public boolean setSaldo(double saldo) { 
        boolean cond = true;
        if (saldo >= 0) {
            this.saldo = saldo; 
        }
        else cond = false;
        return cond;
    }
    public void setTitular(String titular) { this.titular = titular; }
    public int getNumero() { return numero; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
    public boolean depositar(double quantia) {
        boolean cond = true;
        if (quantia >= 0) {
            saldo += quantia;
            extrato += String.format("\t\tDepósito feito de R$ %.2f\n", quantia);
        }
        else cond = false;
        return cond; 
    }
    public boolean sacar(double quantia) {
        boolean cond = true;
        if (quantia <= saldo && saldo != 0) {
            double nova_Quantia = descontar_CPMF(quantia);
            saldo -= nova_Quantia;
            extrato += String.format("\t\tSaque feito de R$ %.2f (Com desconto de CPMF)\n", nova_Quantia);
        }
        else cond = false;
        return cond;
    }
    public String extrato() { return this.extrato; }
    private double calcular_CPMF(double quantia) { return quantia * 0.01; }
    private double descontar_CPMF(double quantia) { return quantia - calcular_CPMF(quantia); }
    @Override
    public String toString() {
        return String.format("\tConta:\n\n" + 
                             "\tNúmero: %d\n" +
                             "\tTitular: %s\n" + 
                             "\tSaldo: R$ %.2f\n\n" + 
                             "%s\n", numero, titular, saldo, extrato);
    }
}
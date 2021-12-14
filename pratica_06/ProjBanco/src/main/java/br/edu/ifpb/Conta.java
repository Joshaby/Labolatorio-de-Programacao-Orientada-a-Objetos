package br.edu.ifpb;

public class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private String extrato;

    public Conta(String titular, int numero, double saldo) throws NumeroInvalidoException, QuantiaNegativaException {
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
        setExtrato(String.format("Conta criada!\nForam depositados R$ %.2f", saldo));
    }
    public Conta() throws NumeroInvalidoException, QuantiaNegativaException {
        this("--sem nome--", 0, 0);
        setExtrato(String.format("Conta criada!\nForam depositados R$ %.2f", 0.0));
    }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) throws NumeroInvalidoException{
        if (numero < 0) throw new NumeroInvalidoException();
        this.numero = numero;
    }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo2) throws QuantiaNegativaException {
        if (saldo2 < 0) throw new QuantiaNegativaException();
        this.saldo = saldo2;
    }

    public String getExtrato() { return extrato; }
    public void setExtrato(String extrato) { this.extrato = extrato; }
    
    public void sacarSaldo(double quantia) throws QuantiaNegativaException, SaldoInsuficienteException {
        if (quantia < 0) throw new QuantiaNegativaException("Quantia negativa ou tentativa de saque 0 reais");
        if (getSaldo() < 0) throw new SaldoInsuficienteException();
        if (quantia > getSaldo()) throw new QuantiaNegativaException("A quantia é maior do que o saldo!");
        setSaldo(getSaldo() - quantia);
        String extrato = String.format("Saque feito de %.2f\nNovo saldo: R$ %s\n",
            quantia, getSaldo());
            setExtrato(getExtrato() + extrato);
    }

    public void depositarSaldo(double quantia) throws QuantiaNegativaException {
        if (quantia <= 0) throw new QuantiaNegativaException("Quantia negativa ou tentativa de depositar 0 reais");
        setSaldo(getSaldo() + quantia);
        String extrato = String.format("Deposito feito de %.2f\nNovo saldo: R$ %.2f\n",
            quantia, getSaldo());
        setExtrato(getExtrato() + extrato);
    }

    @Override
    public String toString() {
        return String.format(
            "\nTitular: %s\nNúmero: %s\nSaldo: R$ %s\nExtrato: %s\n",
            getTitular(), getNumero(), getSaldo(), getExtrato()
        );
    }
}
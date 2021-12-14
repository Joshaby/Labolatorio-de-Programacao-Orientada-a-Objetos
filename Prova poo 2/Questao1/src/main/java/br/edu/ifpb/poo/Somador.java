package br.edu.ifpb.poo;

import java.util.InputMismatchException;

public final class Somador {
    public static int soma(String[] num) {
        int sum = 0;
        for (String c : num) {
            try {
                int AUX = Integer.parseInt(c);
                if (AUX < 0) throw new NumeroInvalidoException(String.format("Erro: A entrada %d é inválida. Será desprezada.", AUX));
                else sum += AUX;
            } catch (NumeroInvalidoException e) {
                System.err.println(e.getMessage());
            }
            catch (NumberFormatException e) {
                System.err.printf("Erro: A entrada %s é inválida. Será desprezada.\n", c);
            }
        }
        return sum;
    }
}

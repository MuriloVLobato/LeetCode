package org.problem;

// Importamos a classe Scanner para ler a entrada do usuário
import java.util.Scanner;

public class Main {

    private int translate(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int cur = translate(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int next = translate(s.charAt(i));

            if (cur < next)
                sum -= cur;
            else
                sum += cur;

            cur = next;
        }

        sum += cur;

        return sum;
    }


    public static void main(String[] args) {
        Main conversor = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número romano para conversão (ex: MCMXCIV):");
        String numeroRomano = scanner.nextLine().toUpperCase();

        int resultado = conversor.romanToInt(numeroRomano);

        System.out.println("O número romano '" + numeroRomano + "' é igual a " + resultado + " em inteiro.");

        scanner.close();
    }
}
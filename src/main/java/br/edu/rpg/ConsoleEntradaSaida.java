package br.edu.rpg;

import java.util.Scanner;

public final class ConsoleEntradaSaida implements EntradaSaida {
    private final Scanner scanner = new Scanner(System.in);
    @Override public void escrever(String mensagem) { System.out.println(mensagem); }
    @Override public String lerTexto(String mensagem) {
        System.out.print(mensagem); return scanner.nextLine().trim();
    }
    @Override public int lerOpcao(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                if (valor >= minimo && valor <= maximo) return valor;
            } catch (NumberFormatException ignored) { }
            escrever("Opção inválida. Escolha entre " + minimo + " e " + maximo + ".");
        }
    }
}
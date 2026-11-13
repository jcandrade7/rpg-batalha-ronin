package br.edu.rpg;

public interface EntradaSaida {
    void escrever(String mensagem);
    int lerOpcao(String mensagem, int minimo, int maximo);
    String lerTexto(String mensagem);
}
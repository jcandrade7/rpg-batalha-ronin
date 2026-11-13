package br.edu.rpg;

public final class Main {
    private Main() { }
    public static void main(String[] args) {
        EntradaSaida io = new ConsoleEntradaSaida();
        io.escrever("=== CAMINHO DO GUERREIRO ===");
        String nome = io.lerTexto("Nome do herói: ");
        if (nome.isBlank()) nome = "Akira";
        io.escrever("1. Samurai  2. Mago");
        int classe = io.lerOpcao("Escolha: ", 1, 2);
        Personagem heroi = classe == 1 ? new Samurai(nome) : new Mago(nome);
        ((Heroi) heroi).getInventario().adicionar(new PocaoCura(45));
        new Combate(io, new EstrategiaRonin()).iniciar(heroi, new Ronin());
    }
}
package br.edu.rpg;

public final class Combate {
    private final EntradaSaida io;
    private final EstrategiaInimigo estrategia;
    public Combate(EntradaSaida io, EstrategiaInimigo estrategia) {
        this.io = io; this.estrategia = estrategia;
    }
    public void iniciar(Personagem heroi, Personagem inimigo) {
        io.escrever("\n=== BATALHA: " + heroi.getNome() + " vs " + inimigo.getNome() + " ===");
        while (heroi.estaVivo() && inimigo.estaVivo()) {
            io.escrever("\n" + heroi.status()); io.escrever(inimigo.status());
            io.escrever("1. Atacar  2. Habilidade  3. Usar poção");
            int opcao = io.lerOpcao("> ", 1, 3);
            int dano = 0;
            if (opcao == 1) dano = heroi.atacar(inimigo);
            else if (opcao == 2) dano = heroi.usarHabilidade(inimigo);
            else {
                Heroi h = (Heroi) heroi;
                if (h.getInventario().listar().isEmpty()) { io.escrever("Inventário vazio."); continue; }
                if (h.getInventario().usar(0, heroi)) io.escrever("Poção usada.");
                else { io.escrever("A poção não foi necessária."); continue; }
            }
            if (opcao != 3) io.escrever("Você causou " + dano + " de dano.");
            if (!inimigo.estaVivo()) break;
            int danoInimigo = estrategia.agir(inimigo, heroi);
            io.escrever("Ronin causou " + danoInimigo + " de dano.");
        }
        io.escrever(heroi.estaVivo() ? "\nVitória! O Ronin foi derrotado." : "\nDerrota. Sua jornada terminou.");
    }
}
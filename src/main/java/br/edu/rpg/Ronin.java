package br.edu.rpg;

public final class Ronin extends Personagem {
    public Ronin() { super("Ronin", 150, 22, 8); }
    @Override public int usarHabilidade(Personagem alvo) {
        return causarDano(alvo, getAtaqueBase() + 12); // Golpe Desonrado
    }
}
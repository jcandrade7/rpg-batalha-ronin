package br.edu.rpg;

public final class Samurai extends Personagem implements Heroi {
    private final Inventario inventario = new Inventario();
    public Samurai(String nome) { super(nome, 130, 25, 10); }
    @Override public int usarHabilidade(Personagem alvo) {
        return causarDano(alvo, getAtaqueBase() + 15); // Corte da Lua
    }
    @Override public Inventario getInventario() { return inventario; }
}
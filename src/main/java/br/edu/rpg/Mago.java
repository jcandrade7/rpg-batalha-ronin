package br.edu.rpg;

public final class Mago extends Personagem implements Heroi {
    private final Inventario inventario = new Inventario();
    private int mana = 60;
    public Mago(String nome) { super(nome, 90, 18, 5); }
    @Override public int usarHabilidade(Personagem alvo) {
        if (mana < 20) return atacar(alvo);
        mana -= 20; return causarDano(alvo, getAtaqueBase() + 25); // Bola de Fogo
    }
    public int getMana() { return mana; }
    @Override public Inventario getInventario() { return inventario; }
    @Override public String status() { return super.status() + " | Mana: " + mana + "/60"; }
}
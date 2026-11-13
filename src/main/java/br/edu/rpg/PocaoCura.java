package br.edu.rpg;

public final class PocaoCura implements Item {
    private final int cura;
    public PocaoCura(int cura) { this.cura = cura; }
    @Override public String nome() { return "Poção de Cura (" + cura + ")"; }
    @Override public boolean usar(Personagem personagem) { return personagem.curar(cura) > 0; }
}
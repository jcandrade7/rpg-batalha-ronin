package br.edu.rpg;

import java.util.Random;

public final class EstrategiaRonin implements EstrategiaInimigo {
    private final Random random = new Random();
    @Override public int agir(Personagem inimigo, Personagem heroi) {
        return random.nextInt(100) < 30 ? inimigo.usarHabilidade(heroi) : inimigo.atacar(heroi);
    }
}
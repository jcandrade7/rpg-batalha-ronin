package br.edu.rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Inventario {
    private final List<Item> itens = new ArrayList<>();
    public void adicionar(Item item) { itens.add(item); }
    public List<Item> listar() { return Collections.unmodifiableList(itens); }
    public boolean usar(int indice, Personagem personagem) {
        if (indice < 0 || indice >= itens.size()) return false;
        Item item = itens.get(indice);
        if (!item.usar(personagem)) return false;
        itens.remove(indice); return true;
    }
}
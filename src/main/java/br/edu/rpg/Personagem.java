package br.edu.rpg;

public abstract class Personagem {
    private final String nome;
    private final int vidaMaxima;
    private int vida;
    private final int ataque;
    private int defesa;

    protected Personagem(String nome, int vida, int ataque, int defesa) {
        if (nome == null || nome.isBlank() || vida <= 0 || ataque < 0 || defesa < 0)
            throw new IllegalArgumentException("Atributos inválidos.");
        this.nome = nome; this.vidaMaxima = vida; this.vida = vida;
        this.ataque = ataque; this.defesa = defesa;
    }
    public abstract int usarHabilidade(Personagem alvo);
    public int atacar(Personagem alvo) { return alvo.receberDano(ataque); }
    public int receberDano(int danoBruto) {
        int dano = Math.max(1, danoBruto - defesa);
        vida = Math.max(0, vida - dano); return dano;
    }
    public int curar(int quantidade) {
        int antes = vida; vida = Math.min(vidaMaxima, vida + Math.max(0, quantidade)); return vida - antes;
    }
    protected int causarDano(Personagem alvo, int danoBruto) { return alvo.receberDano(danoBruto); }
    protected int getAtaqueBase() { return ataque; }
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getDefesa() { return defesa; }
    public boolean estaVivo() { return vida > 0; }
    public String status() { return nome + " | Vida: " + vida + "/" + vidaMaxima; }
}
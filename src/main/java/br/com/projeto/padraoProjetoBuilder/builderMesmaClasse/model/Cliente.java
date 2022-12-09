package br.com.projeto.padraoProjetoBuilder.builderMesmaClasse.model;

public class Cliente {

    private String nome;
    private boolean vip;

    public Cliente(String nome, boolean vip) {
        this.nome = nome;
        this.vip = vip;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVip() {
        return this.vip;
    }

    public boolean getVip() {
        return this.vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}

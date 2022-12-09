package br.com.projeto.padraoProjetoBuilder.builderMesmaClasse.model;

public class Vendedor {
    
    private int codigo;
    private String nome;

    public Vendedor(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

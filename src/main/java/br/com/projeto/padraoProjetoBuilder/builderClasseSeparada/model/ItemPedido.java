package br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model;

import java.math.BigDecimal;

public class ItemPedido {

    private String nome;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public ItemPedido(String nome, Integer quantidade, BigDecimal valorUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}

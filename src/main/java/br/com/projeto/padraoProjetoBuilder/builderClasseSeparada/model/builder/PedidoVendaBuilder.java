package br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model.builder;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model.Cliente;
import br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model.ItemPedido;
import br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model.PedidoVenda;
import br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model.Vendedor;

public class PedidoVendaBuilder {

    private PedidoVenda instancia;

    public PedidoVendaBuilder() {
        this.instancia = new PedidoVenda();
    }

    public PedidoVendaBuilder comNumero(String numero) {
        this.instancia.setNumero(numero);
        return this;
    }
    
    public PedidoVendaBuilder comClienteVip(String nome) {
        definirCliente(nome, Boolean.TRUE);
        return this;
    }

    public PedidoVendaBuilder comClienteNormal(String nome) {
        definirCliente(nome, Boolean.FALSE);
        return this;
    }

    private void definirCliente(String nome, boolean vip) {
        Cliente cliente = new Cliente(nome, vip);
        this.instancia.setCliente(cliente);
    }
    
    public PedidoVendaBuilder comItemPedido(String nome, Integer quantidade, BigDecimal valorUnitario) {
        ItemPedido itemPedido = new ItemPedido(nome, quantidade, valorUnitario);

        if (this.instancia.getItensPedido() == null) {
            this.instancia.setItensPedido(new ArrayList<ItemPedido>());
        }

        this.instancia.getItensPedido().add(itemPedido);
        return this;
    }
    
    public PedidoVendaBuilder comVendedor(int codigo, String nome) {
        Vendedor vendedor = new Vendedor(codigo, nome);
        this.instancia.setVendedor(vendedor);
        return this;
    }

    public PedidoVenda construir() {
        return this.instancia;
    }

}

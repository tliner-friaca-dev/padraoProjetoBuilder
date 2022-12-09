package br.com.projeto.padraoProjetoBuilder.builderClasseSeparada.model;

import java.math.BigDecimal;
import java.util.List;

public class PedidoVenda {
    
    private static final String DESCONTO_10_PORCENTO = "0.90";
    
    private String numero;
    private Cliente cliente;
    private List<ItemPedido> itensPedido;
    private Vendedor vendedor;

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return this.itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public BigDecimal getValorTotal() {

        BigDecimal valorTotal = BigDecimal.ZERO;

        if (!itensPedido.isEmpty()) {
            for (ItemPedido itemPedido : itensPedido) {
                valorTotal = valorTotal.add(itemPedido.getValorUnitario().multiply(new BigDecimal(itemPedido.getQuantidade())));
            }
        }

        // Se cliente é vip = recebe 10% de desconto
        if (cliente.isVip()) {
            valorTotal = valorTotal.multiply(new BigDecimal(DESCONTO_10_PORCENTO));
        }

        return valorTotal;

    }

}
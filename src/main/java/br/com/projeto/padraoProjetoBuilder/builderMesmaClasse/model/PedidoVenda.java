package br.com.projeto.padraoProjetoBuilder.builderMesmaClasse.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PedidoVenda {
    
    private static final String DESCONTO_10_PORCENTO = "0.90";
    
    private String numero;
    private Cliente cliente;
    private ArrayList<ItemPedido> itensPedido;
    private Vendedor vendedor;

    private PedidoVenda(String numero, Cliente cliente, ArrayList<ItemPedido> itensPedido, Vendedor vendedor) {
        this.numero = numero;
        this.cliente = cliente;
        this.itensPedido = itensPedido;
        this.vendedor = vendedor;
    }

    public static class PedidoVendaBuilder {

        private String numero;
        private Cliente cliente;
        private ArrayList<ItemPedido> itensPedido;
        private Vendedor vendedor;

        public PedidoVendaBuilder comNumero(String numero){
            this.numero = numero;
            return this;
        }

        public PedidoVendaBuilder comClienteVip(String nome){
            definirCliente(nome, Boolean.TRUE);
            return this;
        }

        public PedidoVendaBuilder comClienteNormal(String nome){
            definirCliente(nome, Boolean.FALSE);
            return this;
        }

        private void definirCliente(String nome, boolean vip) {
            Cliente cliente = new Cliente(nome, vip);
            this.cliente = cliente;
        }
        
        public PedidoVendaBuilder comItemPedido(String nome, Integer quantidade, BigDecimal valorUnitario){
            ItemPedido itemPedido = new ItemPedido(nome, quantidade, valorUnitario);

            if (this.itensPedido == null) {
                this.itensPedido = new ArrayList<ItemPedido>();
            }

            this.itensPedido.add(itemPedido);
            return this;
        }
        
        public PedidoVendaBuilder comVendedor(int codigo, String nome){
            Vendedor vendedor = new Vendedor(codigo, nome);
            this.vendedor = vendedor;
            return this;
        }

        public PedidoVenda construir(){
            return new PedidoVenda(numero, cliente, itensPedido, vendedor);
        }
    }

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

    public ArrayList<ItemPedido> getItensPedido() {
        return this.itensPedido;
    }

    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
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
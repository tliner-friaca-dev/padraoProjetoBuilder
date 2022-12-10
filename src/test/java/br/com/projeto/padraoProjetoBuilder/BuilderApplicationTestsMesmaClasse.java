package br.com.projeto.padraoProjetoBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.padraoProjetoBuilder.builderMesmaClasse.model.PedidoVenda;

@SpringBootTest
@DisplayName("BuilderApplicationTestsMesmaClasse")
class BuilderApplicationTestsMesmaClasse {

	@Test
	void calcularValorClienteNormal_quandoSucesso() {

		PedidoVenda pedidoVenda = new PedidoVenda.PedidoVendaBuilder()
									.comClienteNormal("Cliente Ricardo")
									.comItemPedido("Caneta", 2, new BigDecimal("1"))
									.comItemPedido("Lapis", 2, new BigDecimal("2"))
									.comItemPedido("Borraca", 2, new BigDecimal("3"))
									.comVendedor(888, "Vendedor Paulo")
									.comNumero("999")
									.construir();

		BigDecimal valorTotal = pedidoVenda.getValorTotal();

		assertEquals(new BigDecimal("12"), valorTotal);

	}

	@Test
	void calcularValorClienteVIP_quandoSucesso() {
/*
		PedidoVenda pedidoVenda = new PedidoVendaBuilder()
									.comClienteVip("Cliente Ricardo")
									.comItemPedido("Caneta", 2, new BigDecimal("1"))
									.comVendedor(888, "Vendedor Paulo")
									.comNumero("999")
									.construir();
*/
		
		PedidoVenda pedidoVenda = new PedidoVenda.PedidoVendaBuilder()
									.comClienteVip("Cliente Ricardo")
									.comItemPedido("Caneta", 2, new BigDecimal("1"))
									.comVendedor(888, "Vendedor Paulo")
									.comNumero("999")
									.construir();

		BigDecimal valorTotal = pedidoVenda.getValorTotal();

		assertEquals(new BigDecimal("1.80"), valorTotal);

	}

}

package br.com.alura.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPagoEvent {

    private LocalDateTime data;

    private BigDecimal valorTotal;

    private Long idCliente;

    private String cpfCliente;

    private String nomeCliente;

    private Long pedidoId;

    private StatusPedido status;

    private String endereco;

    private List<ItemDePedidoEvent> itemDePedidoEvents;

    static public PedidoPagoEvent converter(PedidoGeradoEvent event) {

        return new PedidoPagoEvent(event.getData(), event.getValorTotal(), event.getIdCliente(), event.getCpfCliente(), event.getNomeCliente(), event.getPedidoId(), StatusPedido.PAGO, event.getEndereco(), event.getItemDePedidoEvents());

    }

}

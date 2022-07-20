package br.com.alura.pagamento;


import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static br.com.alura.pagamento.PedidoPagoEvent.converter;

@Service
@RequiredArgsConstructor
public class PedidoGeradoEventProcessor {

    private final PagamentoRepository pagamentoRepository;

    private final PedidoStreamConfig.PedidoPagoSource pedidoPagoSource;

    @StreamListener(PedidoStreamConfig.PedidoGeradoSink.PEDIDO_GERADO_TOPIC)
    void pedidoGerado(PedidoGeradoEvent pedidoGeradoEvent) {

        Long pedidoId = pedidoGeradoEvent.getPedidoId();
        String cpfCliente = pedidoGeradoEvent.getCpfCliente();
        BigDecimal valorTotal = pedidoGeradoEvent.getValorTotal();

        Pagamento pagamento = pagamentoRepository.save(new Pagamento(valorTotal, cpfCliente, pedidoId));
        PedidoPagoEvent pedidoPagoEvent = converter(pedidoGeradoEvent);

        Message<PedidoPagoEvent> message = MessageBuilder.withPayload(pedidoPagoEvent).build();
        pedidoPagoSource.pedidoPago().send(message);

    }


}

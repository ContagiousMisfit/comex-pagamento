package br.com.alura.pagamento;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding({PedidoStreamConfig.PedidoGeradoSink.class, PedidoStreamConfig.PedidoPagoSource.class})
@Configuration
public class PedidoStreamConfig {

    interface PedidoGeradoSink {

        String PEDIDO_GERADO_TOPIC = "pedidoGerado";

        @Input
        SubscribableChannel pedidoGerado();

    }
    public interface PedidoPagoSource {

        @Output
        MessageChannel pedidoPago();

    }
}

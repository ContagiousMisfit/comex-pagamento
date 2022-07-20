package br.com.alura.pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDePedidoEvent {

    private Long id;

    private String nomeProduto;

    private String categoriaProduto;

    private long quantidade;

    private BigDecimal precoUnitario;

}

package br.com.alura.pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Pagamento findByPedidoId(Long id);

}

package br.com.rafashe.gerenciador_pedidos.repository;

import br.com.rafashe.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByDataIsNull();

    List<Pedido> findByDataIsNotNull();

    List<Pedido> findByDataAfter(LocalDate dataAfter);

    List<Pedido> findByDataBefore(LocalDate dataBefore);

    List<Pedido> findByDataBetween(LocalDate dataAfter, LocalDate dataBefore);
}

package br.com.rafashe.gerenciador_pedidos.repository;

import br.com.rafashe.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);

    @Query("SELECT c FROM Categoria c WHERE (SELECT COUNT(p) FROM c.produtos p) >= 3")
    List<Categoria> categoriasComMaisDe3Produtos();
}

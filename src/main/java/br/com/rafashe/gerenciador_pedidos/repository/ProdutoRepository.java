package br.com.rafashe.gerenciador_pedidos.repository;

import br.com.rafashe.gerenciador_pedidos.model.Categoria;
import br.com.rafashe.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeEquals(String nome);

    List<Produto> findByCategoriaEquals(Categoria categoria);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByPrecoLessThan(double preco);

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByNomeContainingIgnoreCaseOrPrecoLessThan(String nome, double preco);

    List<Produto> findTop3ByOrderByPrecoDesc();

    List<Produto> findTop5ByOrderByPrecoAsc();

    List<Produto> findByCategoriaNome(String papelaria);

    List<Produto> findByCategoriaNomeEqualsOrderByPrecoAsc(String papelaria);

    List<Produto> findByCategoriaNomeEqualsOrderByPrecoDesc(String papelaria);

    int countByCategoriaNome(String categoria);

    int countByPrecoGreaterThan(double preco);

    List<Produto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoria);
}

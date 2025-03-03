package br.com.rafashe.gerenciador_pedidos.repository;

import br.com.rafashe.gerenciador_pedidos.model.Categoria;
import br.com.rafashe.gerenciador_pedidos.model.Pedido;
import br.com.rafashe.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeEquals(String nome);

    //Consultas DerivedQuery
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

    //Consultas JPQL
    @Query("SELECT p FROM Produto p WHERE p.preco >= :preco")
    List<Produto> produtosComPrecoMaiorQueUmValor(double preco);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> produtosOrdenadosPeloPrecoCrescente();

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> produtosOrdenadosPeloPrecoDecrescente();

    @Query("SELECT p FROM Produto p WHERE p.nome ILIKE :letra%")
    List<Produto> produtosQueComecamComALetra(String letra);

    @Query("SELECT AVG(p.preco) FROM Produto p")
    double mediaDePrecos();

    @Query("SELECT MAX(p.preco) FROM Produto p JOIN p.categoria c WHERE c.nome = :nomeCategoria")
    double precoMaximoPorCategoria(String nomeCategoria);

    @Query("SELECT COUNT(p) FROM Produto p JOIN p.categoria c WHERE c.nome = :nomeCategoria")
    int numeroDeProdutosPorCategoria(String nomeCategoria);

    @Query("SELECT p FROM Produto p JOIN p.categoria c WHERE p.nome = :nome OR c.nome = :nomeCategoria")
    List<Produto> produtosfiltradosPorNomeOuPorCategoria(String nome, String nomeCategoria);

    @Query(value = "SELECT * FROM produtos ORDER BY preco DESC LIMIT 3", nativeQuery = true)
    List<Produto> os3ProdutosMaisCaros();
}

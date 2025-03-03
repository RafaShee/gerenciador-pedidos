package br.com.rafashe.gerenciador_pedidos.principal;

import br.com.rafashe.gerenciador_pedidos.model.Categoria;
import br.com.rafashe.gerenciador_pedidos.model.Fornecedor;
import br.com.rafashe.gerenciador_pedidos.model.Pedido;
import br.com.rafashe.gerenciador_pedidos.model.Produto;
import br.com.rafashe.gerenciador_pedidos.repository.CategoriaRepository;
import br.com.rafashe.gerenciador_pedidos.repository.FornecedorRepository;
import br.com.rafashe.gerenciador_pedidos.repository.PedidoRepository;
import br.com.rafashe.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ProdutoRepository repositorioProduto;
    private PedidoRepository repositorioPedido;
    private CategoriaRepository repositorioCategoria;
    private FornecedorRepository repositorioFornecedor;
    private List<Produto> produtos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    private Produto produto;
    private Pedido pedido;
    private Categoria categoria;

    public Principal(ProdutoRepository repositorioProduto, CategoriaRepository repositorioCategoria, PedidoRepository repositorioPedido, FornecedorRepository repositorioFornecedor) {
        this.repositorioProduto = repositorioProduto;
        this.repositorioCategoria = repositorioCategoria;
        this.repositorioPedido = repositorioPedido;
        this.repositorioFornecedor = repositorioFornecedor;
    }

    public void exibeMenu() {
        //menu
        /*var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    1 - Cadastrar produto
                    2 - Cadastrar categoria
                    3 - Cadastrar pedido
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    cadastrarCategoria();
                    break;
                case 3:
                    cadastrarPedido();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }*/
        consultasJPQL();
       /* produto = buscarProdutoPeloNome("corretivo");
        pedidos.add(buscarPedidoPelaData("2025-02-28"));
        associarProdutoPedido(produto, pedidos);*/
    }

    private <T> Object buscarItem(T item, String textoDeBusca) {
        if (item instanceof Produto) {

            //Pegando a lista de produtos cadastrados no banco
            List<Produto> produtos = new ArrayList<>();
            produtos = repositorioProduto.findAll();

            //Buscando e salvando o produto pelo nome
            Optional<Produto> produto = produtos.stream()
                    .filter(p -> p.getNome().toLowerCase().contains(textoDeBusca)).findFirst();
            if(produto.isPresent()) {
                return produto.get();
            }else {
                System.out.println("meh");
            }
        } else if (item instanceof Categoria) {
            //Pegando a lista de categorias cadastradas no banco
            List<Categoria> categorias = new ArrayList<>();
            categorias = repositorioCategoria.findAll();

            //buscando e salvando a categoria pelo nome
            Optional<Categoria> categoria = categorias.stream()
                    .filter(c -> c.getNome().toLowerCase().contains(textoDeBusca)).findFirst();
            if (categoria.isPresent()) {
                return  categoria.get();
            }else {
                System.out.println("meh");
            }
        }else if (item instanceof Fornecedor) {
            //Pegando a lista de fornecedores cadastrados no banco
            List<Fornecedor> fornecedores = new ArrayList<>();
            fornecedores = repositorioFornecedor.findAll();

            //buscando e salvando o fornecedor pelo nome
            Optional<Fornecedor> fornecedor = fornecedores.stream()
                    .filter(c -> c.getNome().toLowerCase().contains(textoDeBusca)).findFirst();
            if (fornecedor.isPresent()) {
                return  fornecedor.get();
            }else {
                System.out.println("meh");
            }
        } else {
            //Pegando a lista de pedidos cadastrados no banco
            List<Pedido> pedidos = new ArrayList<>();
            pedidos = repositorioPedido.findAll();

            //Buscando e salvando o pedido pela data
            Optional<Pedido> pedido = pedidos.stream()
                    .filter(p -> p.getData().equals(LocalDate.parse(textoDeBusca))).findFirst();

            if(pedido.isPresent()) {
                return  pedido.get();
            }else {
                System.out.println("meh");
            }
        }

        return null;
    }

    private void adicionarProduto(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        repositorioProduto.save(produto);
    }
    private Produto buscarProdutoPeloNome(String nome) {
        Produto produto = new Produto();
        produto = (Produto) buscarItem(produto, nome);
        return produto;
    }
    public void associarProdutoCategoria(Categoria categoria, Produto produto) {
        produto.setCategoria(categoria);
        repositorioCategoria.save(categoria);
    }
    public void associarProdutoPedido(Produto produto, List<Pedido> pedidos) {
        produto.setPedidos(pedidos);
        repositorioProduto.save(produto);
    }
    public void associarProdutoFornecedor(Fornecedor fornecedor, Produto produto) {
        produto.setFornecedor(fornecedor);
        repositorioProduto.save(produto);
    }
    public void exibirProduto() {
        produtos.forEach(p -> System.out.printf("Produto: %s Preço %s\n",
                p.getNome(), p.getPreco()));
    }

    private void adicionarPedido(LocalDate data) {
        Pedido pedido = new Pedido(data);
        repositorioPedido.save(pedido);
    }
    private Pedido buscarPedidoPelaData(String data) {
        Pedido pedido = new Pedido();
        pedido = (Pedido) buscarItem(pedido, data);
        return pedido;
    }
    public void exibirPedidos() {
        pedidos.forEach(p -> System.out.printf("ID pedido: %s Data %s\n",
                p.getId(), p.getData()));
    }

    private void adicionarCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
        repositorioCategoria.save(categoria);
    }
    public Categoria buscarCategoriaPeloNome(String nome) {
        Categoria categoria = new Categoria();
        categoria = (Categoria) buscarItem(categoria, nome);
        return categoria;
    }
    public void adicionarFornecedor(String nome) {
        Fornecedor fornecedor = new Fornecedor(nome);
        repositorioFornecedor.save(fornecedor);
    }
    public Fornecedor buscarFornecedorPeloNome(String nome) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = (Fornecedor) buscarItem(fornecedor, nome);
        return fornecedor;
    }
    public void consultasDerivedQuery(){
        //1
        /*Optional<Produto> buscarProdutoPorNomeExato = repositorioProduto.findByNomeEquals("Celular");
        if (buscarProdutoPorNomeExato.isPresent()) {
            System.out.println("Nome do produto: " + buscarProdutoPorNomeExato.get().getNome() + " preço: " + buscarProdutoPorNomeExato.get().getPreco());
        }else{
            System.out.println("nenhum produto encontrado");
        }*/
        //2
        /*List<Produto> buscarProdutosPorCategoria = repositorioProduto.findByCategoriaNome("papelaria");
        buscarProdutosPorCategoria.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preco: " + p.getPreco() + " categoria: " + p.getCategoria().getNome()));*/
        //3
        /*List<Produto> buscarProdutosPorPrecoMaior = repositorioProduto.findByPrecoGreaterThan(5.0);
        buscarProdutosPorPrecoMaior.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preço: " + p.getPreco()));*/
        //4
        /*List<Produto> buscarProdutosPorPrecoMenor = repositorioProduto.findByPrecoLessThan(5.0);
        buscarProdutosPorPrecoMenor.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preço: " + p.getPreco()));*/
        //5
        /*List<Produto> buscarProdutosPorTermoContido = repositorioProduto.findByNomeContainingIgnoreCase("ta");
        buscarProdutosPorTermoContido.forEach(p -> System.out.println("Nome: " + p.getNome()));*/
        //6
        /*List<Pedido> buscarPedidosSemData = repositorioPedido.findByDataIsNull();
        buscarPedidosSemData.forEach(p -> System.out.println("ID: " + p.getId()));*/
        //7
        /*List<Pedido> buscarPedidosComData = repositorioPedido.findByDataIsNotNull();
        buscarPedidosComData.forEach(p -> System.out.println("ID: " + p.getId()));*/
        //8
        /*List<Produto> buscarProdutosPorCategoriaEOrdenadoCrescente = repositorioProduto.findByCategoriaNomeEqualsOrderByPrecoAsc("papelaria");
        buscarProdutosPorCategoriaEOrdenadoCrescente.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preco: " + p.getPreco() + " categoria: " + p.getCategoria().getNome()));*/
        //9
       /* List<Produto> buscarProdutosPorCategoriaEOrdenadoDecrescente = repositorioProduto.findByCategoriaNomeEqualsOrderByPrecoDesc("papelaria");
        buscarProdutosPorCategoriaEOrdenadoDecrescente.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preco: " + p.getPreco() + " categoria: " + p.getCategoria().getNome()));*/
        //10
        /*int quantidadePorCategoria = repositorioProduto.countByCategoriaNome("papelaria");
        System.out.println(quantidadePorCategoria);*/
        //11
        /*int quantidadePorPreco = repositorioProduto.countByPrecoGreaterThan(5.0);
        System.out.println(quantidadePorPreco);*/
        //12
        /*List<Produto> buscarProdutosPrecoMaiorENomeContendoTexto = repositorioProduto.findByNomeContainingIgnoreCaseOrPrecoLessThan("a", 5.0);
        buscarProdutosPrecoMaiorENomeContendoTexto.forEach(p -> System.out.println("Nome: " + p.getNome() + " Preco: " + p.getPreco()));*/
        //13
        /*List<Pedido> buscarPedidosFeitosAposData = repositorioPedido.findByDataAfter(LocalDate.parse("2025-03-01"));
        buscarPedidosFeitosAposData.forEach(p -> System.out.println("Pedido: " + p.getId() + " Data: " + p.getData()));*/
        //14
        /*List<Pedido> buscarPedidosFeitosAntesData = repositorioPedido.findByDataBefore(LocalDate.parse("2025-03-01"));
        buscarPedidosFeitosAntesData.forEach(p -> System.out.println("Pedido: " + p.getId() + " Data: " + p.getData()));*/
        //15
        /*List<Pedido> buscarPedidosFeitosIntervalo = repositorioPedido.findByDataBetween(LocalDate.parse("2025-03-01"), LocalDate.parse("2025-03-02"));
        buscarPedidosFeitosIntervalo.forEach(p -> System.out.println("Pedido: " + p.getId() + " Data: " + p.getData()));*/
        //16
        /*List<Produto> buscarTop3ProdutosMaisCaros = repositorioProduto.findTop3ByOrderByPrecoDesc();
        buscarTop3ProdutosMaisCaros.forEach(produto -> System.out.println("Nome: " + produto.getNome() + " Preço:" + produto.getPreco()));*/
        //17
        /*List<Produto> buscarTop5ProdutosMaisBaratos = repositorioProduto.findTop5ByCategoriaNomeOrderByPrecoAsc("papelaria");
        buscarTop5ProdutosMaisBaratos.forEach(produto -> System.out.println("Nome: " + produto.getNome() + " Preço:" + produto.getPreco()));*/
    }
    public void consultasJPQL(){

        //primeiroEx();
        //segundoEx();
        //terceiroEx();
        //quartoEx();
        //quintoEx();
        //sextoEx();
        //setimoEx();
        //oitavoEx();
        //nonoEx();
        //decimoEx();
        decimoPrimeiroEx();
    }
    public void primeiroEx(){
        produtos = repositorioProduto.produtosComPrecoMaiorQueUmValor(6.0);
        exibirProduto();
    }
    public void segundoEx(){
        produtos = repositorioProduto.produtosOrdenadosPeloPrecoCrescente();
        exibirProduto();
    }
    public void terceiroEx(){
        produtos = repositorioProduto.produtosOrdenadosPeloPrecoDecrescente();
        exibirProduto();
    }
    public void quartoEx(){
        produtos = repositorioProduto.produtosQueComecamComALetra("c");
        exibirProduto();
    }
    public void quintoEx(){
        pedidos = repositorioPedido.pedidosFeitosEntreDuasDatas(LocalDate.parse("2025-03-01"), LocalDate.parse("2025-03-02"));
        exibirPedidos();
    }
    public void sextoEx(){
        double mediaPreco = repositorioProduto.mediaDePrecos();
        System.out.println("media dos preços: " + mediaPreco);

    }
    public void setimoEx(){
        double precoMaximoPorcategoria = repositorioProduto.precoMaximoPorCategoria("papelaria");
        System.out.println("Maior preço da categoria papelaria: " + precoMaximoPorcategoria);
    }
    public void oitavoEx(){
        int numeroDeProdutosPorCategoria = repositorioProduto.numeroDeProdutosPorCategoria("papelaria");
        System.out.println("Numero de produtos da categoria papelaria: " + numeroDeProdutosPorCategoria);
    }
    public void nonoEx(){
        categorias = repositorioCategoria.categoriasComMaisDe3Produtos();
        categorias.forEach(c -> System.out.println(c.getNome()) );
    }
    public  void decimoEx(){
        produtos = repositorioProduto.produtosfiltradosPorNomeOuPorCategoria("caneta", "papelaria");
        exibirProduto();
    }
    public void decimoPrimeiroEx(){
        produtos = repositorioProduto.os3ProdutosMaisCaros();
        exibirProduto();

    }
}

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

        //Adicionando produto no banco
        /*Produto produto = new Produto("Celular", 1000.0);
        repositorioProduto.save(produto);
        Produto produto2 = new Produto("batata", 1.0);
        repositorioProduto.save(produto2);*/

        //Pegando produto do banco
        /*Produto produto1 = new Produto();
        produto1 = (Produto) buscarItem(produto1, "celular");
        Produto produto2 = new Produto();
        produto2 = (Produto) buscarItem(produto2, "caneta");*/

        //Pegando categorias cadastradas no banco
        /*Categoria categoria = new Categoria();
        categorias = repositorioCategoria.findAll();
        Optional<Categoria> categoria1 = categorias.stream()
                .filter(c -> c.getNome().toLowerCase().contains("papelaria")).findFirst();
        if (categoria1.isPresent()) {
            categoria = categoria1.get();
        }else {
            System.out.println("meh");
        }*/

        //Associando o produto a categoria
        /*categoria.setProdutos(addProdutos);
        repositorioCategoria.save(categoria);*/

        //Adicionando pedidos no banco
        /*Pedido pedido1 = new Pedido(LocalDate.parse("2025-03-02"));
        Pedido pedido2 = new Pedido(LocalDate.parse("2025-03-01"));
        Pedido pedido3 = new Pedido(LocalDate.parse("2025-02-28"));
        repositorioPedido.save(pedido1);
        repositorioPedido.save(pedido2);
        repositorioPedido.save(pedido3);*/

        //Pegando pedido do banco
        /*Pedido pedido1 = new Pedido();
        pedido1 = (Pedido) buscarItem(pedido1, "2025-03-01");
        Pedido pedido2 = new Pedido();
        pedido2 = (Pedido) buscarItem(pedido2, "2025-03-02");*/

        //Associando produto e pedidio
        /*List<Pedido> pedidoDoProd1 = new ArrayList<>();
        pedidoDoProd1.add(pedido1);
        pedidoDoProd1.add(pedido2);
        produto1.setPedidos(pedidoDoProd1);

        List<Pedido> pedidoDoProd2 = new ArrayList<>();
        pedidoDoProd2.add(pedido1);
        pedidoDoProd2.add(pedido2);
        produto2.setPedidos(pedidoDoProd1);

        repositorioPedido.save(pedido1);
        repositorioPedido.save(pedido2);
        repositorioProduto.save(produto1);
        repositorioProduto.save(produto2);*/

        //Adicionando fornecedores no banco
        /*Fornecedor fornecedor1 = new Fornecedor("multsystem");
        Fornecedor fornecedor2 = new Fornecedor("covabra");
        Fornecedor fornecedor3 = new Fornecedor("acemape");
        repositorioFornecedor.save(fornecedor1);
        repositorioFornecedor.save(fornecedor2);
        repositorioFornecedor.save(fornecedor3);*/

        //Pegando fornecedores do banco
        /*Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1 = (Fornecedor) buscarItem(fornecedor1, "multsystem");
        Fornecedor fornecedor2 = new Fornecedor();
        fornecedor2 = (Fornecedor) buscarItem(fornecedor2, "acemape");*/

        //Associando fornecedores a produtos
        /*produto1.setFornecedor(fornecedor1);
        produto2.setFornecedor(fornecedor2);
        repositorioProduto.save(produto1);
        repositorioProduto.save(produto2);*/

        //Consultas derived query
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
        List<Produto> buscarTop5ProdutosMaisBaratos = repositorioProduto.findTop5ByCategoriaNomeOrderByPrecoAsc("papelaria");
        buscarTop5ProdutosMaisBaratos.forEach(produto -> System.out.println("Nome: " + produto.getNome() + " Preço:" + produto.getPreco()));




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

    private void cadastrarProduto() {
        System.out.println("Digite o nome do produto: ");
        String nome = leitura.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valor = leitura.nextDouble();
        Produto produto = new Produto(nome, valor);
        repositorioProduto.save(produto);
    }

    private void cadastrarPedido() {
        System.out.println("Digite a data");
        LocalDate data = LocalDate.parse(leitura.nextLine());
        Pedido pedido = new Pedido(data);
        repositorioPedido.save(pedido);

    }

    private void cadastrarCategoria() {
        System.out.println("Digite o nome do categoria: ");
        String nome = leitura.nextLine();
        Categoria categoria = new Categoria(nome);
        repositorioCategoria.save(categoria);

    }
}

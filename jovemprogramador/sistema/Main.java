package br.com.jp;

import br.com.jp.dao.EnfermeiroDao;
import br.com.jp.dao.EstabelecimentoDeSaudeDao;
import br.com.jp.dao.PedidoDao;
import br.com.jp.dao.PessoaDao;
import br.com.jp.dao.ProdutoEpiDao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws SQLException {

        LocalDate data = LocalDate.of(2023, Month.JULY, 06);

        LocalDate dataNascimento = LocalDate.of(1980, Month.AUGUST, 14);

        Enfermeiro enfermeira = new Enfermeiro("Jojo Toddynho", "(48) 99999-1111", "jojo@gmail.com", "88130-111", 1234, dataNascimento, "1111", "F");
        EstabelecimentoDeSaude hospital = new EstabelecimentoDeSaude("Hospital Regional", "2222", "regional@gamil.com", "88130-222", "(48) 99999-2222");

        ProdutoEpi p1 = new ProdutoEpi("1111", "P", 10, TipoProduto.MASCARA);
        ProdutoEpi p2 = new ProdutoEpi("2222", "M", 2, TipoProduto.GORRO);
        ProdutoEpi p3 = new ProdutoEpi("3333", "40", 1, TipoProduto.CALCADO);
        ProdutoEpi p4 = new ProdutoEpi("4444", "GG", 4, TipoProduto.AVENTAL);
        ProdutoEpi p5 = new ProdutoEpi("5555", "M", 2, TipoProduto.PROTETOR_OCULAR);
        ProdutoEpi p6 = new ProdutoEpi("6666", "G", 6, TipoProduto.LUVA);

        List<ProdutoEpi> pedidos1 = new ArrayList<>();
        pedidos1.add(p1);
        pedidos1.add(p2);
        pedidos1.add(p3);

        List<ProdutoEpi> pedidos2 = new ArrayList<>();
        pedidos2.add(p4);
        pedidos2.add(p5);
        pedidos2.add(p6);

        Pedido pedido1 = new Pedido(123456, data, true, enfermeira, hospital, pedidos1);
        Pedido pedido2 = new Pedido(654321, data, true, enfermeira, hospital, pedidos2);

        Relatorio.gerarRelatorio(pedido1);
        //Relatorio.gerarRelatorio(pedido2);

        //EstabelecimentoDeSaude.cadastro("111", "1234");
        //EstabelecimentoDeSaude.acessarSistema("111", "1234");

        //Enfermeiro.cadastro("1111", "4321");
        //Enfermeiro.acessarSistema("1111", "4321");
        
        PessoaDao pessoaDao = new PessoaDao();
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        EstabelecimentoDeSaudeDao estabelecimentoDao = new EstabelecimentoDeSaudeDao();
        ProdutoEpiDao produtoDao = new ProdutoEpiDao();
        PedidoDao pedidoDao = new PedidoDao();
        
        try {
            //pessoaDao.criar(enfermeira);
            //pessoaDao.excluir(3);
            //enfermeiroDao.criar(enfermeira);
            //enfermeiroDao.pesquisar(1234);
            //enfermeiroDao.excluir(1234);
            //estabelecimentoDao.criar(hospital);
            estabelecimentoDao.pesquisar(2222);
            produtoDao.criar(p1);
            produtoDao.criar(p2);
            produtoDao.criar(p3);
            produtoDao.criar(p4);
            produtoDao.criar(p5);
            produtoDao.criar(p6);
            
            //produtoDao.alterar(p6);
            produtoDao.pesquisar(1111);
            //pedidoDao.criar(pedido1);
            //pedidoDao.criar(pedido2);
            pedidoDao.pesquisar(123456);
            
            
        } catch (SQLException ex) {
        
            System.out.println("Erro ao conectar: " + ex.getMessage());
        }
    }
}

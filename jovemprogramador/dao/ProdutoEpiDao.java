package br.com.jp.dao;

import br.com.jp.ProdutoEpi;
import br.com.jp.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoEpiDao {
    
    private TipoProduto tipo;

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
    
    public ProdutoEpi criar(ProdutoEpi produtoEpi) throws SQLException {
        String sql = "INSERT INTO produtoepi(codigo_produto_epi, tamanho_produto_epi, quantidade_produto_epi) VALUES (?, ?, ?)";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, produtoEpi.getCodigo());
        statement.setString(2, produtoEpi.getTamanho());
        statement.setInt(3, produtoEpi.getQuantidade());

        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
        
        return produtoEpi;
    }
    
    public ProdutoEpi alterar(ProdutoEpi produtoEpi) throws SQLException {
        
        String sql = "UPDATE produtoepi SET tamanho_produto_epi = ?, quantidade_produto_epi = ? WHERE codigo_produto_epi = ?";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, produtoEpi.getTamanho());
        statement.setInt(2, produtoEpi.getQuantidade());
        statement.setString(3, produtoEpi.getCodigo());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return produtoEpi;
    }
    
    public ProdutoEpi pesquisar(long id) throws SQLException {
        
        String sql = "SELECT * FROM produtoepi WHERE codigo_produto_epi = ?";
        
        ProdutoEpi produtoEpi = null;
        
        Connection conexao = Conexao.abrirConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, id);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()) {
            
            String codigo = result.getString("codigo_produto_epi");
            String tamanho = result.getString("tamanho_produto_epi");
            int quantidade = result.getInt("quantidade_produto_epi");
            
            String produtoInfo = "Código do produto: " + codigo + " - Tamanho do produto: " + tamanho + " - Quantidade:  " + quantidade + ".";
            System.out.println(produtoInfo);
        }
        
        Conexao.fecharConexao(conexao);
        
        return produtoEpi;
    }
    
    public void excluir(long id) throws SQLException {
    
        String sql = "DELETE FROM produtoepi WHERE codigo_produto_epi = ?";
        
        Connection conexao = Conexao.abrirConexao();
    
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
    }
}

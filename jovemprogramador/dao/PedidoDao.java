package br.com.jp.dao;

import br.com.jp.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDao {
    
    public Pedido criar(Pedido pedido) throws SQLException {
        
        String sql = "INSERT INTO pedido(codigo_pedido, data_solicitacao_pedido, status_pedido) VALUES (?, ?, ?)";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setInt(1, pedido.getCodigo());
        statement.setDate(2, Date.valueOf(pedido.getDataSolicitacao()));
        statement.setBoolean(3, pedido.isStatus());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return pedido;
    }
    
    public Pedido alterar(Pedido pedido) throws SQLException {
        
        String sql = "UPDATE pedido SET data_solicitacao_pedido = ?, status_pedido = ? WHERE codigo_pedido = ?";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setInt(3, pedido.getCodigo());
        statement.setDate(1, Date.valueOf(pedido.getDataSolicitacao()));
        statement.setBoolean(2, pedido.isStatus());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return pedido;
    }
    
    public Pedido pesquisar(long id) throws SQLException {
        
        String sql = "SELECT * FROM pedido WHERE codigo_pedido = ?";
        
        Pedido pedido = null;
        
        Connection conexao = Conexao.abrirConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, id);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()) {
            
            int codigo = result.getInt("codigo_pedido");
            Date data = result.getDate("data_solicitacao_pedido");
            boolean status = result.getBoolean("status_pedido");
            
            String pedidoInfo = "Código do produto: " + codigo + " - Data de solicitação: " + data + " - Status:  " + status + ".";
            System.out.println(pedidoInfo);
        }
        
        Conexao.fecharConexao(conexao);
        
        return pedido;
    }
    
    public void excluir(long id) throws SQLException {
    
        String sql = "DELETE FROM pedido WHERE codigo_pedido = ?";
        
        Connection conexao = Conexao.abrirConexao();
    
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
    }
}

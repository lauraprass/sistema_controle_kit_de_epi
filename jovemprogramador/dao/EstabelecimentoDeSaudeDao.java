package br.com.jp.dao;

import br.com.jp.EstabelecimentoDeSaude;
import br.com.jp.TipoEstabelecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstabelecimentoDeSaudeDao {
    
    private TipoEstabelecimento tipo;

    public TipoEstabelecimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstabelecimento tipo) {
        this.tipo = tipo;
    }
    
    public EstabelecimentoDeSaude criar(EstabelecimentoDeSaude estabelecimento) throws SQLException {
        String sql = "INSERT INTO estabelecimentodesaude(cnpj_estabelecimento_de_saude, tipo_estabelecimento_de_saude) VALUES (?, ?)";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, estabelecimento.getCnpj());
        statement.setString(2, estabelecimento.getNome());

        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
        
        return estabelecimento;
    }
    
    public EstabelecimentoDeSaude alterar(EstabelecimentoDeSaude estabelecimento) throws SQLException {
        
        String sql = "UPDATE estabelecimentodesaude SET tipo_estabelecimento_de_saude = ? WHERE cnpj_estabelecimento_de_saude = ?";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, estabelecimento.getNome());
        statement.setString(2, estabelecimento.getCnpj());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return estabelecimento;
    }
    
    public EstabelecimentoDeSaude pesquisar(long id) throws SQLException {
        
        String sql = "SELECT * FROM estabelecimentodesaude WHERE cnpj_estabelecimento_de_saude = ?";
        
        EstabelecimentoDeSaude estabelecimento = null;
        
        Connection conexao = Conexao.abrirConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, id);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()) {
            
            String cnpj = result.getString("cnpj_estabelecimento_de_saude");
            String tipo = result.getString("tipo_estabelecimento_de_saude");
            
            String enfermeiroInfo = "CNPJ: " + cnpj + " - Tipo de estabelecimento: " + tipo + ".";
            System.out.println(enfermeiroInfo);
        }
        
        Conexao.fecharConexao(conexao);
        
        return estabelecimento;
    }
    
    public void excluir(long id) throws SQLException {
    
        String sql = "DELETE FROM estabelecimentodesaude WHERE cnpj_estabelecimento_de_saude = ?";
        
        Connection conexao = Conexao.abrirConexao();
    
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
    }
}

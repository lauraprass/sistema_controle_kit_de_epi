package br.com.jp.dao;

import br.com.jp.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDao {
    
    public Pessoa criar(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa(nome_pessoa, telefone_pessoa, email_pessoa, cep_pessoa) VALUES (?, ?, ?, ?)";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getTelefone());
        statement.setString(3, pessoa.getEmail());
        statement.setString(4, pessoa.getCep());
 
        statement.executeUpdate();
        
        ResultSet result = statement.getGeneratedKeys();
        
        if(result.next()) {
            pessoa.setIdPessoa(result.getInt(1));
        }

        Conexao.fecharConexao(conexao);
        
        return pessoa;
    }

    public Pessoa alterar(Pessoa pessoa) throws SQLException {
        
        String sql = "UPDATE pessoa SET nome_pessoa = ?, telefone_pessoa = ?, email_pessoa = ?, cep_pessoa = ? WHERE idpessoa = ?";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getTelefone());
        statement.setString(3, pessoa.getEmail());
        statement.setString(4, pessoa.getCep());
        statement.setInt(4, pessoa.getIdPessoa());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return pessoa;
    }
    
    public void excluir(long id) throws SQLException {
    
        String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
        
        Connection conexao = Conexao.abrirConexao();
    
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
    }
}
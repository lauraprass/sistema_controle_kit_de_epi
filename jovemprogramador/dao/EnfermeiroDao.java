package br.com.jp.dao;

import br.com.jp.Enfermeiro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EnfermeiroDao {

    public Enfermeiro criar(Enfermeiro enfermeiro) throws SQLException {
        String sql = "INSERT INTO enfermeiro(matricula_enfermeiro, data_nascimento_enfermeiro, cpf_enfermeiro, sexo_enfermeiro) VALUES (?, ?, ?, ?)";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setInt(1, enfermeiro.getMatricula());
        statement.setDate(2, Date.valueOf(enfermeiro.getDataDeNascimento()));
        statement.setString(3, enfermeiro.getCpf());
        statement.setString(4, enfermeiro.getSexo());
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
        
        return enfermeiro;
    }
    
    public Enfermeiro alterar(Enfermeiro enfermeiro) throws SQLException {
        
        String sql = "UPDATE pessoa SET nome_pessoa = ?, telefone_pessoa = ?, email_pessoa = ?, cep_pessoa = ? WHERE idpessoa = ?";
        
        Connection conexao = Conexao.abrirConexao();
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setInt(1, enfermeiro.getMatricula());
        statement.setDate(2, Date.valueOf(enfermeiro.getDataDeNascimento()));
        statement.setString(3, enfermeiro.getCpf());
        statement.setString(4, enfermeiro.getSexo());
        
        statement.executeUpdate();
        
        Conexao.fecharConexao(conexao);
        
        return enfermeiro;
    }
    
    public Enfermeiro pesquisar(long id) throws SQLException {
        
        String sql = "SELECT * FROM enfermeiro WHERE matricula_enfermeiro = ?";
        
        Enfermeiro enfermeiro = null;
        
        Connection conexao = Conexao.abrirConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, id);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()) {
            
            String matricula = result.getString("matricula_enfermeiro");
            LocalDate dataNascimento = result.getDate("data_nascimento_enfermeiro").toLocalDate();
            String cpf = result.getString("cpf_enfermeiro");
            String sexo = result.getString("sexo_enfermeiro");
            
            String enfermeiroInfo = "Mátricula: " + matricula + " - Data de nascimento: " + dataNascimento + " - CPF: " + cpf + " - Sexo: " + sexo + ".";
            System.out.println(enfermeiroInfo);
        }
        
        Conexao.fecharConexao(conexao);
        
        return enfermeiro;
    }
    
    public void excluir(long id) throws SQLException {
    
        String sql = "DELETE FROM enfermeiro WHERE matricula_enfermeiro = ?";
        
        Connection conexao = Conexao.abrirConexao();
    
        PreparedStatement statement = conexao.prepareStatement(sql);
        
        statement.setLong(1, id);
        
        statement.executeUpdate();

        Conexao.fecharConexao(conexao);
    }
}

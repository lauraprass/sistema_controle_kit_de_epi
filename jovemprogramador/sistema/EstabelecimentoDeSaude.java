package br.com.jp;

import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoDeSaude extends Pessoa {
    
    private String cnpj;
    private String senha;
    private static List<String[]> registros = new ArrayList<>();

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EstabelecimentoDeSaude(String nome, String cnpj, String email, String cep, String telefone) {
        super(nome, telefone, email, cep);
        this.cnpj = cnpj;
        this.nome = nome;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
    }

    public static void cadastro(String cnpj, String senha) {
        String[] registro = {cnpj, senha};
        registros.add(registro);
    }

    public static void acessarSistema(String cnpj, String senha) {
        for (String[] registro : registros) {
            if (registro[0].equals(cnpj) && registro[1].equals(senha)) {
                System.out.println("");
                System.out.println("Acessou o sistema da NursEpi. Seja bem vindo!");
                System.out.println("");
                break;
            } else {
                System.out.println("");
                System.out.println("Acesso negado.");
                System.out.println("");
                break;
            }
        }
    }
}

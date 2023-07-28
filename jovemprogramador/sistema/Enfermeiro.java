package br.com.jp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enfermeiro extends Pessoa {
    
    private int matricula;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String sexo;
    private static List<String[]> registros = new ArrayList<>();

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    } 

    public static List<String[]> getRegistros() {
        return registros;
    }

    public static void setRegistros(List<String[]> registros) {
        Enfermeiro.registros = registros;
    }

    public Enfermeiro(String nome, String telefone, String email, String cep, int matricula, LocalDate dataDeNascimento, String cpf, String sexo) {
        super(nome, telefone, email, cep);
        this.matricula = matricula;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public static void cadastro(String matricula, String senha) {
        String[] registro = {matricula, senha};
        registros.add(registro);
    }

    public static void acessarSistema(String matricula, String senha) {
        for (String[] registro : registros) {
            if (registro[0].equals(matricula) && registro[1].equals(senha)) {
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

    @Override
    public String toString() {
        return "Enfermeiro{" + "matricula=" + matricula + ", dataDeNascimento=" + dataDeNascimento + ", cpf=" + cpf + ", sexo=" + sexo + '}';
    }
}

package br.com.jp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private int codigo;
    private LocalDate dataSolicitacao;
    private boolean status;
    private int matricula;
    private List<ProdutoEpi> produtos = new ArrayList<>();
    private Pessoa enfermeiro;
    private Pessoa estabelecimento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<ProdutoEpi> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEpi> produtos) {
        this.produtos = produtos;
    }

    public Pessoa getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Pessoa enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public Pessoa getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Pessoa estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Pedido(int codigo, LocalDate dataSolicitacao, boolean status, Pessoa enfermeiro, Pessoa estabelecimento, List<ProdutoEpi> produtos) {
        this.codigo = codigo;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
        this.enfermeiro = enfermeiro;
        this.estabelecimento = estabelecimento;
        this.produtos = produtos;
    }
}

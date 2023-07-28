package br.com.jp;

import java.util.ArrayList;
import java.util.List;

public class ProdutoEpi {
    
    private String codigo;
    private String tamanho;
    private int quantidade;
    private TipoProduto tipo;
    private List<Pedido> pedidos = new ArrayList<>();
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public ProdutoEpi(String codigo, String tamanho, int quantidade, TipoProduto tipo) {
        this.codigo = codigo;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }
}

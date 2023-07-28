package br.com.jp;

public enum TipoProduto {
   
    MASCARA("Máscara"),
    AVENTAL("Avental"),
    PROTETOR_OCULAR("Protetor ocular"),
    CALCADO("Calçado"),
    PROTETOR_FACE("Protetor de face"),
    LUVA("Luva"),
    GORRO("Gorro"),
    TOUCA("Touca");
    
    private String nomeProduto;

    private TipoProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
 
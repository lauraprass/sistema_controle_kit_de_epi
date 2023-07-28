package br.com.jp;

public enum TipoEstabelecimento {
    
    POSTO_DE_SAUDE("Posto de saúde"),
    HOSPITAL_GERAL("Hospital geral"),
    LABORATORIO("Laboratório"),
    CLINICA("Cliníca");
    
    private String nomeEstabelecimento;

    private TipoEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getNome() {
        return nomeEstabelecimento;
    }

    public void setNome(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }
}

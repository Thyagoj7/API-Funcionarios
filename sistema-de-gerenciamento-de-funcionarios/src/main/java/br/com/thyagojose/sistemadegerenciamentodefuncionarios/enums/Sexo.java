package br.com.thyagojose.sistemadegerenciamentodefuncionarios.enums;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    INDEFINIDO("Indefinido");

    private String descricao;

    Sexo(String descricao){
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }
}

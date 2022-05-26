package br.com.thyagojose.sistemadegerenciamentodefuncionarios.dto;

import br.com.thyagojose.sistemadegerenciamentodefuncionarios.entities.Funcionario;
import br.com.thyagojose.sistemadegerenciamentodefuncionarios.enums.Sexo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


public class FuncionarioDTO {
//    private UUID id;

    @NotBlank
    private String nome;
    @NotNull
    private Integer idade;
    @NotNull
    private Long cep;
    private Sexo sexo;
    private String endereço;
    private String bairro;
    private String cidade;
    private String estado;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(/*UUID id,*/ String nome, Integer idade, Long cep, Sexo sexo, String endereço, String bairro, String cidade, String estado) {
        //this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.sexo = sexo;
        this.endereço = endereço;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public FuncionarioDTO(Funcionario funcionario){
       // id = funcionario.getId();
        nome = funcionario.getNome();
        idade = funcionario.getIdade();
        cep = funcionario.getCep();
        sexo = funcionario.getSexo();
        endereço = funcionario.getEndereço();
        bairro = funcionario.getBairro();
        cidade = funcionario.getCidade();
        estado = funcionario.getEstado();
    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

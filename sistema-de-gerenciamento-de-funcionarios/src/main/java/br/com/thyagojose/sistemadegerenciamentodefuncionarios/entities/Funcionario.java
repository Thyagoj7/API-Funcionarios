package br.com.thyagojose.sistemadegerenciamentodefuncionarios.entities;


import br.com.thyagojose.sistemadegerenciamentodefuncionarios.enums.Sexo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true )
    private String nome;
    @Column(nullable = false)
    private Integer idade;
    @Column(nullable = false)
    private Long cep;
    @Column()
    private Sexo sexo;
    @Column()
    private String endereço;
    @Column()
    private String bairro;
    @Column()
    private String cidade;
    @Column()
    private String estado;



    public Funcionario() {
    }

    public Funcionario(UUID id, String nome, Integer idade, Long cep, Sexo sexo, String endereço, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.sexo = sexo;
        this.endereço = endereço;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

package br.edu.ifto.pwebii.aula11.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class ClientePessoaFisica extends Cliente {
    @NotBlank(message = "Esse campo é obrigatório")
    private String nome;
    @Size(min = 11, max = 11, message = "Esse campo de ser preenchido com {max} caracteres")
    @Column(length = 11)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

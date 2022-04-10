package br.edu.ifto.pwebii.aula11.model.entity;

import javax.persistence.Entity;

@Entity
public class ClientePessoaFisica extends Cliente {
    private String nome;
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

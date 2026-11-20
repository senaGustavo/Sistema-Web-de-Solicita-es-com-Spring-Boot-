
package com.projeto.solicitacoes.model;

public class Solicitacao {

    private Long id;
    private String nomeDoSolicitante;
    private String email;
    private String titulo;
    private String categoria;
    private String prioridade;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoSolicitante() {
        return nomeDoSolicitante;
    }

    public void setNomeDoSolicitante(String nomeDoSolicitante) {
        this.nomeDoSolicitante = nomeDoSolicitante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.rest.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Prato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Descrição é obrigatória.")
    private String descricao;

    @NotNull(message = "Preço é obrigatório.")
    @Min(value = 0, message = "Preço não pode ser negativo.")
    private double preco;

    @NotNull(message = "Categoria é obrigatória.")
    private String categoria;

    @NotNull(message = "Disponibilidade é obrigatória.")
    private String disponibilidade;

    @NotBlank(message = "URL da imagem é obrigatória.")
    private String urlImagem;

    public Prato() {}

    public Prato(Long id, String nome, String descricao, double preco, String categoria, String disponibilidade, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponibilidade = disponibilidade;
        this.urlImagem = urlImagem;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDisponibilidade() { return disponibilidade; }
    public void setDisponibilidade(String disponibilidade) { this.disponibilidade = disponibilidade; }

    public String getUrlImagem() { return urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                ", disponibilidade='" + disponibilidade + '\'' +
                ", urlImagem='" + urlImagem + '\'' +
                '}';
    }
}
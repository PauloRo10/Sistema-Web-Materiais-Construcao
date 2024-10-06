
package com.etapa7e8.construcao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;

    private int codigo;
    private String produto;
    private int quantidade;  // Representa a quantidade em estoque
    private String marca;
    private String cnpj;
    private double valorEntrada;
    private double valorVenda;
    private String detalhes;

    public Estoque() {}

    public Estoque(int idEstoque, int codigo, String produto, int quantidade, String marca, String cnpj, double valorEntrada, double valorVenda, String detalhes) {
        this.idEstoque = idEstoque;
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
        this.marca = marca;
        this.cnpj = cnpj;
        this.valorEntrada = valorEntrada;
        this.valorVenda = valorVenda;
        this.detalhes = detalhes;
    }


    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
        public void adicionarQuantidade(int quantidadeEntrada) {
        this.quantidade += quantidadeEntrada;
    }

    public void retirarQuantidade(int quantidadeSaida) {
        if (this.quantidade >= quantidadeSaida) {
            this.quantidade -= quantidadeSaida;
        } else {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente.");
        }
    }

    
    
}

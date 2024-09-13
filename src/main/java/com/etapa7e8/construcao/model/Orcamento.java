
package com.etapa7e8.construcao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrcamento")
    private int idOrcamento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    @Column(name = "quantidadeOrcamento")
    private int quantidadeOrcamento;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @Column(name = "situacao")
    private String situacao;

    public Orcamento() {}

    public Orcamento(int idOrcamento, Funcionario funcionario, Cliente cliente, Estoque estoque, int quantidadeOrcamento, Venda venda, String situacao) {
        this.idOrcamento = idOrcamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.estoque = estoque;
        this.quantidadeOrcamento = quantidadeOrcamento;
        this.venda = venda;
        this.situacao = situacao;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public int getQuantidadeOrcamento() {
        return quantidadeOrcamento;
    }

    public void setQuantidadeOrcamento(int quantidadeOrcamento) {
        this.quantidadeOrcamento = quantidadeOrcamento;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

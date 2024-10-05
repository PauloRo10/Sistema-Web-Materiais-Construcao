
package com.etapa7e8.construcao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFuncionario;

    @NotNull(message = "Nome não pode ser vazio")
    @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
    private String nomeFuncionario;

    @Column(nullable = false, unique = true)
    @NotNull(message = "CPF não pode ser vazio")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    private String cpfFuncionario;

    @NotNull(message = "RG não pode ser vazio")
    private String rgFuncionario;

    @NotNull(message = "Telefone não pode ser vazio")
    private String telefoneFuncionario;

    @NotNull(message = "Endereço não pode ser vazio")
    private String enderecoFuncionario;

    @NotNull(message = "CEP não pode ser vazio")
    private String cepFuncionario;

    @NotNull(message = "Cargo não pode ser vazio")
    private String cargo;

    @NotNull(message = "Salário não pode ser vazio")
    private double salario;


    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(String rgFuncionario) {
        this.rgFuncionario = rgFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getCepFuncionario() {
        return cepFuncionario;
    }

    public void setCepFuncionario(String cepFuncionario) {
        this.cepFuncionario = cepFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return this.nomeFuncionario + " (ID: " + this.getIdFuncionario() + ")";
    }
}


package com.etapa7e8.construcao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFuncionario;

    private String nomeFuncionario;
    private String cpfFuncionario;
    private String rgFuncionario;
    private String telefoneFuncionario;
    private String enderecoFuncionario;
    private String cepFuncionario;
    private String cargo;
    private double salario;

    public Funcionario() {}

    public Funcionario(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String rgFuncionario, String telefoneFuncionario, String enderecoFuncionario, String cepFuncionario, String cargo, double salario) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.rgFuncionario = rgFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.cepFuncionario = cepFuncionario;
        this.cargo = cargo;
        this.salario = salario;
    }

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

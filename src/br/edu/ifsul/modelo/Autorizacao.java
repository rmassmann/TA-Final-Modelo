/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="autorizacao")
public class Autorizacao implements Serializable{
    
     @Id
    @NotNull(message="O tipo nao pode ser nulo")
    @NotBlank(message = "O tipo nao pode ser em branco")
    @Length(max = 40, message="O tipo nao pode ter mais que {max} caracteres.")
    @Column(name="tipo", length=40, nullable=false)
     private String tipo;
     @NotNull(message="A descricao nao pode ser nula")
    @NotBlank(message = "A descricao nao pode ser em branco")
    @Length(max = 60, message="A descricao nao pode ter mais que {max} caracteres.")
    @Column(name="descricao", length=60, nullable=false)
     private String descricao;

    public Autorizacao() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autorizacao other = (Autorizacao) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
}

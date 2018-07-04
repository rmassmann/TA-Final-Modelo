/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="utilizador")
public class Utilizador implements Serializable{
     @Id
    @SequenceGenerator(name="seq_utilizador", sequenceName="seq_utilizador_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_utilizador", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message="O nome nao pode ser nulo")
    @NotBlank(message = "O nome nao pode ser em branco")
    @Length(max = 40, message="O nome nao pode ter mais que {max} caracteres.")
    @Column(name="nome", length=40, nullable=false)
     private String nome;
    @NotNull(message="O password nao pode ser nulo")
    @NotBlank(message = "O password nao pode ser em branco")
    @Length( min= 6,  message="O password nao pode ter menos que {min} caracteres ")
    @Column(name="password", length=40, nullable=false)
     private String password;
     @NotNull(message="O utilizador nao pode ser nulo")
    @NotBlank(message = "O utilizador nao pode ser em branco")
    @Length(max = 40, message="O utilizador nao pode ter mais que {max} caracteres.")
    @Column(name="utilizador", length=40, nullable=false)
     private String utilizador;
     
        @ManyToMany
     @JoinTable(name = "autorizacoes",
            joinColumns
            = @JoinColumn(name = "utilizador", referencedColumnName = "utilizador", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "autorizacao", referencedColumnName = "tipo", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_autorizacoes",
                        columnNames = {"utilizador", "autorizacao"})})
    private List<Autorizacao> autorizacoes = new ArrayList<>(); 
     
     public Utilizador(){}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Utilizador other = (Utilizador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public List<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(List<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }
     
     
}

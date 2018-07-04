/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="album")
public class Album implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_album", sequenceName="seq_album_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_album", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message="O album nao pode ser nulo")
    @NotBlank(message = "O album nao pode ser em branco")
    @Length(max = 40, message="O album nao pode ter mais que {max} caracteres.")
    @Column(name="album", length=40, nullable=false)
     private String titulo;
    
    @NotNull(message = "A data de lançamento do projeto deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lancamento", nullable = false)
    private Calendar lancamento;
    
    @ManyToOne
    @NotNull(message = "A Banda não pode ser nula")
    @JoinColumn(name = "banda", referencedColumnName = "id", 
    nullable = false, 
    foreignKey = @ForeignKey(name = "fk_banda_id"))       
    private Banda banda;
   
     
    @ManyToOne
    @JoinColumn(name = "utilizador", referencedColumnName = "id", nullable = true,
            foreignKey = @ForeignKey(name = "fk_album_utilizador"))   
     private Utilizador utilizador;
     
     
    
    public Album (){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getLancamento() {
        return lancamento;
    }

    public void setLancamento(Calendar lancamento) {
        this.lancamento = lancamento;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Album other = (Album) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    
}

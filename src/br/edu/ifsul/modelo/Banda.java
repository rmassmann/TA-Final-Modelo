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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="banda")
public class Banda implements Serializable{
    
     @Id
    @SequenceGenerator(name="seq_banda", sequenceName="seq_banda_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_banda", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
     @NotNull(message="O nome nao pode ser nulo")
    @NotBlank(message = "O nome nao pode ser em branco")
    @Length(max = 40, message="O nome nao pode ter mais que {max} caracteres.")
    @Column(name="nome", length=40, nullable=false)
     private String nome;
     
     @NotNull(message="O genero nao pode ser nulo")
    @NotBlank(message = "O genero nao pode ser em branco")
    @Length(max = 40, message="O genero nao pode ter mais que {max} caracteres.")
    @Column(name="genero", length=40, nullable=false)
     private String genero;
     
     public Banda(){
         
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Banda other = (Banda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
     
     
}

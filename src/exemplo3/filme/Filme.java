/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.filme;

import exemplo3.categoria.Categoria;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "filme" )
public class Filme implements Serializable {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_filme" )
     private Integer filme;

     @ManyToOne
     @JoinColumn ( name = "cod_cat" )
     private Categoria categoria;

     @Column(name = "descricao")
     private String descricao;
     
     @Column(name = "ano")
     private Date ano;

     public Integer getFilme () {
          return filme;
     }

     public void setFilme ( Integer filme ) {
          this.filme = filme;
     }

     public Categoria getCategoria () {
          return categoria;
     }

     public void setCategoria ( Categoria categoria ) {
          this.categoria = categoria;
     }

     public String getDescricao () {
          return descricao;
     }

     public void setDescricao ( String descricao ) {
          this.descricao = descricao;
     }

     public Date getAno () {
          return ano;
     }

     public void setAno ( Date ano ) {
          this.ano = ano;
     }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.categoria;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "categoria" )
public class Categoria implements Serializable {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_cat" )
     private Integer categoria;

     @Column ( name = "descricao" )
     private String descricao;

     public Integer getCategoria () {
          return categoria;
     }

     public void setCategoriaa ( Integer categoriaa ) {
          this.categoria = categoriaa;
     }

     public String getDescricao () {
          return descricao;
     }

     public void setDescricao ( String descricao ) {
          this.descricao = descricao;
     }



}

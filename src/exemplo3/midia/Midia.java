/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.midia;

import exemplo3.filme.Filme;
import java.io.Serializable;
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
@Table ( name = "midia" )
public class Midia implements Serializable {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_midia" )
     private Integer midia;

     @ManyToOne
     @JoinColumn ( name = "cod_filme" )
     private Filme filme;

     @Column ( name = "inutilizada" )
     private String inutilizada;

     public Integer getMidia () {
          return midia;
     }

     public void setMidia ( Integer midia ) {
          this.midia = midia;
     }

     public Filme getFilme () {
          return filme;
     }

     public void setFilme ( Filme filme ) {
          this.filme = filme;
     }

     public String getInutilizada () {
          return inutilizada;
     }

     public void setInutilizada ( String inutilizada ) {
          this.inutilizada = inutilizada;
     }



}

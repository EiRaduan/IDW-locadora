/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.cliente;

import exemplo.locacao.Locacao;
import exemplo3.endereco.Endereco;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "cliente" )
public class Cliente implements Serializable {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_cliente" )
     private Integer cliente;

     @OneToOne
     @PrimaryKeyJoinColumn ( name = "cod_cliente" )
     private Endereco endereco;

     @OneToMany ( mappedBy = "cliente" )
     private List<Locacao> locacoes;

     @Column ( name = "nome" )
     private String nome;

     @Column ( name = "telefone" )
     private String telefone;

     @Column ( name = "celular" )
     private String celular;

     @Column ( name = "email" )
     private String email;

     public Integer getCliente () {
          return cliente;
     }

     public void setCliente ( Integer cliente ) {
          this.cliente = cliente;
     }

     public Endereco getEndereco () {
          return endereco;
     }

     public void setEndereco ( Endereco endereco ) {
          this.endereco = endereco;
     }

     public List<Locacao> getLocacoes () {
          return locacoes;
     }

     public void setLocacoes ( List<Locacao> locacoes ) {
          this.locacoes = locacoes;
     }

     public String getNome () {
          return nome;
     }

     public void setNome ( String nome ) {
          this.nome = nome;
     }

     public String getTelefone () {
          return telefone;
     }

     public void setTelefone ( String telefone ) {
          this.telefone = telefone;
     }

     public String getCelular () {
          return celular;
     }

     public void setCelular ( String celular ) {
          this.celular = celular;
     }

     public String getEmail () {
          return email;
     }

     public void setEmail ( String email ) {
          this.email = email;
     }
                                

     


}

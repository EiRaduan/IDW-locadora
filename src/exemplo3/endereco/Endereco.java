/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.endereco;

import exemplo.cliente.Cliente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "endereco" )
public class Endereco implements Serializable {

     @Id
     @GeneratedValue ( generator = "fk_endereco_cod_cliente" )
     @org.hibernate.annotations.GenericGenerator ( name = "fk_endereco_cod_cliente" , strategy = "foreign" , parameters = @Parameter ( name = "property" , value = "cliente" ) )
     @Column ( name = "cod_cliente" )
     private Integer endereco;

     @OneToOne ( mappedBy = "endereco" )
     private Cliente cliente;

     @Column ( name = "rua" )
     private String rua;

     @Column ( name = "numero" )
     private Integer numero;

     @Column ( name = "bairro" )
     private String bairro;

     @Column ( name = "cidade" )
     private String cidade;

     @Column ( name = "estado" )
     private String uf;

     @Column ( name = "cep" )
     private String cep;

     @Column ( name = "complemento" )
     private String complemento;

     public Integer getEndereco () {
          return endereco;
     }

     public void setEndereco ( Integer endereco ) {
          this.endereco = endereco;
     }

     public Cliente getCliente () {
          return cliente;
     }

     public void setCliente ( Cliente cliente ) {
          this.cliente = cliente;
     }

     public String getRua () {
          return rua;
     }

     public void setRua ( String rua ) {
          this.rua = rua;
     }

     public Integer getNumero () {
          return numero;
     }

     public void setNumero ( Integer numero ) {
          this.numero = numero;
     }

     public String getBairro () {
          return bairro;
     }

     public void setBairro ( String bairro ) {
          this.bairro = bairro;
     }

     public String getCidade () {
          return cidade;
     }

     public void setCidade ( String cidade ) {
          this.cidade = cidade;
     }

     public String getUf () {
          return uf;
     }

     public void setUf ( String uf ) {
          this.uf = uf;
     }

     public String getCep () {
          return cep;
     }

     public void setCep ( String cep ) {
          this.cep = cep;
     }

     public String getComplemento () {
          return complemento;
     }

     public void setComplemento ( String complemento ) {
          this.complemento = complemento;
     }



   

}

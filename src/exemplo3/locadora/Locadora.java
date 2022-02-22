/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.locadora;

import exemplo.cliente.Cliente;
import exemplo.cliente.ClienteDAO;
import exemplo.locacao.Locacao;
import exemplo.locacao.LocacaoDAO;
import exemplo3.categoria.Categoria;
import exemplo3.categoria.CategoriaDAO;
import exemplo3.endereco.Endereco;
import exemplo3.endereco.EnderecoDAO;
import exemplo3.filme.Filme;
import exemplo3.filme.FilmeDAO;
import exemplo3.midia.Midia;
import exemplo3.midia.MidiaDAO;
import exemplo3.util.HibernateUtil;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author saimor
 */
public class Locadora {

     public static void main ( String[] args ) {
          HibernateUtil.getSessionFactory ().openSession ();
          Locadora locadora = new Locadora ();
          locadora.cadastrarCategorias ();
          locadora.cadastrarFilmes ();
          locadora.cadastrarMidias ();

          EnderecoDAO enderecoDAO = new EnderecoDAO ();
          Endereco endereco = new Endereco ();
          Cliente cliente = new Cliente ();
          ClienteDAO clienteDAO = new ClienteDAO ();

          cliente.setCelular ( "(69) 4444-5555" );
          cliente.setEmail ( "juassk@asni.com" );
          cliente.setNome ( "Fulanos sssaas" );
          cliente.setTelefone ( "(69) 4433-3234" );
          cliente.setEndereco ( endereco );

          endereco.setBairro ( "Centro" );
          endereco.setCep ( "88855-342" );
          endereco.setCidade ( "Porto Velho" );
          endereco.setComplemento ( "casa" );
          endereco.setNumero ( new Integer ( 1 ) );
          endereco.setRua ( "Rua nao sei" );
          endereco.setUf ( "RO" );

          endereco.setCliente ( cliente );
          clienteDAO.salvar ( cliente );
          enderecoDAO.salvar ( endereco );

          LocacaoDAO locacaoDAO = new LocacaoDAO ();
          Locacao locacao = new Locacao ();
          locacao.setDataDevolucao ( new Date ( System.currentTimeMillis () ) );
          locacao.setDataEmprestimo ( new Date ( System.currentTimeMillis () ) );
          locacao.setObservacao ( "Devolução final de semana" );
          locacao.setHoraEmprestimo ( new Time ( System.currentTimeMillis () ) );

          locacao.setCliente ( cliente );

          MidiaDAO midiaDAO = new MidiaDAO ();
          Midia midia = ( Midia ) midiaDAO.buscaMidia ( new Integer ( 1 ) );
          locacao.setMidia ( midia );

          locacaoDAO.salvar ( locacao );
          System.out.println ( "Cadastros gerados com sucesso!" );

     }

     private void cadastrarCategorias () {
          String categorias[] = { "Aventura" , "Ação" , "Comedia" };
          Categoria categoria = null;
          CategoriaDAO categoriaDAO = new CategoriaDAO ();

          for ( int i = 0 ; i < 3 ; i ++ ) {
               categoria = new Categoria ();
               categoria.setDescricao ( categorias[ i ] );
               categoriaDAO.salvar ( categoria );
          }
     }

     private void cadastrarFilmes () {
          CategoriaDAO categoriaDAO = new CategoriaDAO ();
          String[] filmesDescricao = { "Senhor dos Aneis" , "Transformers" , "Ghostbusters" };
          Date[] filmesAnoProducao = { new Date ( 2001 - 1900 , 11 , 19 ) , new Date ( 2007 - 1900 , 6 , 20 ) , new Date ( 1985 - 1900 , 1 , 1 ) };
          FilmeDAO filmeDAO = new FilmeDAO ();
          Filme filme = null;

          for ( int i = 0 ; i < 3 ; i ++ ) {
               filme = new Filme ();
               filme.setDescricao ( filmesDescricao[ i ] );
               filme.setAno ( filmesAnoProducao[ i ] );
               filme.setCategoria ( categoriaDAO.buscaCategoria ( i + 1 ) );
               filmeDAO.salvar ( filme );
          }
     }

     private void cadastrarMidias () {
          Midia midia = null;
          Filme filme = null;
          MidiaDAO midiaDAO = new MidiaDAO ();
          FilmeDAO filmeDAO = new FilmeDAO ();
          List<Filme> resultado = filmeDAO.listar ();

          for ( int i = 0 ; i < 3 ; i ++ ) {
               midia = new Midia ();
               filme = ( Filme ) resultado.get ( i );
               midia.setFilme ( filme );
               midia.setInutilizada ( "N" );
               midiaDAO.salvar ( midia );
          }
     }

}

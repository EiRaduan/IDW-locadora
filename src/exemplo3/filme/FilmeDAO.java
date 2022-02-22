/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.filme;

import exemplo3.categoria.Categoria;
import exemplo3.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author saimor
 */
public class FilmeDAO {
     
     private Session sessao;
     private Transaction transacao;

     public void salvar ( Filme filme ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.save ( filme );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel inserir o filme. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de inserção. Erro: " + e.getMessage () );
               }
          }
     }

     public void atualizar ( Filme filme ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.update ( filme );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel alterar o filme. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de atualização. Erro: " + e.getMessage () );
               }
          }
     }

     public void excluir ( Filme filme ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.delete ( filme );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel excluir o filme. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de exclusão. Erro: " + e.getMessage () );
               }
          }
     }

     public Filme buscaFilme ( Integer codigo ) {
          Filme filme = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Filme.class );
               filtro.add ( Restrictions.eq ( "filme" , codigo ) );
               filme = ( Filme ) filtro.uniqueResult ();
               this.transacao.commit ();
          } catch ( Throwable e ) {
               if ( this.transacao.isActive () ) {
                    this.transacao.rollback ();
               }
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de busca. Erro: " + e.getMessage () );
               }
          }
          return filme;
     }

     public List<Filme> listar() {
          List<Filme> filme = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Filme.class );
               filme = filtro.list ();
               this.transacao.commit ();
          } catch ( Throwable e ) {
               if(this.transacao.isActive()){
                    this.transacao.rollback ();
               }
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de listagem. Erro: " + e.getMessage () );
               }
          }
          return filme;
     }
}

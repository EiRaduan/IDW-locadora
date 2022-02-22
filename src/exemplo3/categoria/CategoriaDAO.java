/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.categoria;

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
public class CategoriaDAO {

     private Session sessao;
     private Transaction transacao;

     public void salvar ( Categoria categoria ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.save ( categoria );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel inserir a categoria. Erro: " + e.getMessage () );
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

     public void atualizar ( Categoria categoria ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.update ( categoria );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel alterar a categoria. Erro: " + e.getMessage () );
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

     public void excluir ( Categoria categoria ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.delete ( categoria );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel excluir a categoria. Erro: " + e.getMessage () );
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

     public Categoria buscaCategoria ( Integer codigo ) {
          Categoria categoria = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Categoria.class );
               filtro.add ( Restrictions.eq ( "categoria" , codigo ) );
               categoria = ( Categoria ) filtro.uniqueResult ();
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
          return categoria;
     }

     public List<Categoria> listar() {
          List<Categoria> categoria = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Categoria.class );
               categoria = filtro.list ();
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
          return categoria;
     }

}

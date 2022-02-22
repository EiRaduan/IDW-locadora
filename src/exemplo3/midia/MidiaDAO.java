/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.midia;

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
public class MidiaDAO {
private Session sessao;
     private Transaction transacao;

     public void salvar ( Midia midia) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.save ( midia);
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel inserir a midia. Erro: " + e.getMessage () );
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

     public void atualizar ( Midia midia ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.update ( midia );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel alterar a midia. Erro: " + e.getMessage () );
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

     public void excluir ( Midia midia ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.delete ( midia );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel excluir a midia. Erro: " + e.getMessage () );
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

     public Midia buscaMidia ( Integer codigo ) {
          Midia midia = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Midia.class );
               filtro.add ( Restrictions.eq ( "filme" , codigo ) );
               midia = ( Midia ) filtro.uniqueResult ();
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
          return midia;
     }

     public List<Midia> listar() {
          List<Midia> midia = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Midia.class );
               midia = filtro.list ();
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
          return midia;
     }
     
}

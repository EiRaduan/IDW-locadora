/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo.locacao;

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
public class LocacaoDAO {

     private Session sessao;
     private Transaction transacao;

     public void salvar ( Locacao locacao ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.save ( locacao );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel inserir a locacao. Erro: " + e.getMessage () );
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

     public void atualizar ( Locacao locacao ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.update ( locacao );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel alterar a locacao. Erro: " + e.getMessage () );
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

     public void excluir ( Locacao locacao ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.delete ( locacao );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel excluir a locacao. Erro: " + e.getMessage () );
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

     public Locacao buscaLocacao ( Integer codigo ) {
          Locacao locacao = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Locacao.class );
               filtro.add ( Restrictions.eq ( "locacao" , codigo ) );
               locacao = ( Locacao ) filtro.uniqueResult ();
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
          return locacao;
     }

     public List<Locacao> listar () {
          List<Locacao> locacao = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Locacao.class );
               locacao = filtro.list ();
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
                    System.out.println ( "Erro ao fechar operação de listagem. Erro: " + e.getMessage () );
               }
          }
          return locacao;
     }

}

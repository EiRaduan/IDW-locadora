/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.util;

import org.hibernate.Session;

/**
 *
 * @author saimor
 */
public class ConectarHibernatePostgreSQL {
     public static void main(String [] args){
          Session sessao = null;
          try{
              sessao = HibernateUtil.getSessionFactory().openSession();
              System.out.println("Conectou");
          }finally{
                 sessao.close ();
           }
    }
}

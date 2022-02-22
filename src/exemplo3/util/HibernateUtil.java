/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author saimor
 */
public class HibernateUtil {

     private static final SessionFactory sessionFactory = buildSessionFactory ();

     private static SessionFactory buildSessionFactory () {
          try {
               AnnotationConfiguration cfg = new AnnotationConfiguration ();
               cfg.configure ( "hibernate.cfg.xml" );
               return cfg.buildSessionFactory ();
          } catch ( Throwable e ) {
               System.out.println ( "Criação inicial do objeto SessionFactory fechou. Erro: " + e );
               throw new ExceptionInInitializerError ( e );
          }
     }

     public static SessionFactory getSessionFactory () {
          return sessionFactory;
     }

}

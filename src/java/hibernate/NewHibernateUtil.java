/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Marcel
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactoryUser;
    private static final SessionFactory sessionFactoryLogs;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactoryUser = new AnnotationConfiguration().addClass(hibernate.Usuarios.class).
                    buildSessionFactory();
            sessionFactoryLogs = new AnnotationConfiguration().addClass(hibernate.Logs.class).
                    buildSessionFactory();
        }catch (Throwable ex){
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactoryUser() {
        return sessionFactoryUser;
    }
    public static SessionFactory getSessionFactoryLogs() {
        return sessionFactoryLogs;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatemarcel;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import java.util.Properties;
import hibernatemarcel.Usuarios;
//import java.util.List;  
//import net.sf.hibernate.*;  
//import net.sf.hibernate.cfg.Configuration; 
/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Marcel
 */
public class UsuariosDAO {

    private SessionFactory factory;  
  
   public UsuariosDAO(){  
       Properties propriedades;
       propriedades = new Properties();
       propriedades.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
       propriedades.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
       propriedades.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/JWICE");
       propriedades.setProperty("hibernate.connection.username","root");
       propriedades.setProperty("hibernate.connection.password","");
       //propriedades.setProperty("Usuarios.hbm.xml"/>
       factory = new Configuration().addProperties(propriedades).addClass(hibernatemarcel.Usuarios.class)
                       .buildSessionFactory();  
       
   }       
  
   public void insert(Usuarios usuario){  
      Session session = factory.openSession();  
      session.save(usuario);  
      session.flush();  
      session.close();  
   }  
   /*
   public java.util.List getList(String condicao) throws Exception{  
      Session session = factory.openSession();  
      List amigos = session.find(condicao);  
      session.flush();  
      session.close();  
      return amigos;  
   }
    * 
    */
}

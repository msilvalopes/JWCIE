/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.*;
import org.hibernate.criterion.Expression;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Vector;
/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Marcel
 */
public class UsuariosDAO {

    private SessionFactory factory;

    public UsuariosDAO() {
        /*Properties propriedades;
        propriedades = new Properties();
        propriedades.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        propriedades.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        propriedades.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/JWICE");
        propriedades.setProperty("hibernate.connection.username", "root");
        propriedades.setProperty("hibernate.connection.password", "");
        //propriedades.setProperty("Usuarios.hbm.xml"/>*/
        try{
            factory = NewHibernateUtil.getSessionFactoryUser();
        //.addClass(hibernate.Usuarios.class).buildSessionFactory();
        }catch(Exception e){
            e.getMessage();
            return;
        }
    
    }

    public Vector validate_insert(Usuarios usuario) {
        Vector v = new Vector();        
        Session session = factory.openSession();
        List re = session.createCriteria(Usuarios.class).
                add(Expression.eq("login", usuario.getLogin())).list();
        
        if(!re.isEmpty()){
            v.add("Login já existe");
        }
        if(usuario.getSenha()==null||usuario.getSenha().equals("")){
            v.add("Digite o seu login");
        }
        
        if(usuario.getSenha()==null||usuario.getSenha().equals("")){
            v.add("Verifique sua senha/confirmação de senha");
        }
        
        if(usuario.getEmail() == null || usuario.getEmail()==""){
            v.add("Email inválido");
        }else if(!Pattern.compile(".+@.+\\.[a-z]+").matcher(usuario.getEmail()).matches()){
            v.add("Email inválido");
        }
        if(usuario.getNome() == null ||usuario.getNome().length() < 5)
            v.add("Digite seu nome completo");
        session.close();
        return v;
    }
    public List find_usuario_by_login(Usuarios usuario) {
        Session session = factory.openSession();
        List re = session.createCriteria(Usuarios.class).
                add(Expression.eq("login", usuario.getLogin()))
                .list();
        session.close();
        return re;
        
    }
    public List is_usuario(Usuarios usuario) {
        Session session = factory.openSession();
        List re = session.createCriteria(Usuarios.class).
                add(Expression.eq("login", usuario.getLogin())).
                add(Expression.eq("senha", usuario.getSenha())).list();
        session.close();
        return re;
    }
    public void insert(Usuarios usuario) {
        Session session = factory.openSession();
        session.save(usuario);
        session.flush();
        session.close();
    }

    public void update(Usuarios usuario) {
        Session session = factory.openSession();
        session.update(usuario);
        session.flush();
        session.close();
    }
    public void delete(Usuarios usuario) {
        Session session = factory.openSession();
        session.delete("Usuarios",usuario);
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

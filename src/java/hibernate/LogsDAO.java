package hibernate;

import org.hibernate.*;
import org.hibernate.criterion.Expression;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Vector;

public class LogsDAO {

    private SessionFactory factory;

    public LogsDAO() {
        try{
            factory = new NewHibernateUtil().getSessionFactoryLogs();
        }catch(Exception e){
            e.getMessage();
            return;
        }
    }

    public void insert(Logs log) {
        Session session = factory.openSession();
        session.save(log);
        session.flush();
        session.close();
    }
    /*
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

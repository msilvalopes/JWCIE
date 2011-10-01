package manager;

import hibernate.Usuarios;
import hibernate.UsuariosDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Marcel
 */
public class JWICEsession {
    private Usuarios usuario_logado;
    private HttpSession session;
    private HttpServletRequest requisicao;
    public JWICEsession(HttpServletRequest requisicao,HttpServletResponse resposta) throws IOException {
        this.requisicao = requisicao;
        session = requisicao.getSession(true);
        session.setMaxInactiveInterval(1000);
        if(null== session.getAttribute("logado")||
           !(Boolean) session.getAttribute("logado")){
            String login = (String) requisicao.getParameter("login");
            String senha = (String) requisicao.getParameter("senha");
            Usuarios user = this.valida_usuario(login,senha);
            if(null!=user){
                session.setAttribute("logado",true);
                session.setAttribute("login",login);
                session.setAttribute("senha",senha);
                session.setAttribute("mensagem","");
            }else{
                resposta.sendRedirect("/");
            }
        }else{
            String login = (String) session.getAttribute("login");
            String senha = (String) session.getAttribute("senha");
            this.valida_usuario(login,senha);
            
        }
       
    }

    private Usuarios valida_usuario(String login, String senha) {
        if(login==null || senha==null)
            return null;
        UsuariosDAO dao = new UsuariosDAO();
        Usuarios usuario = new Usuarios();
        usuario.setLogin(login);
        usuario.setarSenha(senha);
        List usuarios = dao.is_usuario(usuario);
        
        if(!usuarios.isEmpty()){
            this.usuario_logado = (Usuarios) usuarios.get(0);
            return this.usuario_logado;
        }else{
            return null;
        }
    }

    public Usuarios getUsuarioLogado() {
        return usuario_logado;
    }
    public Boolean falhou(){
        return null==this.usuario_logado;
    }
    public void encerrar(HttpServletRequest requisicao,HttpServletResponse resposta) throws IOException {
        session.setAttribute("logado",null);
        session.setAttribute("login",null);
        session.setAttribute("senha",null);
        resposta.sendRedirect("/");
    }
    public void alterar_senha(String senha){
        session.setAttribute("senha",senha);
    }
    public void setAviso(String mensagem){
        session.setAttribute("mensagem",
            ((String)session.getAttribute("mensagem")).concat("<br>".concat(mensagem)));
    }
    public String getAviso(){
        return (String)session.getAttribute("mensagem");
    }
    public String getAndClearAviso(){
        String mensagem = (String)session.getAttribute("mensagem");
        session.setAttribute("mensagem","");
        return mensagem;
    }
    public void sendAviso(){
        String mensagem;
        mensagem = getAndClearAviso();
        if(mensagem!=null&&!("".equals(mensagem)))
            requisicao.setAttribute("aviso", mensagem);
        else
            requisicao.setAttribute("aviso", "");
    }
    
    
    
    
}

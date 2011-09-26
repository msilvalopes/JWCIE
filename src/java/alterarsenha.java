/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hibernate.Usuarios;
import hibernate.UsuariosDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.JWICEsession;

/**
 *
 * @author Marcel
 */
@WebServlet(name = "alterarsenha", urlPatterns = {"/alterarsenha"})
public class alterarsenha extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JWICEsession sessao = new JWICEsession(request, response);
        if (sessao.falhou()) {
            return;
        }
        String erro = "";
        if((String)request.getParameter("senhaatual")!=null){
            String senhaN1 = (String)request.getParameter("senhanova");
            String senhaN2 = (String)request.getParameter("confsenha");
                
            Usuarios user = sessao.getUsuarioLogado();
            if(user.senhaIgual(request.getParameter("senhaatual"))){
                if(senhaN1.equals(senhaN2)){
                    if(senhaN1.length()< 6){
                        erro = "Senha nova é muito pequena";
                    }
                }else{
                    erro = "Confirmação de senha está incorreta";
                }
            }else{
                erro = "Senha atual incorreta";
            }
            if("".equals(erro)){
                user.setarSenha(senhaN2);
                UsuariosDAO dao = new UsuariosDAO();
                dao.update(user);
                sessao.alterar_senha(senhaN1);
                response.sendRedirect("/logado");
                return;
            }
        }
        request.setAttribute("usuario", sessao.getUsuarioLogado());
        request.setAttribute("erro", erro);
        request.getRequestDispatcher("alterar_senha.jsp").forward(request, response);

    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

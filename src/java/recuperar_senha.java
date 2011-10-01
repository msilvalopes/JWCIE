/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hibernate.UsuariosDAO;
import hibernate.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.Utils;

/**
 *
 * @author Marcel
 */
@WebServlet(name = "recuperar_senha", urlPatterns = {"/recuperar_senha"})
public class recuperar_senha extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = (String)request.getParameter("login");
        if(login!=null&&!("".equals(login))){
            System.gc();
            UsuariosDAO dao = new UsuariosDAO();
            Usuarios usu = new Usuarios();
            usu.setLogin(login);
            List usuarios = dao.find_usuario_by_login(usu);
            if(!usuarios.isEmpty()){
                usu = (Usuarios)usuarios.get(0);
                System.out.print("asd");
                String senha = Utils.get_random_password();
                usu.setarSenha(senha);
                
                MailSender.postMail("Sua nova senha é: '".concat(senha).concat("' (sem aspas)"),
                                    usu.getEmail(),
                                    "Nova Senha do JWICE");
                dao.update(usu);
                request.setAttribute("erros", "Sua senha será enviada por email - ".concat(senha));
            }else{
                request.setAttribute("erros", "Seu login não existe");
            }
            System.gc();
            
        }
        System.gc();
        request.getRequestDispatcher("recuperar_senha.jsp").forward(request, response);

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

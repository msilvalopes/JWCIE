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
@WebServlet(name = "editar", urlPatterns = {"/editar"})
public class editar extends HttpServlet {

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
        if((String)request.getParameter("email")!=null){
            Usuarios user = sessao.getUsuarioLogado();
            UsuariosDAO dao = new UsuariosDAO();
            user.setEmail((String)request.getParameter("email"));
            user.setNome((String)request.getParameter("nome"));
            dao.update(user);
            response.sendRedirect("/logado");
        }else{
            request.setAttribute("usuario", sessao.getUsuarioLogado());
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
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

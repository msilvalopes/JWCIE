/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.DiretorioManager;
import manager.JWICEsession;
import org.apache.commons.fileupload.*;
import javax.servlet.Servlet;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.IOException;
import manager.ImagemGestor;

/**
 *
 * @author Marcel
 */
@WebServlet(name = "send", urlPatterns = {"/send"})
public class send extends HttpServlet implements Servlet {

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
        DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
        boolean isMultiPart = FileUpload.isMultipartContent(request);
        if (isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                FileItemIterator items = upload.getItemIterator(request);
                //Iterator iter = items.iterator();
                while (items.hasNext()) {
                    FileItemStream item = items.next();
                    if (!item.isFormField()) {
                        String novo = dir.add_file(item);
                        ImagemGestor imagem;
                        try{
                            imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
                        }catch(Exception e){
                            imagem = null;
                        }
                        if(imagem==null){
                            sessao.setAviso("Imagem invalida");
                            dir.deleteFile(novo);
                            if(dir.fileExists(novo))
                                sessao.setAviso("Apague o arquivo por favor.");
                            response.sendRedirect("/logado");
                        }else
                            response.sendRedirect("/editar_arquivo?arquivo=".concat(novo));
                        return;
                    }
                }

            } catch (FileUploadException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        request.setAttribute(
                "usuario", sessao.getUsuarioLogado());
        request.getRequestDispatcher(
                "send.jsp").forward(request, response);

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

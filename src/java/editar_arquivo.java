/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.DiretorioManager;
import manager.ImagemGestor;
import manager.JWICEsession;
import manager.Utils;

/**
 *
 * @author Marcel
 */
@WebServlet(name = "editar_arquivo", urlPatterns = {"/editar_arquivo"})
public class editar_arquivo extends HttpServlet {

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
        
        Integer tresh = Utils.str_to_int((String)request.getParameter("toBeP"));
        Integer brilho = Utils.str_to_int((String)request.getParameter("brilho"));
        Float contraste = Utils.str_to_float((String)request.getParameter("contraste"));
        
        if(contraste !=null){
           DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
            ImagemGestor imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
            if(imagem.valida()){
                imagem.contrast(contraste);
                imagem.salvar();
                sessao.setAviso("Alterado o Contraste");
                response.sendRedirect("/logado");
                return;
            }else{
                sessao.setAviso("Falha na deteção do arquivo");
                response.sendRedirect("/logado");
                return;
            }
         
        }else if(brilho !=null){
           DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
            ImagemGestor imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
            if(imagem.valida()){
                imagem.brilho(brilho);
                imagem.salvar();
                sessao.setAviso("Alterado o Brilho");
                response.sendRedirect("/logado");
                return;
            }else{
                sessao.setAviso("Falha na deteção do arquivo");
                response.sendRedirect("/logado");
                return;
            }
         
        }else if(tresh !=null){
            DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
            ImagemGestor imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
            if(imagem.valida()){
                imagem.binarizar(tresh);
                imagem.salvar();
                sessao.setAviso("Imagem Binarizada");
                response.sendRedirect("/logado");
                return;
            }else{
                sessao.setAviso("Falha na deteção do arquivo");
                response.sendRedirect("/logado");
                return;
            }
            
        }else if((String)request.getParameter("grayscale")!=null){
            DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
            ImagemGestor imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
            if(imagem.valida()){
                imagem.tons_de_cinza();
                imagem.salvar();
                sessao.setAviso("Imagem Convertida para escala de cinza");
                response.sendRedirect("/logado");
                return;
            }else{
                sessao.setAviso("Falha na deteção do arquivo");
                response.sendRedirect("/logado");
                return;
            }
        }else if((String)request.getParameter("sepia")!=null){
            DiretorioManager dir = new DiretorioManager(sessao.getUsuarioLogado().getLogin());
            ImagemGestor imagem = new ImagemGestor(dir.getFile((String)request.getParameter("arquivo")));
            if(imagem.valida()){
                imagem.converter_para_sepia();
                imagem.salvar();
                sessao.setAviso("Imagem Convertida para sepia");
                response.sendRedirect("/logado");
                return;
            }else{
                sessao.setAviso("Falha na deteção do arquivo");
                response.sendRedirect("/logado");
                return;
            }
        }else{
            request.setAttribute("usuario", sessao.getUsuarioLogado());
            request.setAttribute("arquivo", (String)request.getParameter("arquivo"));
            request.getRequestDispatcher("editar_imagem.jsp").forward(request, response);
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

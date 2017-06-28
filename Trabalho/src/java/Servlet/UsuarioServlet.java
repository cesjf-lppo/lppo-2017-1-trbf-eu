/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author savio
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario/Criar","/Usuario/Editar", "/Usuario/Listar", "/Usuario/Excluir"})
public class UsuarioServlet extends HttpServlet {
    @PersistenceUnit(unitName = "TrabalhoPU")
    EntityManagerFactory emf;

    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getServletPath().contains("/Criar"))
            CriarUsuario(request,response);
        else
            response.sendError(500);
    }
    
    private void CriarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            request.getRequestDispatcher("WEB-INF/Usuario/criar.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            response.sendRedirect("index.html");

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // todo
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

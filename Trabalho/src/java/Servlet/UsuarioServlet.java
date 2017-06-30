/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.EtiquetaJpaController;
import Controller.UsuarioJpaController;
import Entidade.Etiqueta;
import Entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            redirecionaCriarUsuario(request,response);
        else if (request.getServletPath().contains("/Listar"))
            redirecionaListarUsuarios(request,response);
        else if (request.getServletPath().contains("/Editar"))
            redirecionarEditarUsuario(request,response);
        else if (request.getServletPath().contains("/Excluir"))
            ExcluirUsuario(request,response);
        else
            response.sendError(500);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getServletPath().contains("/Criar"))
            CriarUsuario(request,response);
        else if (request.getServletPath().contains("/Editar"))
            EditarUsuario(request,response);
    }
    
    private void redirecionaCriarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            request.getRequestDispatcher("/WEB-INF/Usuario/criar.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            response.sendRedirect("index.html");

        }
    }

    private void CriarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Usuario novoUsuario = new Usuario();
        UsuarioJpaController servicoUsuario = new UsuarioJpaController(ut, emf);
        
        novoUsuario.setEmail(request.getParameter("email"));
        novoUsuario.setNomeCompleto(request.getParameter("nome"));
        novoUsuario.setSenha(request.getParameter("senha"));
        
        try
        {
            servicoUsuario.create(novoUsuario);
            response.sendRedirect("Listar");
        }
        catch (Exception erro)
        {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, erro);
        }
    }

    private void redirecionaListarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Usuario> usuarios = new ArrayList();
        UsuarioJpaController servico = new UsuarioJpaController(ut, emf);
        
        
        usuarios = servico.findUsuarioEntities();
        request.setAttribute("usuarios", usuarios);
        try
        {
            request.getRequestDispatcher("/WEB-INF/Usuario/listar.jsp").forward(request, response);
        }
        catch (Exception erro)
        {
            response.sendRedirect("index.html");
        }
    }

    private void redirecionarEditarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        UsuarioJpaController servico = new UsuarioJpaController(ut, emf);
        Long id = Long.parseLong(request.getParameter("matricula"));
        Usuario usuario = servico.findUsuario(id);
        
        try
        {
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/WEB-INF/Usuario/editar.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            response.sendRedirect("index.html");

        }
    }

    private void EditarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        UsuarioJpaController servico = new UsuarioJpaController(ut, emf);
        Long id = Long.parseLong(request.getParameter("matricula"));
        
        Usuario usuario = servico.findUsuario(id);
        usuario.setEmail(request.getParameter("email"));
        usuario.setNomeCompleto(request.getParameter("nome"));
        
        try
        {
            servico.edit(usuario);
            response.sendRedirect("Listar");
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
    }

    private void ExcluirUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        UsuarioJpaController servico = new UsuarioJpaController(ut, emf);
        Long id = Long.parseLong(request.getParameter("matricula"));
        
        try
        {
            servico.destroy(id);
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
        finally
        {
            response.sendRedirect("Listar");
        }
    }
}

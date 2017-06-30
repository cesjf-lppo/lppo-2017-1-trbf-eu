/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.EtiquetaJpaController;
import Controller.UsuarioJpaController;
import Controller.exceptions.RollbackFailureException;
import Entidade.Etiqueta;
import Entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "EtiquetaController", urlPatterns = {"/Etiqueta/Criar", "/Etiqueta/Listar", "/Etiqueta/Editar","/Etiqueta/Excluir","/Etiqueta/FiltrarUsua"})
public class EtiquetaServlet extends HttpServlet {
    @PersistenceUnit(unitName = "TrabalhoPU")
    EntityManagerFactory emf;

    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getServletPath().contains("/Criar"))
            requisitarCriarEtiqueta(request,response);
        else if (request.getServletPath().contains("/Listar"))
            requisitarListaEtiqueta(request, response);
        else if (request.getServletPath().contains("/Editar"))
            requisitarEditarEtiqueta(request, response);
        else if (request.getServletPath().contains("/Excluir"))
            ExcluirEtiqueta(request, response);
        else if (request.getServletPath().contains("/FiltrarUsua"))
            FiltrarUsuario(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getServletPath().contains("/Criar"))
            CriarEtiqueta(request,response);
    }

    private void requisitarCriarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        UsuarioJpaController servico = new UsuarioJpaController(ut, emf);
        List<Usuario> usuarios = new ArrayList();
        
        usuarios = servico.findUsuarioEntities();
        
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/WEB-INF/Etiqueta/criar.jsp").forward(request, response);
    }

    private void CriarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        Etiqueta etiqueta = new Etiqueta();
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        UsuarioJpaController servicoUsuario = new UsuarioJpaController(ut, emf);
        
        etiqueta.setTitulo(request.getParameter("titulo"));
        etiqueta.setAutor(servicoUsuario.findUsuario(Long.parseLong(request.getParameter("usuario"))));
        
        try
        {
            servico.create(etiqueta);
            response.sendRedirect("Listar");
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
    }

    private void requisitarListaEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        UsuarioJpaController servicoUsuario = new UsuarioJpaController(ut, emf);
        
        Etiqueta etiqueta = new Etiqueta();
        List<Etiqueta> etiquetas = servico.findEtiquetaEntities();
        List<Usuario> usuarios = servicoUsuario.findUsuarioEntities();
        
        try
        {
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("etiquetas", etiquetas);
            request.getRequestDispatcher("/WEB-INF/Etiqueta/listar.jsp").forward(request, response);
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
    }

    private void requisitarEditarEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        Etiqueta etiqueta = servico.findEtiqueta(Long.parseLong(request.getParameter("id")));
        
        try
        {
            request.setAttribute("etiqueta", etiqueta);
            request.getRequestDispatcher("/WEB-INF/Etiqueta/editar.jsp").forward(request, response);
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
    }

    private void ExcluirEtiqueta(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        try
        {
            servico.destroy(Long.parseLong(request.getParameter("id")));
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

    private void FiltrarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        UsuarioJpaController usuarioServico = new UsuarioJpaController(ut, emf);
        
        List<Usuario> usuarios = usuarioServico.getUsuariocomEtiqueta();
        List<Etiqueta> etiquetas = servico.getEtiquetaPorAutor(Long.parseLong(request.getParameter("usuario")));
        
        
        try
        {
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("etiquetas", etiquetas);
            request.getRequestDispatcher("/WEB-INF/Etiqueta/listar.jsp").forward(request, response);
        }
        catch (Exception erro)
        {
            response.sendRedirect("Listar");
        }
    }
}

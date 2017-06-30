/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.EtiquetaJpaController;
import Controller.TarefaJpaController;
import Controller.UsuarioJpaController;
import Entidade.Etiqueta;
import Entidade.Tarefa;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "TarefaServlet", urlPatterns = {"/Tarefa/Criar","/Tarefa/Editar", "/Tarefa/Listar", "/Tarefa/Excluir"})
public class TarefaServlet extends HttpServlet {
    @PersistenceUnit(unitName = "TrabalhoPU")
    EntityManagerFactory emf;

    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if (request.getServletPath().contains("/Criar"))
            requisitarCriarTarefa(request,response);
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
            throws ServletException, IOException 
    {
        if (request.getServletPath().contains("/Criar"))
            try {
                CriarTarefa(request,response);
        } catch (ParseException ex) {
            Logger.getLogger(TarefaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void requisitarCriarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        List<Etiqueta> etiquetas = servico.getEtiquetaPorAutor(Long.parseLong(String.valueOf(3)));
        
        request.setAttribute("etiquetas", etiquetas);
        
        request.getRequestDispatcher("/WEB-INF/Tarefa/criar.jsp").forward(request, response);
    }

    private void CriarTarefa(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException 
    {
        Tarefa tarefa  = new Tarefa();
        Etiqueta etiqueta = new Etiqueta();
        UsuarioJpaController usuarioServico = new UsuarioJpaController(ut, emf);
        EtiquetaJpaController etiquetaServico = new EtiquetaJpaController(ut, emf);
        TarefaJpaController tarefaServico = new TarefaJpaController(ut, emf);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        
            Date data = format.parse(request.getParameter("dataparaconclusao"));
        
        
        etiqueta = etiquetaServico.findEtiqueta(Long.parseLong(request.getParameter("etiqueta")));
        tarefa.setDataConclusao(data);
        tarefa.setDescricao(request.getParameter("descricao"));
        tarefa.setTitulo(request.getParameter("titulo"));
        tarefa.setEtiqueta(etiqueta);
        
        try
        {
            tarefaServico.create(tarefa);
        }
        catch(Exception erro)
        {
            response.sendRedirect("/Trabalho/Inicio");
        }
        finally
        {
            response.sendRedirect("/Trabalho/Inicio");
        }
        
    }
}

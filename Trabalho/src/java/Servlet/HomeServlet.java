/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controller.EtiquetaJpaController;
import Controller.TarefaJpaController;
import Entidade.Etiqueta;
import Entidade.Tarefa;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author savio
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/Inicio"})
public class HomeServlet extends HttpServlet 
{
    @PersistenceUnit(unitName = "TrabalhoPU")
    EntityManagerFactory emf;
    
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EtiquetaJpaController servico = new EtiquetaJpaController(ut, emf);
        TarefaJpaController tarefaServico = new TarefaJpaController(ut, emf);
        
        List<Tarefa> tarefas = tarefaServico.findTarefaEntities();
        List<Etiqueta> etiquetas = servico.getEtiquetaPorAutor(Long.parseLong(String.valueOf(3)));
        
        request.setAttribute("tarefas", tarefas);
        request.setAttribute("etiquetas", etiquetas);
        
        request.getRequestDispatcher("WEB-INF/inicio.jsp").forward(request,response);
//        HttpSession sessao = request.getSession();
//        if(sessao.getAttribute("usuario") == null)
//        {
//            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("WEB-INF/inicio.jsp").forward(request,response);
    }

}

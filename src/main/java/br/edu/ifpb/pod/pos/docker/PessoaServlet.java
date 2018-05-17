/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.pos.docker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

/**
 *
 * @author jose
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/Pessoas"})
public class PessoaServlet extends HttpServlet {
private Pessoas pessoas;

    public PessoaServlet() throws ClassNotFoundException {
        this.pessoas = new Pessoas();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PessoaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            imprime(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        try {
            String nome = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            pessoas.salvar(Pessoa.of(nome, cpf));
            resp.sendRedirect("/app/Pessoas");
        } catch (Exception e) {
        }
    }
    
    
    private void imprime(PrintWriter out) {
    List<Pessoa> lista = pessoas.todos();
    lista.forEach(c->out.print("<p>"+c.getNome()+"</p>"));
    }

} 


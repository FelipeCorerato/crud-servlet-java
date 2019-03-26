package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BDSQLServer;
import bd.daos.*;
import bd.dbos.*;

/**
 * Servlet implementation class Incluir
 */
@WebServlet("/Cadastro")
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Incluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			float preco = Float.parseFloat(request.getParameter("preco"));
			
			Livro livro = new Livro(codigo, nome, preco);
			
			Livros.incluir(livro);
			
			// response.getWriter().append("Served at: ").append(request.getContextPath());
			response.sendRedirect("Sucesso.html");
			
		} catch(Exception e) {
			response.sendRedirect("Erro.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.daos.Livros;
import bd.dbos.Livro;

/**
 * Servlet implementation class Alterar
 */
@WebServlet("/Alterar")
public class Alterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alterar() {
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
			
			Livros.alterar(livro);
			
			// response.getWriter().append("Served at: ").append(request.getContextPath());
			response.getWriter().append("<label style=\"color: green\">Sucesso!</label>");
			
		} catch(Exception e) {
			response.getWriter().append("<label style=\"color: red\">" 
					+ e.getMessage() + "</label>");
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

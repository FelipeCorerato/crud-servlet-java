package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import bd.daos.Livros;

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			MeuResultSet tabela = Livros.getLivros();
	        while(tabela.next())
	        {
	        	response.getWriter().append(Integer.toString(tabela.getInt("codigo")));
	        	response.getWriter().append(tabela.getString("nome"));
	        	response.getWriter().append(String.format("%.2f", tabela.getFloat("preco")));
			}
		} catch (Exception e) {
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
	
	protected String listItem(int codigo, String nome, float preco) {
		return "  <div class=\"row\">\r\n" + 
				"    <div class=\"col s12 m6\">\r\n" + 
				"      <div class=\"card blue-grey darken-1\">\r\n" + 
				"        <div class=\"card-content white-text\">\r\n" + 
				"          <span class=\"card-title\">" + nome + "</span>\r\n" + 
				"          <p>I am a very simple card. I am good at containing small bits of information.\r\n" + 
				"          I am convenient because I require little markup to use effectively.</p>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"card-action\">\r\n" + 
				"          <a href=\"#\">This is a link</a>\r\n" + 
				"          <a href=\"#\">This is a link</a>\r\n" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>"
	}

}

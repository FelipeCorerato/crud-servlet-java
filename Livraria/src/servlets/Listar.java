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
import html.HTMLContent;

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
			response.getWriter().append(HTMLContent.htmlHeader);
			
			MeuResultSet tabela = Livros.getLivros();
			
	        while(tabela.next()) {
	        	response.getWriter().append(this.listarLivro(tabela.getInt("codigo"), tabela.getString("nome"), tabela.getFloat("preco")));
			}
		} catch (Exception e) {
			response.getWriter().append("<h4 class=\"red-text\">" 
					+ e.getMessage() + "</h4>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected String listarLivro(int codigo, String nome, float preco) {
		return 	"  <div class=\"row\">\r\n" + 
				"    <div class=\"col s12 m12 l12\">\r\n" + 
				"      <div class=\"card blue-grey darken-1\">\r\n" + 
				"        <div class=\"card-content white-text\">\r\n" + 
				"          <span class=\"card-title\">" + nome + "</span>\r\n" + 
				"          <p>Código: " + codigo +"</p>\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"card-action\">\r\n" + 
				"          <a>$" + preco + "</a>" + 
				"        </div>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>";
	}

}

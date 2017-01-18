

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.commerce.Article;
import org.commerce.ArticleRemote;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List panier;

	@EJB
	private ArticleRemote article;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> l = (List<Article>) article.getAllArticle();
		HttpSession hs = request.getSession();
		if(hs.getAttribute("currency") == null) 
			hs.setAttribute("currency", "EUR");
		if(!l.isEmpty()) {
			if(hs.getAttribute("currency").equals("USD")) { 
				for(Article liste :l) {
					liste.setPrix(liste.getPrix() * 1.07);
				}
			}
			request.setAttribute("produits", l);
		}
		request.setAttribute("title", "Accueil");
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

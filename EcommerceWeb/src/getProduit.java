import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.commerce.Article;
import org.commerce.ArticleRemote;

/**
 * Servlet implementation class getProduit
 */
@WebServlet("/getProduit")
public class getProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ArticleRemote article;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma", "no-cache");
		
		if (request.getParameter("type").equals("homme")) {
			List<Article> l = article.getArticle("homme");
			System.out.println(l.get(0));
			if (!l.isEmpty()) {
				if(request.getSession().getAttribute("currency").equals("USD")) { 
					for(Article liste :l) {
						liste.setPrix(liste.getPrix() * 1.07);
					}
				}
				request.setAttribute("montres", l);
			}
			request.setAttribute("title", "Montres hommes");
			getServletContext().getRequestDispatcher("/getProduitType.jsp").forward(request, response);

		} else if (request.getParameter("type").equals("femme")) {
			List<Article> l = article.getArticle("femme");
			if (!l.isEmpty()) {
				if(request.getSession().getAttribute("currency").equals("USD")) { 
					for(Article liste :l) {
						liste.setPrix(liste.getPrix() * 1.07);
					}
				}
				request.setAttribute("montres", l);
			}
			request.setAttribute("title", "Montres femmes");
			getServletContext().getRequestDispatcher("/getProduitType.jsp").forward(request, response);

		} else
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

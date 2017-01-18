

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.commerce.Article;
import org.commerce.ArticleRemote;

/**
 * Servlet implementation class AfficherProduit
 */
@WebServlet("/AfficherProduit")
public class AfficherProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private ArticleRemote article;
    Article a;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		a = article.getSingleArticle(Integer.parseInt(request.getParameter("id")));
		if(a == null) {
			response.sendRedirect("");
		}
		else {
			if(request.getSession().getAttribute("currency").equals("USD")) { 
				
				a.setPrix(a.getPrix() * 1.07);
			}
			request.setAttribute("article", a);
			getServletContext().getRequestDispatcher("/AfficherProduit.jsp").forward(request, response);
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.commerce.UtilisateurRemote;

/*
 * Servlet implementation class AddServlet
 */
@WebServlet("/inscription")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UtilisateurRemote user;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setHeader("/inscription", "inscription.jsp");
		//jsp.forward(request, response);
		request.setAttribute("title", "Inscription");
		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}
	
	private static SecretKeySpec getKey(String secretKey) {
	    MessageDigest digest = null;
	    try {
	        digest = MessageDigest.getInstance("MD5");
	 
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    }
	 
	    try {
	        return new SecretKeySpec(digest.digest(new String(secretKey.getBytes(),"UTF8").getBytes()), "AES");
	    }
	    catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private static String chiffrer(String s) {
        String encrypted = null;
        try {
           // Instantiate the cipher
           Cipher cipher = Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE, getKey("testduhash"));
           // Récupère la clé secrète
            byte[] cipherText = cipher.doFinal(s.getBytes("ISO-8859-1"));
            encrypted = new String(cipherText);
        }
        catch (Exception e) {
            System.out.println("Impossible to encrypt with AES algorithm: string=(" + s + ")");
        }
        return encrypted;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = String.valueOf(request.getParameter("nom"));
		String prenom = String.valueOf(request.getParameter("prenom"));
		String email = String.valueOf(request.getParameter("email"));
		String mdp = String.valueOf(request.getParameter("mdp"));
		String confirmMdp = String.valueOf(request.getParameter("confirmMdp"));
		String numRue = String.valueOf(request.getParameter("numRue"));
		String rue = String.valueOf(request.getParameter("rue"));
		String ville = String.valueOf(request.getParameter("ville"));
		String codePostal = String.valueOf(request.getParameter("codePostal"));
		String pays = String.valueOf(request.getParameter("pays"));
		String tel = String.valueOf(request.getParameter("tel"));
		user.CreateInscription(nom, prenom, email, chiffrer(mdp), numRue, rue, ville, codePostal, pays, tel,"client");

		response.sendRedirect(request.getHeader("referer"));
	}
}
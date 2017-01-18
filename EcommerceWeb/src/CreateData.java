
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.commerce.ArticleRemote;
import org.commerce.UtilisateurRemote;

/**
 * Servlet implementation class CreateData
 */
@WebServlet("/createData")
public class CreateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UtilisateurRemote user;

	@EJB
	private ArticleRemote article;

	// private ArticleRemote article;

	private static SecretKeySpec getKey(String secretKey) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		try {
			return new SecretKeySpec(digest.digest(new String(secretKey.getBytes(), "UTF8").getBytes()), "AES");
		} catch (UnsupportedEncodingException e) {
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
			// R�cup�re la cl� secr�te
			byte[] cipherText = cipher.doFinal(s.getBytes("ISO-8859-1"));
			encrypted = new String(cipherText);
		} catch (Exception e) {
			System.out.println("Impossible to encrypt with AES algorithm: string=(" + s + ")");
		}
		return encrypted;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		user.CreateInscription("PAMART", "nicolas", "pamart.nicolas@free.fr", chiffrer("1234"), "15",
				"rue de querenaing", "famars", "59300", "france", "0808080808","admin");
		user.CreateInscription("JEAN", "mogan", "morgan@gmail.com", chiffrer("1234"), "16", "rue untel",
				"la madeleine", "59000", "france", "0685962545","client");
		user.CreateInscription("DUMOULIN", "maxime", "maxime@gmail.com", chiffrer("1234"), "16", "rue blabla",
				"maubeuge", "59600", "france", "0652418675","client");

		article.createArticle("Machine Chronograph Dark Brown Leather Watch", "homme",
				"Le meilleur du design industriel : le bo�tier surdimensionn� de la montre Machine et ses compteurs inspir�s de l'a�ronautique misent sur un style r�solument masculin.",
				159.00,0);
		article.createArticle("Montre Nate chronographe en cuir brun", "homme",
				"Cette saison, un magnifique cadran bleu et des index blancs apportent un nouveau niveau de sophistication � notre fameuse montre Nate. ",
				159.00,3);
		article.createArticle("Montre Nate chronographe en cuir beige", "homme",
				"Nous avons d�cid� de rendre la montre Nate encore plus surprenante avec un nouveau mouvement chronographe et un design qui attire tous les regards",
				149.99,5);
		article.createArticle("MONTRE CONNECT�E HYBRIDE FOSSIL Q EN SILICONE BLEU", "homme",
				"D�couvrez notre Fossil Q Crewmaster, une montre connect�e hybride inspir�e par l'univers de la navigation, qui associe design analogique et connectivit�.  ",
				199.99,5);
		article.createArticle("MONTRE CONNECT�E HYBRIDE FOSSIL Q TAILOR EN CUIR BLEU MARINE", "femme",
				"D�couvrez notre Fossil Q Tailor, une montre connect�e hybride qui associe design analogique et connectivit�. Dot�e de la nouvelle technologie connect�e, cette montre incontournable est toujours active gr�ce � une pile d'une dur�e de vie de six mois.",
				199.99,10);
		article.createArticle("MONTRE CONNECT�E FOSSIL Q WANDER � �CRAN TACTILE EN CUIR BRUN CLAIR", "femme",
				"La Fossil Q Wander est notre toute derni�re montre � �cran tactile et se connecte facilement � votre t�l�phone. Elle est dot�e d'un bracelet en cuir de qualit� et d'un cadran personnalisable.",
				249.99,15);
		article.createArticle("MONTRE TAILOR MULTIFONCTION EN CUIR BLEU", "femme",
				"Cette saison, le bleu est de mise ! Le design minimaliste du mod�le Tailor offre un style incomparable avec un bracelet classique en cuir bleu dot� d'un cadran assorti.",
				139.99,5);
		response.sendRedirect("");

	}

}

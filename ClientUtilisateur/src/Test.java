import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.commerce.UtilisateurStateless;
import org.commerce.UtilisateurRemote;

public class Test {

	public static void main(String[] args) throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        // EAR
        final String appName = "EcommerceEAR";
        // JAR
        final String moduleName = "Utilisateur";
        
        final String distinctName = "";
        
        final String beanName = UtilisateurStateless.class.getSimpleName();

        final String viewClassName = UtilisateurRemote.class.getName();
        
        UtilisateurRemote cr = (UtilisateurRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        System.out.println("toto");
        //System.out.println(cr.CreateInscription("morgan","moutawakil","samir.@gmail.com","toto"));
        

	}

}

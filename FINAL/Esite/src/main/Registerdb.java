package main;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registerdb
 */
@WebServlet("/Registerdb")
public class Registerdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerdb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom;
		String nom;
		String pseudo=null;
		String mail;
		String addresse;
		String ville;
		String pass;
		String okpass;
		
		prenom = request.getParameter("prenom");
		nom = request.getParameter("nom");
		pseudo = request.getParameter("pseudo");
		mail = request.getParameter("mail");
		addresse = request.getParameter("addr");
		ville = request.getParameter("ville");
		pass = request.getParameter("password");
		okpass = request.getParameter("okpassword");
		
		//System.out.println("pass : "+pass);
		//System.out.println("okpass : "+okpass)
;		
		if(pass.equals(okpass)){ //Vérifie que les deux mdp saisie sont les mêmes
			UserBean user=new UserBean(prenom,nom,pseudo,mail,addresse,ville,pass);
			if (Connexion.newUser(user)==true){
				System.out.println("Insertion réusi");	
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	            requestDispatcher.forward(request, response);
			}else{
				System.out.println("ECHEC !");
			}
		}	
	}
}

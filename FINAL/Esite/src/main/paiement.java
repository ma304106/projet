package main;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class paiement
 */
@WebServlet("/paiement")
public class paiement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paiement() {
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
		String shipaddr;
		String billaddr;
		String shipville;
		String billville;
		String shipcp;
		String billcp;
		String paytype = "paypal";
		String sum=Connexion.sommePanier((String)request.getSession().getAttribute("id"));
			
		shipaddr = request.getParameter("shipaddr");
		billaddr = request.getParameter("billaddr");
		shipville = request.getParameter("shipville");
		billville = request.getParameter("billville");
		shipcp = request.getParameter("shipcp");
		billcp = request.getParameter("billcp");

		System.out.println("Addresse Livraison :"+shipaddr);
		System.out.println("Addresse paiement :"+billaddr);
		System.out.println("Ville Livraison :"+shipville);
		System.out.println("Ville Paiement :"+billville);
		System.out.println("Code postal Livraison :"+shipcp);
		System.out.println("Code postalPaiement :"+billcp);
		System.out.println("Type paiement :"+paytype);
		System.out.println("Somme commande :"+sum);
		
		java.sql.Connection conn = Connexion.newConnexion();
		java.sql.PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement("INSERT INTO `commande`(`total`, `addrlivraison`, `addrfacturation`, `villelivraison`, `villefacturation`, `cplivraison`, `cpfacturation`, `typecarte`) VALUES (?,?,?,?,?,?,?,?)");
			
			pst.setString(1,sum);
			pst.setString(2,shipaddr); 
			pst.setString(3,billaddr);
			pst.setString(4,shipville);
			pst.setString(5,billville);
			pst.setString(6,shipcp);
			pst.setString(7,billcp);
			pst.setString(8,paytype);
			
			pst.execute();
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
}

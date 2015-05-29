package main;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCart() {
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
		
		try {
			HttpSession session = request.getSession();
			
			String id_client = (String)session.getAttribute("id");
			String red = request.getParameter("Lorel Ipsum Red");
			
			Connection conn = Connexion.newConnexion();
			
			/*  Essaie de récuperer le prix via un requete mais le setstring envoie un null
			PreparedStatement stamt = conn.prepareStatement("SELECT * FROM `articles` WHERE `nom`=?");
			stamt.setString(1,red);
			System.out.println(stamt);
			ResultSet rs = stamt.executeQuery();
			System.out.println(rs);
			
			String prix = rs.getString(3);
			*/
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO panier (mail_client,nom_article,prix) VALUES (?,?,?)");
			stmt.setString(1,id_client);
			stmt.setString(2,"Lorel Ipsum Red");
			stmt.setString(3,"70");
			System.out.println(stmt);
			stmt.execute();
			
			System.out.println("Articles bien ajouter");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("apparel.jsp");
            requestDispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}

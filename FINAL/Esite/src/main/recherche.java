package main;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class recherche
 */
@WebServlet("/recherche")
public class recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public recherche() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String rechercher = request.getParameter("search");
		ResultSet rs = null;

		java.sql.Connection conn = Connexion.newConnexion();
		researchBean fatigue = new researchBean(rechercher);
		java.sql.PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement("SELECT * FROM articles WHERE nom=?");
			pst.setString(1, rechercher);
			rs = pst.executeQuery();

			if (rs.next()) {
				fatigue.setRef(rs.getString(1));
				fatigue.setNom(rs.getString(2));
				fatigue.setPrix(rs.getString(3));
				fatigue.setTaille(rs.getString(4));
				fatigue.setQte(rs.getString(5));
				fatigue.setGenre(rs.getString(6));
				fatigue.setUrl(rs.getString(7));

				HttpSession session = request.getSession(false); // Tant quel'utilisateurn'est pas déconnecter la recherche est sauvegardée
				if (session != null) {
					session.setAttribute("ref", fatigue.getRef());
					session.setAttribute("nom", fatigue.getNom());
					session.setAttribute("prix", fatigue.getPrix());
					session.setAttribute("taille", fatigue.getTaille());
					session.setAttribute("qte", fatigue.getQte());
					session.setAttribute("genre", fatigue.getGenre());
					session.setAttribute("setUrl", fatigue.getUrl());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

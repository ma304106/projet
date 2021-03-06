package main;

import java.sql.*;
import java.util.ArrayList;

public class Connexion {

	public static Connection newConnexion() {

		java.sql.Connection conn = null;

		String url = "jdbc:mysql://mysql-asura.alwaysdata.net/";
		String dbName = "asura_ecommerce";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "asura";
		String password = "idontcare";

		try {
			Class.forName(driver).newInstance();
			conn = java.sql.DriverManager.getConnection(url + dbName, userName,
					password);

			if (conn != null) {
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean Signin(String username, String password) {

		Boolean in = false;
		try {
			java.sql.Connection conn = newConnexion();
			ResultSet rs = null;

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM  `client` WHERE  `mail` LIKE ? AND  `mdp` LIKE ?;"); // V�rifie les identifiants
			System.out.println("Name :" + username);
			System.out.println("mdp: " + password);
			stmt.setString(1, username); // Remplace les '?' par les valeurs passez en parametres
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			in = rs.next();

			// System.out.println("mail : "+rs.getString(6));
			// System.out.println("mot de passe : "+rs.getString(7));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return in;
	}

	public static boolean newUser(UserBean user) {
		try {
			java.sql.Connection conn = newConnexion();
			java.sql.PreparedStatement pst = null;

			// Enregistre un client dans la base de donn�e
			pst = conn.prepareStatement("INSERT INTO `asura_ecommerce`.`client` (`nom`, `prenom`, `pseudo` , `adresse`, `ville`, `mail`, `mdp`) VALUES (?,?,?,?,?,?,?);");
			pst.setString(1, user.getNom());
			pst.setString(2, user.getPrenom());
			pst.setString(3, user.getPseudo());
			pst.setString(4, user.getAddresse());
			pst.setString(5, user.getVille());
			pst.setString(6, user.getMail());
			pst.setString(7, user.getPass());

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static String nbArticle(String user) {

		try {
			String nbarticles = null;
			java.sql.Connection conn = newConnexion();
			java.sql.PreparedStatement pst = null;
			ResultSet rs = null;

			pst = conn
					.prepareStatement("SELECT COUNT(mail_client) FROM  `panier` WHERE mail_client=?");
			pst.setString(1, user);

			rs = pst.executeQuery();
			if (rs.next()) { // Si �a retourne un r�sultat
				nbarticles = rs.getString(1);
			}
			return nbarticles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String sommePanier(String user) {

		try {
			String somme = null;
			java.sql.Connection conn = newConnexion();
			java.sql.PreparedStatement pst = null;
			ResultSet rs = null;

			pst = conn
					.prepareStatement("SELECT SUM(prix) FROM  `panier` WHERE mail_client=?");
			pst.setString(1, user);

			rs = pst.executeQuery();
			if (rs.next()) { // Si �a retourne un r�sultat
				somme = rs.getString(1);
			}
			return somme;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> panierClient(String user) {
		try {
			ArrayList<String> panier = new ArrayList<String>();
			java.sql.Connection conn = newConnexion();
			java.sql.PreparedStatement pst = conn
					.prepareStatement("SELECT nom_article,prix FROM panier WHERE mail_client=?");
			ResultSet rs = null;

			pst.setString(1, user);
			rs = pst.executeQuery();

			while (rs.next()) {
				ResultSetMetaData data = rs.getMetaData();
				int col = data.getColumnCount();
				for (int i = 1; i <= col; i++) {
					panier.add(rs.getString(i));
				}
			}
			return panier;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
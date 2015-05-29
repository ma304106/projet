package main;

public class UserBean {
	private String prenom;
	private String nom;
	private String pseudo;
	private String mail;
	private String addresse;
	private String ville;
	private String pass;
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserBean() {
		super();
	}
	
	public UserBean(String prenom,String nom,String pseudo,String mail,String adresse,String ville,String pass){
		super();
		this.prenom=prenom;
		this.nom=nom;
		this.pseudo=pseudo;
		this.mail=mail;
		this.addresse=adresse;
		this.ville=ville;
		this.pass=pass;
	}
	
}

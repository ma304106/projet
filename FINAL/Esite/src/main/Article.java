package main;

public class Article {
	String nom;
	Double prix;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public Article() {
		super();
	}
	
	public Article(String nom,Double prix){
		super();
		this.nom=nom;
		this.prix=prix;
	}
}

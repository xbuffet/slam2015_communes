package metier;

import java.util.ArrayList;

public class Departement {

	/**
	 * Code insee du département
	 */
	private String codeInsee;
	/**
	 * Nom du département
	 */
	private String nom;
	/**
	 * Région du département
	 */
	private Region laRegion;
	/**
	 * Liste des communes du département
	 */
	private ArrayList<Commune> lesCommunes;
	
	/**
	 * Constructeur de la classe Departement<BR/>
	 * Ce constructeur permet également d'ajouter ce nouveau département à la région passée en paramètre
	 * @param unCodeInsee	le code insee du nouveau Departement
	 * @param unNom			le nom du nouveau Departement
	 * @param uneRegion		la région du nouveau Departement
	 */
	public Departement(String unCodeInsee, String unNom, Region uneRegion){
		this.codeInsee = unCodeInsee;
		this.nom = unNom;
		this.laRegion = uneRegion;
		this.lesCommunes = new ArrayList<Commune>();
		this.laRegion.ajouteUnDepartement(this);
	}
	/**
	 * Méthode qui ajoute une nouvelle Commune au Departement
	 * @param uneCommune	la commune à ajouter
	 */
	public void ajouteUneCommune(Commune uneCommune){
		this.lesCommunes.add(uneCommune);
	}
	/**
	 * Getteur sur l'attribut codeInsee
	 * @return	le code insee
	 */
	public String getCodeInsee(){
		return this.codeInsee;
	}
	
	/**
	 * Getteur sur l'attribut nom
	 * @return	le nom
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Getteur sur l'attribut laRegion
	 * @return	la région
	 */
	public Region getLaRegion(){
		return this.laRegion;
	}
	
}

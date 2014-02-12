package metier;

import java.util.ArrayList;

public class Region {
	/**
	 * Code insee de la région
	 */
	private int codeInsee;
	/**
	 * Nom de la région
	 */
	private String nom;
	/**
	 * Liste des départements de la région
	 */
	private ArrayList<Departement> lesDepartements;
	/**
	 * Constructeur de la classe Region
	 * @param unCodeInsee	le code insee de la nouvelle Region
	 * @param unNom			le nom de la nouvelle Region
	 */
	public Region(int unCodeInsee, String unNom){
		this.codeInsee = unCodeInsee;
		this.nom = unNom;
		this.lesDepartements = new ArrayList<Departement>();
	}
	
	/**
	 * Getteur sur l'attribut codeInsee
	 * @return	le code insee
	 */
	public int getCodeInsee(){
		return this.codeInsee;
	}

	/**
	 * Getteur sur l'attribut nom
	 * @return	le nom
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Méthode qui ajoute un nouveau Departement à la Region
	 * @param unDepartement		le département à ajouter
	 */
	public void ajouteUnDepartement(Departement unDepartement){
		this.lesDepartements.add(unDepartement);
	}


}

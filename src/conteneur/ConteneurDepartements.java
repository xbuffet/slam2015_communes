package conteneur;

import java.util.ArrayList;

import metier.Departement;
import metier.Region;

public class ConteneurDepartements {
	/**
	 * Collection d'objets Departement sous la forme d'un ArrayList
	 * @see ArrayList
	 */
	private ArrayList<Departement> tousLesDepartements;
	
	/**
	 * Constructeur de la classe ConteneurDepartements
	 */
	public ConteneurDepartements(){
		this.tousLesDepartements = new ArrayList<Departement>();
	}
	

	/**
	 * Méthode qui ajoute un objet Departement dans le conteneur
	 * @param unCodeInsee	le code insee du nouveau Departement à ajouter
	 * @param unNom			le nom du nouveau Departement à ajouter
	 * @param uneRegion		la région du nouveau Departement à ajouter
	 */
	public void ajouteUnDepartement(String unCodeInsee, String unNom, Region uneRegion){
		this.tousLesDepartements.add(new Departement(unCodeInsee,unNom,uneRegion));
	}
	
	/**
	 * Méthode qui retourne un objet Departement à partir d'un code insee
	 * @param unCodeInsee	le code insee recherché
	 * @return				un objet Departement dont le code est égal à celui passé en paramètre (ou null)
	 */
	public Departement donneDepartementDepuisCodeInsee(String unCodeInsee) {
		Departement leBonDepartement = null;
		int i=0;
		boolean trouve = false;
		while ((!trouve)&&(i<this.tousLesDepartements.size())){
			if(this.tousLesDepartements.get(i).getCodeInsee().equals(unCodeInsee)){
				trouve = true;
				leBonDepartement = this.tousLesDepartements.get(i);
			}
			else
				i++;
		}
		return leBonDepartement;
	}
}

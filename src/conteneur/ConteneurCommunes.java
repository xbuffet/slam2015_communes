package conteneur;

import java.util.ArrayList;
import metier.Commune;
import metier.Departement;

public class ConteneurCommunes {
	/**
	 * Collection d'objets Commune sous la forme d'un ArrayList
	 * @see ArrayList
	 */
	private ArrayList<Commune> toutesLesCommunes;
	/**
	 * Constructeur de la classe ConteneurCommunes
	 */
	public ConteneurCommunes(){
		this.toutesLesCommunes = new ArrayList<Commune>();
	}
	/**
	 * Méthode qui ajoute un objet Commune dans le conteneur
	 * @param unCodeInsee		le code insee de la nouvelle Commune à ajouter
	 * @param unNom				le nom de la nouvelle Commune à ajouter
	 * @param uneAltitude		l'altitude de la nouvelle Commune à ajouter
	 * @param unCodePostal		le code postal de la nouvelle Commune à ajouter
	 * @param uneLongitude		la longitude de la nouvelle Commune à ajouter
	 * @param uneLatitude		la latitude de la nouvelle Commune à ajouter
	 * @param unePopulation		la population de la nouvelle Commune à ajouter
	 * @param uneSurface		la surface de la nouvelle Commune à ajouter
	 * @param unDepartement		le département de la nouvelle Commune à ajouter
	 * @param unNomFormat		la nom formaté de la nouvelle Commune à ajouter
	 */
	public void ajouteUneCommune(String unCodeInsee, String unNom, int uneAltitude, String unCodePostal, double uneLongitude, double uneLatitude, int unePopulation, double uneSurface, Departement unDepartement, String unNomFormat){
		this.toutesLesCommunes.add(new Commune(unCodeInsee, unNom, uneAltitude, unCodePostal, uneLongitude, uneLatitude, unePopulation, uneSurface, unDepartement, unNomFormat));
	}
	
	/**
	 * Méthode qui retourne un objet Departement à partir d'un code insee
	 * @param unCodeInsee	le code insee recherché
	 * @return				un objet Commune dont le code est égal à celui passé en paramètre (ou null)
	 */
	public Commune donneCommuneDepuisCodeInsee(String unCodeInsee){
		Commune laBonneCommune = null;
		int i=0;
		boolean trouve = false;
		while((i<this.toutesLesCommunes.size())&&(!trouve)){
			if(this.toutesLesCommunes.get(i).getCodeInsee().equals(unCodeInsee)){
				laBonneCommune = this.toutesLesCommunes.get(i);
				trouve = true;
			}
			else
				i++;
		}
		return laBonneCommune;		
	}
	

}

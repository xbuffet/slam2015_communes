package gestion;

import metier.Commune;
import metier.Departement;
import metier.Region;
import conteneur.ConteneurCommunes;
import conteneur.ConteneurDepartements;
import conteneur.ConteneurRegions;

public class Gestion {
	/**
	 * Un ensemble d'objets Region contenus dans un seul objet Conteneur
	 * @see ConteneurRegions
	 */
	private ConteneurRegions lesRegions;
	/**
	 * Un ensemble d'objets Departement contenus dans un seul objet Conteneur
	 * @see ConteneurDepartements
	 */
	private ConteneurDepartements lesDepartements;
	/**
	 * Un ensemble d'objets Commune contenus dans un seul objet Conteneur
	 * @see ConteneurCommunes
	 */
	private ConteneurCommunes lesCommunes;
	/**
	 * Constructeur de la classe Gestion
	 */
	public Gestion(){
		this.lesRegions = new ConteneurRegions();
		this.instancieLesRegions();
		this.lesDepartements = new ConteneurDepartements();
		this.instancieLesDepartements();
		this.lesCommunes = new ConteneurCommunes();
		this.instancieLesCommunes();
	}
	
	/**
	 * Méthode qui instancie tous les objets Departement à partir du contenu du fichier
	 * @see FonctionsUtiles#lectureFichier(String)
	 * @see ConteneurDepartements#ajouteUnDepartement(String, String, Region)
	 */
	private void instancieLesDepartements() {
		String[][] lesDepartements = FonctionsUtiles.lectureFichier("departementsDeFrance.txt");
		for(int i=0;i<lesDepartements.length;i++){
			Region laRegion = this.donneRegionDepuisCodeInsee(Integer.parseInt(lesDepartements[i][0]));
			this.lesDepartements.ajouteUnDepartement(lesDepartements[i][1],lesDepartements[i][2],laRegion);
		}		
	}

	/**
	 * Méthode qui instancie tous les objets Region à partir du contenu du fichier
	 * @see FonctionsUtiles#lectureFichier(String)
	 * @see ConteneurRegions#ajouteUneRegion(int, String)
	 */
	private void instancieLesRegions(){
		String[][] lesRegions = FonctionsUtiles.lectureFichier("regionsDeFrance.txt");
		for(int i=0;i<lesRegions.length;i++){
			this.lesRegions.ajouteUneRegion(Integer.parseInt(lesRegions[i][0]),lesRegions[i][1]);
		}
	}
	/**
	 * Méthode qui instancie tous les objets Commune à partir du contenu du fichier
	 * @see FonctionsUtiles#lectureFichier(String)
	 * @see ConteneurCommunes#ajouteUneCommune(String, String, int, String, double, double, int, double, Departement, String)
	 */
	private void instancieLesCommunes(){
		String[][] lesCommunes = FonctionsUtiles.lectureFichier("communesDeFrance.txt");
		for(int i=0;i<lesCommunes.length;i++){
			Departement leDepartement = this.lesDepartements.donneDepartementDepuisCodeInsee(lesCommunes[i][8]);
			String code, nom, cp, nomF;
			int alt, pop;
			double lon, lat, surf;
			code = lesCommunes[i][0];
			nom = lesCommunes[i][1];
			alt = Integer.parseInt(lesCommunes[i][2]);
			cp = lesCommunes[i][3];
			lon = new Double(lesCommunes[i][4]);
			lat = new Double(lesCommunes[i][5]);				
			pop = Integer.parseInt(lesCommunes[i][6]);
			surf = new Double(lesCommunes[i][7]);
			nomF = lesCommunes[i][9];
			this.lesCommunes.ajouteUneCommune(code, nom, alt, cp, lon, lat, pop, surf, leDepartement, nomF);
		}
	}
	/**
	 * Méthode qui retourne un objet Region à partir d'un code insee
	 * @param unCodeInsee	le code insee recherché
	 * @return				un objet Region dont le code est égal à celui passé en paramètre
	 * @see ConteneurRegions#donneRegionDepuisCodeInsee(int)
	 */
	public Region donneRegionDepuisCodeInsee(int unCodeInsee){
		return this.lesRegions.donneRegionDepuisCodeInsee(unCodeInsee);
	}
	
	/**
	 * Méthode qui retourne un objet Departement à partir d'un code insee
	 * @param unCodeInsee	le code insee recherché
	 * @return				un objet Departement dont le code est égal à celui passé en paramètre
	 * @see ConteneurDepartements#donneDepartementDepuisCodeInsee(String)
	 */
	public Departement donneDepartementDepuisCodeInsee(String unCodeInsee){
		return this.lesDepartements.donneDepartementDepuisCodeInsee(unCodeInsee);
	}
	/**
	 * Méthode qui retourne un objet Commune à partir d'un code insee
	 * @param unCodeInsee	le code insee recherché
	 * @return				un objet Commune dont le code est égal à celui passé en paramètre
	 * @see ConteneurCommunes#donneCommuneDepuisCodeInsee(String)
	 */
	public Commune donneCommuneDepuisCodeInsee(String unCodeInsee){
		return this.lesCommunes.donneCommuneDepuisCodeInsee(unCodeInsee);
	}

}

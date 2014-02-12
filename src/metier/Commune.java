package metier;

public class Commune{
	/**
	 * Code insee de la commune 
	 */
	private String codeInsee;
	/**
	 * Nom de la commune
	 */
	private String nom;
	/**
	 * Altitude de la commune
	 */
	private int altitude;
	/**
	 * Code postal de la commune
	 */
	private String codePostal;
	/**
	 * Longitude de la commune (exprimée en radians)
	 */
	private double longitude;
	/**
	 * Latitude de la commune (exprimée en radians)
	 */
	private double latitude;
	/**
	 * Population de la commune (1999)
	 */
	private int population;
	/**
	 * Surface de la commune
	 */
	private double surface;
	/**
	 * Département de la commune
	 */
	private Departement leDepartement;
	/**
	 * Nom de la commune formaté (majuscules sans accents)
	 */
	private String nomFormat;
	/**
	 * Constructeur de la classe Commune<BR/>
	 * Ce constructeur permet également d'ajouter cette nouvelle commune au département passée en paramètre
	 * @param unCodeInsee		le code insee de la nouvelle Commune
	 * @param unNom				le nom de la nouvelle Commune
	 * @param uneAltitude		l'altitude de la nouvelle Commune
	 * @param unCodePostal		le code postal de la nouvelle Commune
	 * @param uneLongitude		la logitude de la nouvelle Commune
	 * @param uneLatitude		la latitude de la nouvelle Commune
	 * @param unePopulation		la population de la nouvelle Commune
	 * @param uneSurface		la surface de la nouvelle Commune
	 * @param unDepartement		le département de la nouvelle Commune
	 * @param unNomFormat		le nom formaté de la nouvelle Commune
	 */
	public Commune(String unCodeInsee, String unNom, int uneAltitude, String unCodePostal, double uneLongitude, double uneLatitude, int unePopulation, double uneSurface, Departement unDepartement, String unNomFormat){
		this.codeInsee = unCodeInsee;
		this.nom = unNom;
		this.altitude = uneAltitude;
		this.codePostal = unCodePostal;
		this.longitude = uneLongitude;
		this.latitude = uneLatitude;
		this.population = unePopulation;
		this.surface = uneSurface;
		this.leDepartement = unDepartement;
		this.nomFormat = unNomFormat;
		this.leDepartement.ajouteUneCommune(this);
	}
	/**
	 * Getteur sur l'attribut CodeInsee
	 * @return	le codeInsee
	 */
	public String getCodeInsee(){
		return this.codeInsee;
	}
	/**
	 * Getteur sur l'attribut Nom
	 * @return	le nom
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Getteur sur l'attribut leDepartement
	 * @return	le département
	 */
	public Departement getLeDepartement(){
		return this.leDepartement;
	}
	
	/**
	 * Getteur sur l'attribut latitude
	 * @return	la latitude
	 */
	public double getLatitude(){
		return this.latitude;
	}
	
	/**
	 * Getteur sur l'attribut longitude
	 * @return	la longitude
	 */
	public double getLongitude(){
		return this.longitude;
	}
	
	
}

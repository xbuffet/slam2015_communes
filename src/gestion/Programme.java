package gestion;

import java.util.Scanner;

import metier.Commune;
import metier.Departement;
import metier.Region;

public class Programme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gestion laFrance = new Gestion();
		Scanner scan = new Scanner(System.in);
		int reponse;
		int codeRegion;
		String codeDept, codeCom;
		do{
			System.out.println("---------------");
			System.out.println("1 - Region");
			System.out.println("2 - Departement");
			System.out.println("3 - Commune");
			System.out.println("9 - Quitter");
			System.out.println("---------------");
			reponse = scan.nextInt();
			switch(reponse){
			case 1 :
				System.out.println("Entrer un code de région");
				codeRegion = scan.nextInt();
				Region laRegion = laFrance.donneRegionDepuisCodeInsee(codeRegion);
				if(laRegion==null)
					System.out.println("Le code région recherché n'existe pas");
				else{
					System.out.println("Il s'agit de "+laRegion.getNom());
				}
				break;
			case 2 :
				System.out.println("Entrer un code de département");
				codeDept = scan.next();
				if((Integer.parseInt(codeDept)<10)&&(codeDept.charAt(0)!='0'))
					codeDept="0"+codeDept;
				Departement leDept = laFrance.donneDepartementDepuisCodeInsee(codeDept);
				if(leDept==null)
					System.out.println("Le code département recherché n'existe pas");
				else{
					System.out.println("Il s'agit du département "+leDept.getNom());
					}	
				break;
			case 3 :
				System.out.println("Entrer un code de commune");
				codeCom = scan.next();
				Commune laCommune = laFrance.donneCommuneDepuisCodeInsee(codeCom);
				if(laCommune==null)
					System.out.println("Le code commune recherché n'existe pas");
				else
					System.out.println("Il s'agit de "+laCommune.getNom());
				break;	
			}
			scan.nextLine();
		}while(reponse!=9);
		scan.close();
	}

}

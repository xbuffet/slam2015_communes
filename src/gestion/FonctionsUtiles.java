package gestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Scanner;
/**
 * Classe proposant des méthodes statiques c'est-à-dire des méthodes pouvant être appelées sans instance de classe.
 * @author Xa
 *
 */
public class FonctionsUtiles {
	
	/**
	 * Méthode permettant de lire un fichier et de retourner l'intégralité de son contenu 
	 * sous forme d'un tableau de String à deux dimensions
	 * @param nomFichier	le nom du fichier (avec extension) à lire
	 * @return				un tableau de String à deux dimensions
	 */
	public static String[][] lectureFichier(String nomFichier){
		String[][] tabRetour = null;
		Scanner scan;
		int i=0;
		try {
			scan = new Scanner(new File(nomFichier));
			String ligne = scan.nextLine();
			while (scan.hasNextLine()) {
			    ligne = scan.nextLine();
			    i++;
			}
			tabRetour = new String[i][];
			i=0;
			scan = new Scanner(new File(nomFichier));
			ligne = scan.nextLine();
			while (scan.hasNextLine()) {
			    ligne = scan.nextLine();
			    tabRetour[i] = ligne.split(";");
			    i++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return tabRetour;
	}
	
	/**
	 * Méthode permettant de formater une chaîne de caractères 
	 * c'est-à-dire de supprimer les préfixes (la-le-les...) et les accents<BR/>
	 * <I>Exemples de résultats</I><BR/>
	 * <UL><LI>"mirande" retournera "MIRANDE"</LI>
	 * <LI>"les hays" retournera "HAYS"</LI>
	 * <LI>"Gérardmer" retournera "GERARDMER"</LI></UL>
	 * @param uneChaine		la chaîne à formater
	 * @return				la chaîne formatée
	 */
	public static String retourneChaineFormatee(String uneChaine){
		String uneChaineFormatee = "";
		uneChaine = uneChaine.toUpperCase();
		if (uneChaine.startsWith("L'")){
			for(int i=2;i<uneChaine.length();i++)
				uneChaineFormatee+=uneChaine.charAt(i);
		}
		else if (uneChaine.startsWith("LA ")||uneChaine.startsWith("LE ")){
			for(int i=3;i<uneChaine.length();i++)
				uneChaineFormatee+=uneChaine.charAt(i);
		}
		else if(uneChaine.startsWith("LES ")||uneChaine.startsWith("LOS ")||uneChaine.startsWith("AUX ")){
			for(int i=4;i<uneChaine.length();i++)
				uneChaineFormatee+=uneChaine.charAt(i);
		}
		else
			uneChaineFormatee=uneChaine;
		uneChaineFormatee = Normalizer.normalize(uneChaineFormatee, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
		return uneChaineFormatee;
	}

}

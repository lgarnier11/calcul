package fr.lgarnier.calcul;

import java.util.Arrays;

/**
 * 
 * @author lgarnier
 *
 */
public class Calcul {

	/**
	 * Renvoi le plus petit entier strictement supérieur à valeur
	 * et dont aucun chiffre n'est contenu dans valeur
	 * 
	 * limite de l'exercice : un nombre contenant tous les chiffres (123456789)
	 * @param valeur
	 * @return 
	 */
	public int run(final int valeur) {
		final int[] valeurs = decoupageValeur(valeur);
		String resultat = "";
		for (int i = 0; i < valeurs.length; i++) {
			resultat += calcul(valeurs, i==0 ? valeurs[i] : 0);
		}
		return Integer.valueOf(resultat);
	}

	/**
	 * fonction récursive qui renvoi un entier qui n'est pas contenu 
	 * dans le tableau valeursInitial
	 * si valeurDeBase existe dans le tableau, on ajoute 1 à valeurDeBase
	 * @param valeursInitiales
	 * @param indice
	 * @param valeurDeBase
	 * @return
	 */
	private int calcul(final int[] valeursInitiales, final int valeurDeBase) {
		final int nouvelleValeur = valeurDeBase;
		if (nouvelleValeur==10) {
			if (contains(valeursInitiales, 1)) {
				throw new ArithmeticException("Tous les chiffres sont déjà présents dans le nombre initial");
			}
			return 10 + calcul(valeursInitiales, 0);
		} else {
			if (contains(valeursInitiales, nouvelleValeur))
				return calcul(valeursInitiales, nouvelleValeur+1);
		}
		return nouvelleValeur;	
	}

	/**
	 * découpage d'un nombre en tableau de chiffres
	 * @param valeur
	 * @return
	 */
	private int[] decoupageValeur(final int valeur) {
		return Integer.toString(valeur).chars().map(c -> c-'0').toArray();
	}

	/**
	 * recherche d'un nombre dans un tableau de nombres
	 * @param arr
	 * @param key
	 * @return
	 */
	public static boolean contains(final int[] arr, final int key) {
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}
}

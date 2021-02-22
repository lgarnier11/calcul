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
	 * => ArithmeticException
	 * @param valeur
	 * @return nouvelle valeur
	 */
	public int run(final int valeur) {
		final int[] valeurs = decoupageValeur(valeur);
		String resultat = "";
		for (int i = 0; i < valeurs.length; i++) {
			// concaténation des nouveaux chiffres individuels
			resultat += calcul(valeurs, i==0 ? valeurs[i] : 0, false);
		}
		return Integer.valueOf(resultat);
	}

	/**
	 * fonction récursive qui renvoi un entier qui n'est pas contenu 
	 * dans le tableau valeursInitial
	 * si valeurDeBase existe dans le tableau, on ajoute 1 à valeurDeBase
	 * @param valeursInitiales : tableau des valeurs initiales
	 * @param valeur : valeur de départ
	 * @param estDizaine : est une dizaine
	 * @return nouvelle valeur
	 */
	private int calcul(final int[] valeursInitiales, int valeur, boolean estDizaine) {
		if (valeur==10) {
			// valeur de départ 10 et estDizaine à vrai : erreur
			if (estDizaine) {
				throw new ArithmeticException("Tous les chiffres sont déjà présents dans le nombre initial");
			}
			// appel calcul avec nouvelle dizaine (valeur de départ 1, estDizaine à vrai
			//											  appel calcul avec nouvelle dizaine (valeur de départ 0, estDizaine à faux
			valeur = calcul(valeursInitiales, 1, true)*10 + calcul(valeursInitiales, 0, false);
		} else {
			if (contains(valeursInitiales, valeur)) {
				// le tableau contient valeur, on rappelle calcul avec valeur+1
				valeur = calcul(valeursInitiales, valeur+1, estDizaine);
			}
		}
		return valeur;	
	}

	/**
	 * découpage d'un nombre en tableau de chiffres
	 * source web
	 * @param valeur
	 * @return tableau des chiffres contenus dans valeur
	 */
	private int[] decoupageValeur(final int valeur) {
		return Integer.toString(valeur).chars().map(c -> c-'0').toArray();
	}

	/**
	 * recherche d'un nombre dans un tableau de nombres
	 * source web
	 * @param arr
	 * @param key
	 * @return vrai si le tableau contient la valeur (key)
	 */
	public static boolean contains(final int[] arr, final int key) {
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}
}

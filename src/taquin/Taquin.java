package taquin;

import java.util.Random;

/**
 * @author gautier - UHP
 * @version 25 août 2008
 */
public class Taquin {

    protected int[][] jeu;
    protected int ligneTrou;
    protected int colonneTrou;
    protected static int TROU = -1;

    public Taquin(int taille) {
        jeu = new int[taille][taille];
        remplir();
    }

    public int taille() {
        return jeu.length;
    }

    // Remplir au hasard avec les entiers compris en 1 et taille*taille
    public void remplir() {
        Random generateur = new Random();
        int taille = taille();
        ligneTrou = generateur.nextInt(taille);
        colonneTrou = generateur.nextInt(taille);
        jeu[ligneTrou][colonneTrou] = TROU;
        for (int i = 1; i < taille * taille; i++) {
            int ligne = generateur.nextInt(taille);
            int colonne = generateur.nextInt(taille);
            while (jeu[ligne][colonne] != 0) {
                ligne = generateur.nextInt(taille);
                colonne = generateur.nextInt(taille);
            }
            jeu[ligne][colonne] = i;
        }
    }

// Contenu d'une case
    public int caseJeu(int ligne, int colonne) {
        return jeu[ligne][colonne];
    }

// Vrai si la case est contigüe avec le trou
    public boolean caseJouable(int ligne, int colonne) {
        if (ligne == ligneTrou && (colonne == colonneTrou - 1 || colonne == colonneTrou + 1)) {
            return true;
        }
        if (colonne == colonneTrou && (ligne == ligneTrou - 1 || ligne == ligneTrou + 1)) {
            return true;
        }
        return false;
    }

    public int ligneTrou() {
        return ligneTrou;
    }

    public int colonneTrou() {
        return colonneTrou;
    }

    public void deplacerCase(int ligne, int colonne) {
        jeu[ligneTrou][colonneTrou] = jeu[ligne][colonne];
        jeu[ligne][colonne] = TROU;
        ligneTrou = ligne;
        colonneTrou = colonne;
    }
}

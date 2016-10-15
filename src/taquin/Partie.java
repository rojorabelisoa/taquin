package taquin;

import java.util.Observable;

/**
 * @author gautier - UHP
 * @version 25 août 2008
 */
public class Partie extends Observable {

    protected Taquin taquin;
    protected int nbCoups;

    public Partie() {
        taquin = new Taquin(3);
        nbCoups = 0;
        setChanged();
        notifyObservers();
    }

    public int nbCoups() {
        return nbCoups;
    }

    public boolean caseJouable(int ligne, int colonne) {
        return taquin.caseJouable(ligne, colonne);
    }

    public int taille() {
        return taquin.taille();
    }

    public int caseJeu(int ligne, int colonne) {
        return taquin.caseJeu(ligne, colonne);
    }

    public int ligneTrou() {
        return taquin.ligneTrou();
    }

    public int colonneTrou() {
        return taquin.colonneTrou();
    }

    public void deplacerCase(int ligne, int colonne) {
        taquin.deplacerCase(ligne, colonne);
        nbCoups++;
        setChanged();
        notifyObservers();
    }
}

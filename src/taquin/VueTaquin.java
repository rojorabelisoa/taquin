package taquin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author gautier - UHP
 * @version 25 août 2008
 */
public class VueTaquin extends JPanel implements Observer {

    protected Partie partie;
    protected JButton[][] boutons;

    public VueTaquin(Partie partie) {
        super(new GridLayout(3, 3));
        this.partie = partie;
        this.partie.addObserver(this);
        setBorder(BorderFactory.createTitledBorder("Taquin"));
        int taille = partie.taille();
        boutons = new JButton[taille][taille];
        for (int k = 0; k < taille * taille; k++) {
            int ligne = k / taille;
            int colonne = k % taille;
            JButton bouton = new JButton("");
            add(bouton);
            bouton.addActionListener(new Ecouteur(ligne, colonne));
            boutons[ligne][colonne] = bouton;
        } // for
        actualiser();
    } // VueTaquin(Partie)

    protected void actualiser() {
        int taille = partie.taille();
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille; colonne++) {
                boutons[ligne][colonne].setEnabled(false);
                boutons[ligne][colonne].setText("" + partie.caseJeu(ligne, colonne));
            } // for
        } // for
        int ligneTrou = partie.ligneTrou();
        int colonneTrou = partie.colonneTrou();
        boutons[ligneTrou][colonneTrou].setText("");
        if (ligneTrou > 0) {
            boutons[ligneTrou - 1][colonneTrou].setEnabled(true);
        }
        if (colonneTrou > 0) {
            boutons[ligneTrou][colonneTrou - 1].setEnabled(true);
        }
        if (ligneTrou < taille - 1) {
            boutons[ligneTrou + 1][colonneTrou].setEnabled(true);
        }
        if (colonneTrou < taille - 1) {
            boutons[ligneTrou][colonneTrou + 1].setEnabled(true);
        }
    } // actualiser()

    public void update(Observable o, Object arg) {
        actualiser();
    }

    class Ecouteur implements ActionListener {

        protected int ligne;
        protected int colonne;

        public Ecouteur(int ligne, int colonne) {
            this.ligne = ligne;
            this.colonne = colonne;
        }

        public void actionPerformed(ActionEvent e) {
            partie.deplacerCase(ligne, colonne);
        }
    }
}

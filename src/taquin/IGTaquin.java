package taquin;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author gautier - UHP
 * @version 24 août 2008
 */
public class IGTaquin {
    
    private int nbEssais ; 
    private JLabel nbE ;
    
    public IGTaquin() {

        JFrame fenetre = new JFrame("Jeu .... ");
        Container reservoir = fenetre.getContentPane();
        reservoir.setLayout(new BoxLayout(reservoir, BoxLayout.Y_AXIS));

        Partie partie = new Partie() ;

        VueNbCoups vn = new VueNbCoups(partie) ;
        reservoir.add(vn) ;
        
        VueTaquin vt = new VueTaquin(partie) ;
        reservoir.add(vt);

        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // IGTaquin()

    public static void main(String[] args) {
        new IGTaquin();
    } // main(String[])

}

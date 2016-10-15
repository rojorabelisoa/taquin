package taquin;

import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author gautier - UHP
 * @version 25 août 2008
 */
public class VueNbCoups extends JPanel implements Observer {

    protected Partie partie;
    protected JLabel nbC;

    public VueNbCoups(Partie partie) {
        super();
        this.partie = partie;
        this.partie.addObserver(this);
        setBorder(BorderFactory.createTitledBorder("Nombre de coups "));
        nbC = new JLabel("0");
        add(nbC);
    }

    public void update(Observable o, Object arg) {
        nbC.setText(partie.nbCoups() + "");
    }
}

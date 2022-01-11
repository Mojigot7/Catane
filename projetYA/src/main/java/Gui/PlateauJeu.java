package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import plateau.Plateau;

public class PlateauJeu extends JFrame implements MouseListener {

    private Gui fenetre;
    private Plateau jeu;
    private JPanel plateau;

    public PlateauJeu(Plateau p, Gui f) {
        jeu = p;
        fenetre = f;
        plateau = new JPanel();
        GridLayout size = new GridLayout(9, 11);
        plateau.setLayout(size);
        Conteneur temp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                temp = new Conteneur();
                if (p.getPlateau()[i][j] == null) {
                    temp.getConteneur().setBackground(new Color(119, 181, 254));
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Colline")) {
                    temp.getConteneur().setBackground(new Color(215, 100, 0));
                    temp.getConteneurnom().setBackground(new Color(215, 100, 0));
                    temp.getNom().setText("Colline " + p.getPlateau()[i][j].getNumero());
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getVoleur().setBackground(new Color(215, 100, 0));
                    temp.getVoleur().setVisible(false);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Champs")) {
                    temp.getConteneur().setBackground(new Color(255, 255, 0));
                    temp.getConteneurnom().setBackground(new Color(255, 255, 0));
                    temp.getNom().setText("Champs " + p.getPlateau()[i][j].getNumero());
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getVoleur().setBackground(new Color(255, 255, 0));
                    temp.getVoleur().setVisible(false);
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Foret")) {
                    temp.getConteneur().setBackground(new Color(0, 172, 62));
                    temp.getConteneurnom().setBackground(new Color(0, 172, 62));
                    temp.getNom().setText("Foret " + p.getPlateau()[i][j].getNumero());
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getVoleur().setBackground(new Color(0, 172, 62));
                    temp.getVoleur().setVisible(false);
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Pre")) {
                    temp.getConteneur().setBackground(new Color(0, 215, 78));
                    temp.getConteneurnom().setBackground(new Color(0, 215, 78));
                    temp.getNom().setText("Pre " + p.getPlateau()[i][j].getNumero());
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getVoleur().setBackground(new Color(0, 172, 62));
                    temp.getVoleur().setVisible(false);
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Montagne")) {
                    temp.getConteneur().setBackground(new Color(167, 167, 167));
                    temp.getConteneurnom().setBackground(new Color(167, 167, 167));
                    temp.getNom().setText("Montagne " + p.getPlateau()[i][j].getNumero());
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getVoleur().setBackground(new Color(167, 167, 167));
                    temp.getVoleur().setVisible(false);
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);
                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Port")) {
                    temp.getConteneur().setBackground(new Color(119, 181, 254));
                    temp.getConteneurnom().setBackground(new Color(119, 181, 254));
                    temp.getNom().setText("Port");
                    temp.getConteneur().addMouseListener(this);
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.CENTER);

                } else if (p.getPlateau()[i][j].getClass().getName().equals("tuiles.Desert")) {
                    temp.getConteneur().setBackground(new Color(255, 255, 225));
                    temp.getConteneurnom().setBackground(new Color(255, 255, 225));
                    temp.getNom().setText("Desert 7");
                    temp.getConteneur().addMouseListener(this);
                    temp.getConteneurnom().add(temp.getNom());
                    temp.getVoleur().setBackground(new Color(255, 255, 225));
                    temp.getVoleur().setVisible(true);
                    temp.getConteneur().add(temp.getConteneurnom(), BorderLayout.NORTH);
                    temp.getConteneur().add(temp.getVoleur(), BorderLayout.CENTER);

                } else {
                    temp.getConteneur().setBackground(new Color(255, 127, 0));
                    temp.getConteneur().addMouseListener(this);
                }
                plateau.add(temp.getConteneur());
            }
        }
    }

    public JPanel getContent() {
        return plateau;
    }

    private class Conteneur extends JPanel {

        private JPanel conteneur;
        private JPanel conteneurnom;
        private JLabel nom;
        private JPanel voleur;

        public Conteneur() {

            conteneur = new JPanel();
            conteneur.setLayout(new BorderLayout());
            conteneurnom = new JPanel();
            nom = new JLabel();
            voleur = new JPanel();
            voleur.add(new Voleur());
        }

        public JPanel getConteneur() {
            return conteneur;
        }

        public JPanel getConteneurnom() {
            return conteneurnom;
        }

        public JLabel getNom() {
            return nom;
        }

        public JPanel getVoleur() {
            return voleur;
        }
    }

    public class Voleur extends JPanel implements MouseInputListener {

        public Voleur() {
            this.setSize(50, 50);
            this.setBackground(new Color(0, 0, 0));
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getXOnScreen() - fenetre.getX();
        int y = e.getYOnScreen() - fenetre.getY() -
                fenetre.getContentPane().getComponent(1).getY() -
                fenetre.getInsets().top;
        int taillecasex = (plateau.getWidth()/11);
        int taillecasey = (plateau.getHeight()/9);
        if((x/taillecasex % 2) == 1 && (y/taillecasey)%2 == 0) {
            plateau.remove(x/taillecasex + (y/taillecasey)*11);
            plateau.add(new RouteHorizontal(), (x/taillecasex + (y/taillecasey)*11 ));
            plateau.revalidate();
        }
        else if ((x/taillecasex)%2 == 0 && (y/taillecasey)%2 == 1){
            plateau.remove(x/taillecasex + (y/taillecasey)*11);
            plateau.add(new RouteVertical(), (x/taillecasex + (y/taillecasey)*11));
            plateau.revalidate();
        }
        else {

        }
    }
    /*
     * On recupere la position de la souris -
     * la position de la fenetre par rapport à l'ecran la position de la fenetre par
     * rapport à l'ecran
     * - Le top(informationJoueur)
     * - la barre d'inset de la fenetre
     */

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public class RouteHorizontal extends JPanel {

        public RouteHorizontal() {
            this.setLayout(new GridLayout(3, 1));
            JPanel r1 = new JPanel();
            r1.setBackground(new Color(255, 127, 0));
            JPanel r2 = new JPanel();
            r2.setBackground(new Color(220, 220, 220));
            JPanel r3 = new JPanel();
            r3.setBackground(new Color(255, 127, 0));
            this.add(r1);
            this.add(r2);
            this.add(r3);
        }
    }

    public class RouteVertical extends JPanel {

        public RouteVertical() {
            this.setLayout(new GridLayout(1, 3));
            JPanel r1 = new JPanel();
            r1.setBackground(new Color(255, 127, 0));
            JPanel r2 = new JPanel();
            r2.setBackground(new Color(220, 220, 220));
            JPanel r3 = new JPanel();
            r3.setBackground(new Color(255, 127, 0));
            this.add(r1);
            this.add(r2);
            this.add(r3);
        }
    }
}
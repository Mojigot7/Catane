package Gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import plateau.*;

public class Gui extends JFrame {
    private InformationJoueur top;
    private Plateau plateau;
    private PlateauJeu jeu;
    private Actions actions;

    public Gui() {
        plateau = new Plateau();
        setTitle("Jeu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        this.setLocationRelativeTo(null);
        top = new InformationJoueur();
        jeu = new PlateauJeu(plateau);
        actions = new Actions();     
        this.getContentPane().add(top.getContentPane(),BorderLayout.NORTH);
        this.getContentPane().add(jeu.getContent(),BorderLayout.CENTER);
        this.getContentPane().add(actions.getContent(),BorderLayout.SOUTH);
    }
    public static void main(String[] agrs) {
        Gui test = new Gui();
        test.setVisible(true);
    }
}

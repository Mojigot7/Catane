package Gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import plateau.*;
import joueur.*;

public class Gui extends JFrame {

    private InformationJoueur top;
    private Plateau plateau;
    private PlateauJeu jeu;
    private Actions actions;
    private ArrayList<Joueur> listjoueur;
    private Joueur courant;

    public Gui(ArrayList<Joueur> listjoueur,Joueur courant) {
        this.listjoueur = listjoueur;
        this.courant = courant;
        plateau = new Plateau();
        setTitle("Jeu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        top = new InformationJoueur(listjoueur);
        jeu = new PlateauJeu(plateau,this);
        actions = new Actions(listjoueur,this,courant);
        this.getContentPane().add(top.getContentPane(),BorderLayout.NORTH);
        this.getContentPane().add(jeu.getContent(),BorderLayout.CENTER);
        this.getContentPane().add(actions.getContent(),BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        setSize(1000,600);
    }

    public InformationJoueur getInformationJoueur(){
        return top;
    }

    public PlateauJeu getPlateauJeu() {
        return jeu;
    }
    public Actions getActions(){
        return actions;
    }

    public Joueur getJoueurCourant(){
        return courant;
    }

}


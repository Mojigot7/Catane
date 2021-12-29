package jeu;

import plateau.Plateau;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu implements Runnable{
	private ArrayList<Joueur> joueur;
	private Plateau jeu;
	private Scanner config;
	
	public Jeu() {
		this.jeu = new Plateau();
		this.joueur = new ArrayList<Joueur>();
		config = new Scanner(System.in);
	}
	
	public boolean victoire() {
		for(Joueur j : joueur) {
			if(j.getScore() >= 10) {
				System.out.println("Joueur ["+j.toString()+"] a remporté la partie !");
				this.afficheScore();
				return true;
			}
		}
		return false;
	}
	
	public void afficheScore() {
		System.out.println("Score finaux :");
		for(Joueur j : joueur) {
			System.out.println("Joueur ["+j.toString()+"] : "+j.getScore());
		}
	}
	
	public int demanderNbJoueurs() {
		String res;
		System.out.println("Combien de joueurs voulez-vous ? (3 ou 4)");
		res = config.next();
		while(!res.equals("3") && !res.equals("4")) {
			System.out.println("Nombre de joueurs incorrect !");
			System.out.println("Combien de joueurs voulez-vous ? (3 ou 4)");
			res = config.next();
		}
		System.out.println();
		return Integer.valueOf(res);
	}
	
	public void creationDesJoueurs() {
		int max = this.demanderNbJoueurs();
		int i = 0;
		String reponse;
		while(i < max) {
			if(i == 0) {
				System.out.println("Voulez-vous un robot ou un humain pour le premier joueur ? (R ou H)");
				reponse = config.next().toUpperCase();
				while(!reponse.equals("H") && !reponse.equals("R")) {
					System.out.println("Veuillez entrer H (humain) ou R (robot).");
					System.out.println("Voulez-vous un robot ou un humain pour le premier joueur ? (R ou H)");
					reponse = config.next().toUpperCase();
				}
				if(reponse.equals("H")) {
					System.out.println("Comment s'appelle le premier joueur ?");
					reponse = config.next();
					joueur.add(new Humain(reponse,Color.BLUE));
				} else {
					joueur.add(new IA("BOT1",Color.BLUE));
				}
			}
			if(i == 1) {
				System.out.println("Voulez-vous un robot ou un humain pour le deuxième joueur ? (R ou H)");
				reponse = config.next().toUpperCase();
				while(!reponse.equals("H") && !reponse.equals("R")) {
					System.out.println("Veuillez entrer H (humain) ou R (robot).");
					System.out.println("Voulez-vous un robot ou un humain pour le deuxième joueur ? (R ou H)");
					reponse = config.next().toUpperCase();
				}
				if(reponse.equals("H")) {
					System.out.println("Comment s'appelle le deuxième joueur ?");
					reponse = config.next();
					joueur.add(new Humain(reponse,Color.RED));
				} else {
					joueur.add(new IA("BOT2",Color.RED));
				}
			}
			if(i == 2) {
				System.out.println("Voulez-vous un robot ou un humain pour le troisième joueur ? (R ou H)");
				reponse = config.next().toUpperCase();
				while(!reponse.equals("H") && !reponse.equals("R")) {
					System.out.println("Veuillez entrer H (humain) ou R (robot).");
					System.out.println("Voulez-vous un robot ou un humain pour le troisième joueur ? (R ou H)");
					reponse = config.next().toUpperCase();
				}
				if(reponse.equals("H")) {
					System.out.println("Comment s'appelle le troisième joueur ?");
					reponse = config.next();
					joueur.add(new Humain(reponse,Color.GREEN));
				} else {
					joueur.add(new IA("BOT3",Color.GREEN));
				}
			}
			if(i == 3) {
				System.out.println("Voulez-vous un robot ou un humain pour le quatrième joueur ? (R ou H)");
				reponse = config.next().toUpperCase();
				while(!reponse.equals("H") && !reponse.equals("R")) {
					System.out.println("Veuillez entrer H (humain) ou R (robot).");
					System.out.println("Voulez-vous un robot ou un humain pour le quatrième joueur ? (R ou H)");
					reponse = config.next().toUpperCase();
				}
				if(reponse.equals("H")) {
					System.out.println("Comment s'appelle le quatrième joueur ?");
					reponse = config.next();
					joueur.add(new Humain(reponse,Color.YELLOW));
				} else {
					joueur.add(new IA("BOT4",Color.YELLOW));
				}
			}
			i++;
		}
		config.close();
		System.out.println();
		System.out.println("Voici les joueurs :");
		for(Joueur j : joueur) {
			System.out.println(j.toString());
		}
	}
	
	public void voleurAction(Joueur j) {
		for(Joueur j1 : this.joueur) {
			j1.jetterSesRessources();
		}
		j.deplacerVoleur(jeu);
		jeu.estSurTuileDuVoleur(j);
		
	}
	
	public void tour1() {
		for(Joueur j : joueur) {
		
		}
	}
	
	public void tour2() {
		
	}
	
	public void tourClassique() {
		
	}

	@Override
	public void run() {
		Jeu j = new Jeu();
		j.creationDesJoueurs();
	}
	
}

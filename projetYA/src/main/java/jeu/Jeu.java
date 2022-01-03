package jeu;

import plateau.Plateau;
import joueur.Humain;
import joueur.IA;
import joueur.Joueur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Jeu implements Runnable{
	private ArrayList<Joueur> joueur;
	private Plateau jeu;
	private Scanner config;
	private Joueur maxChevalier = null;
	
	public Jeu() {
		this.jeu = new Plateau();
		this.joueur = new ArrayList<Joueur>();
		config = new Scanner(System.in);
	}
	
	public Joueur getJoueur1() {
		return joueur.get(0);
	}
	
	public Joueur getJoueur2() {
		return joueur.get(1);
	}
	
	public Joueur getJoueur3() {
		return joueur.get(2);
	}
	
	public Joueur getJoueur4() {
		if(joueur.size() < 4) {
			return null;
		}
		return joueur.get(3);
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
		System.out.println();
		System.out.println("Voici les joueurs :");
		for(Joueur j : joueur) {
			System.out.println(j.toString());
		}
	}
	
	public void voleurAction(Joueur j) {
		for(Joueur j1 : this.joueur) {
			j1.jeterSesRessources();
		}
		j.deplacerVoleur(jeu);
		jeu.estSurTuileDuVoleur(j);
		
	}
	
	public void lePlusDeChevalier() {
		int max = 2;
		for(Joueur j : joueur) {
			if(j.getCptChevalier() > max) {
				if(this.maxChevalier != null) {
					this.maxChevalier.setScore(this.maxChevalier.getScore()-2);
				}
				this.maxChevalier = j;
				max = j.getCptChevalier();
			}
		}
		this.maxChevalier.setScore(this.maxChevalier.getScore()+2);
		System.out.println("Joueur ["+this.maxChevalier.toString()+"] a l'armée la plus puissante !");
	}
	
	public void tour1() {
		for(Joueur j : joueur) {
			j.poserColonie(jeu);
			jeu.affiche();
			j.poserRoute(jeu);
			jeu.affiche();
		}
	}
	
	public void tour2() {
		Stack<Joueur> pile = new Stack<>();
		for(Joueur j : joueur) {
			pile.add(j);
		}
		while(!pile.isEmpty()) {
			Joueur j1 = pile.pop();
			j1.poserColonie(jeu);
			jeu.affiche();
			j1.poserRoute(jeu);
			jeu.affiche();
		}
	}
	
	public void tourClassique() {
		for(Joueur j : joueur) {
			int dees = j.lancerDees();
			System.out.println("Joueur ["+j.toString()+"] a fait un "+dees);
			jeu.affiche();
			if(dees == 7) {
				this.voleurAction(j);
			} else {
				jeu.recolte(dees, joueur);
				j.faireChoix(jeu);
			}
		}
	}

	@Override
	public void run() {
		this.creationDesJoueurs();
		this.tour1();
		this.tour2();
		while(!this.victoire()) {
			this.tourClassique();
		}
		System.out.println("Voulez-vous rejouer ? O : oui, N : non");
		String rejouer = config.next().toUpperCase();
		while(!rejouer.equals("O") && !rejouer.equals("N")) {
			System.out.println("Voulez-vous rejouer ? O : oui, N : non");
			rejouer = config.next().toUpperCase();
		}
		if(rejouer.equals("O")) {
			this.jeu = new Plateau();
			this.run();
		} else {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}

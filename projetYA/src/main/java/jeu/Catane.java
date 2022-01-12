package jeu;

import java.util.Scanner;

import Gui.Config;
import Gui.Gui;
import colors.ConsoleColors;

public class Catane {
	private Scanner config = new Scanner(System.in);
	
	public String choixDeJouer() {
		System.out.println(ConsoleColors.LIGHT_PINK+"Comment voulez-vous jouer ? Interface graphique : (I) / Terminal : (T)"+ConsoleColors.RESET);
		String res = config.next().toUpperCase();
		while(!res.equals("T") && !res.equals("I")) {
			System.out.println(ConsoleColors.LIGHT_PINK+"Voulez-vous jouer ? oui : (O) / non : (N)"+ConsoleColors.RESET);
			res = config.next().toUpperCase();
		}
		return res;
	}

	public static void main(String[] args) {
		Catane c = new Catane();
		System.out.println(ConsoleColors.LIGHT_PINK+"===========================");
		System.out.println("=                         =");
		System.out.println("="+ConsoleColors.RESET+ConsoleColors.LIGHT_PURPLE+" Bienvenue dans Catane ! "+ConsoleColors.RESET+ConsoleColors.LIGHT_PINK+"=");
		System.out.println("=                         =");
		System.out.println("==========================="+ConsoleColors.RESET);
		System.out.println();
		if(c.choixDeJouer().equals("T")) {
			Jeu j = new Jeu();
			j.jouer();
		} else {
			Config test = new Config();
		    test.setVisible(true);
		}
	}

}

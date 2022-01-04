package jeu;

import colors.ConsoleColors;

public class Catane {

	public static void main(String[] args) {
		System.out.println(ConsoleColors.LIGHT_PINK+"===========================");
		System.out.println("=                         =");
		System.out.println("="+ConsoleColors.RESET+ConsoleColors.LIGHT_PURPLE+" Bienvenue dans Catane ! "+ConsoleColors.RESET+ConsoleColors.LIGHT_PINK+"=");
		System.out.println("=                         =");
		System.out.println("==========================="+ConsoleColors.RESET);
		System.out.println();
		Jeu j = new Jeu();
		j.jouer();
	}

}

package plateau;

import colors.ConsoleColors;
import joueur.Joueur;

public abstract class Tuile {
	
	private int numero;
	private String type;
	private boolean voleur;
	private Joueur estVoleur;
	
	public Tuile(int num, String type, boolean voleur) {
		this.numero = num;
		this.type = type;
		this.voleur = voleur;
		this.estVoleur = null;
	}

	
	public abstract boolean estCroisement();
	public abstract boolean estSommet();
	public abstract boolean estPort();
	public abstract boolean estTuile();
	public abstract boolean peutEtreVoleur();

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		if(this.numero != -1) {
			if(this.isVoleur()) {
				return ConsoleColors.BLACK+this.numero+ConsoleColors.RESET;
			}
			return this.numero+"";
		}
		return " ";
	}

	public String getType() {
		return type;
	}

	public boolean isVoleur() {
		return voleur;
	}

	public void setVoleur(boolean voleur) {
		this.voleur = voleur;
	}

	public Joueur getEstVoleur() {
		return estVoleur;
	}

	public void setEstVoleur(Joueur estVoleur) {
		this.estVoleur = estVoleur;
	}
}
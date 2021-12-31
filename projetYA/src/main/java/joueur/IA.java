package joueur;

import java.awt.Color;
import java.util.Random;

import plateau.Plateau;

public class IA extends Joueur {
	public IA(String nom, Color couleur) {
		super(nom,couleur);
	}

	@Override
	public void poserRoute(Plateau p) {
		Random rand = new Random();
		int x, y;
		x = rand.nextInt(9);
		y = rand.nextInt(11);
		while(!p.poserRoute(x, y, this)) {
			x = rand.nextInt(9);
			y = rand.nextInt(11);
		}
		this.utiliserRoute();
	}

	@Override
	public void poserColonie(Plateau p) {
		Random rand = new Random();
		int x, y;
		x = rand.nextInt(9);
		y = rand.nextInt(11);
		while(!p.poserColonie(x, y, this)) {
			x = rand.nextInt(9);
			y = rand.nextInt(11);
		}
		this.utiliserColonie();
	}

	@Override
	public void poserVille(Plateau p) {
		Random rand = new Random();
		int x, y;
		x = rand.nextInt(9);
		y = rand.nextInt(11);
		while(!p.poserVille(x, y, this)) {
			x = rand.nextInt(9);
			y = rand.nextInt(11);
		}
		this.utiliserVille();
	}

	@Override
	public void deplacerVoleur(Plateau p) {
		Random rand = new Random();
		int x, y;
		x = rand.nextInt(9);
		y = rand.nextInt(11);
		while(!p.deplacerVoleur(x, y, this)) {
			x = rand.nextInt(9);
			y = rand.nextInt(11);
		}
	}

	@Override
	public void jeterSesRessources() {
		int moitie = 0;
		if(this.sommeDesRessources() > 7) {
			if(this.sommeDesRessources() % 2 == 0) {
				moitie = this.sommeDesRessources()/2;
			} else {
				moitie = this.sommeDesRessources()/2+1;
			}
			while(this.sommeDesRessources() > moitie) {
				if(this.getNbArgile() > 1) {
					this.inventaire.getRessource().replace("ARGILE",this.inventaire.getRessource().get("ARGILE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 ARGILE");
				}
				if(this.getNbBle() > 1) {
					this.inventaire.getRessource().replace("BLE",this.inventaire.getRessource().get("BLE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 BLE");
				}
				if(this.getNbBois() > 1) {
					this.inventaire.getRessource().replace("BOIS",this.inventaire.getRessource().get("BOIS")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 BOIS");
				}
				if(this.getNbLaine() > 1) {
					this.inventaire.getRessource().replace("LAINE",this.inventaire.getRessource().get("LAINE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 LAINE");
				}
				if(this.getNbMinerai() > 1) {
					this.inventaire.getRessource().replace("MINERAI",this.inventaire.getRessource().get("MINERAI")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 MINERAI");
				}
			}
		}
	}

	@Override
	public String donnerRessource() {
		String ressource = "";
		if(this.getNbArgile() > 1) {
			this.inventaire.getRessource().replace("ARGILE",this.inventaire.getRessource().get("ARGILE")-1);
			System.out.println("Joueur ["+this.toString()+"] a donné 1 ARGILE");
			ressource = "ARGILE";
		} else {
			if(this.getNbBle() > 1) {
				this.inventaire.getRessource().replace("BLE",this.inventaire.getRessource().get("BLE")-1);
				System.out.println("Joueur ["+this.toString()+"] a donné 1 BLE");
				ressource = "BLE";
			} else {
				if(this.getNbBois() > 1) {
					this.inventaire.getRessource().replace("BOIS",this.inventaire.getRessource().get("BOIS")-1);
					System.out.println("Joueur ["+this.toString()+"] a donné 1 BOIS");
					ressource = "BOIS";
				} else {
					if(this.getNbLaine() > 1) {
						this.inventaire.getRessource().replace("LAINE",this.inventaire.getRessource().get("LAINE")-1);
						System.out.println("Joueur ["+this.toString()+"] a donné 1 LAINE");
						ressource = "LAINE";
					} else {
						if(this.getNbMinerai() > 1) {
							this.inventaire.getRessource().replace("MINERAI",this.inventaire.getRessource().get("MINERAI")-1);
							System.out.println("Joueur ["+this.toString()+"] a donné 1 MINERAI");
							ressource = "MINERAI";
						}
					}
				}
			}
		}
		return ressource;
	}
}
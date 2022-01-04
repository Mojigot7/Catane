package joueur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

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
		p.affiche();
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
		p.affiche();
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
		p.affiche();
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
		p.affiche();
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
				if(this.getNbArgile() > 0 && this.sommeDesRessources() > moitie) {
					this.inventaire.getRessource().replace("ARGILE",this.inventaire.getRessource().get("ARGILE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 ARGILE");
					System.out.println("Joueur ["+this.toString()+"] a "+this.inventaire.getRessource().get("ARGILE")+" argile");
				}
				if(this.getNbBle() > 0 && this.sommeDesRessources() > moitie) {
					this.inventaire.getRessource().replace("BLE",this.inventaire.getRessource().get("BLE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 BLE");
					System.out.println("Joueur ["+this.toString()+"] a "+this.inventaire.getRessource().get("BLE")+" blé");
				}
				if(this.getNbBois() > 0 && this.sommeDesRessources() > moitie) {
					this.inventaire.getRessource().replace("BOIS",this.inventaire.getRessource().get("BOIS")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 BOIS");
					System.out.println("Joueur ["+this.toString()+"] a "+this.inventaire.getRessource().get("BOIS")+" bois");
				}
				if(this.getNbLaine() > 0 && this.sommeDesRessources() > moitie) {
					this.inventaire.getRessource().replace("LAINE",this.inventaire.getRessource().get("LAINE")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 LAINE");
					System.out.println("Joueur ["+this.toString()+"] a "+this.inventaire.getRessource().get("LAINE")+" laine");
				}
				if(this.getNbMinerai() > 0 && this.sommeDesRessources() > moitie) {
					this.inventaire.getRessource().replace("MINERAI",this.inventaire.getRessource().get("MINERAI")-1);
					System.out.println("Joueur ["+this.toString()+"] a jeté 1 MINERAI");
					System.out.println("Joueur ["+this.toString()+"] a "+this.inventaire.getRessource().get("MINERAI")+" minerai");
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
	
	public boolean echangerRessource(Plateau p) { // commerce avec le port
		Random r = new Random();
		int x = 0, rand = r.nextInt(3);
		String ressource = "",echange = "";
		if(p.estProcheDePort(this)) {
			x = 2;
		} else {
			x = 4;
		}
		if(rand == 0) {
			ressource = "BOIS";
			echange = "MINERAI";
		}
		if(rand == 1) {
			ressource = "LAINE";
			echange = "MINERAI";
		}
		if(rand == 2) {
			ressource = "ARGILE";
			echange = "MINERAI";
		}
		System.out.println(this.inventaire.getRessource().get(echange));
		if(this.inventaire.getRessource().get(echange) < x) {
			return false;
		}
		this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)+1);
		this.inventaire.getRessource().replace(echange, this.inventaire.getRessource().get(echange)-x);
		System.out.println("Joueur ["+super.toString()+"] a échangé "+x+" "+echange+" pour 1 "+ressource);
		System.out.println();
		return true;
	}
	
	@Override
	public void faireChoix(Plateau p,ArrayList<Joueur> j) {
		Random r = new Random();
		int rand = r.nextInt(9);
		while(rand == 0) {
			while(this.peutAcheterColonie()) {
				this.acheterColonie();
			}
			rand = r.nextInt(9);
		}
		while(rand == 1) {
			while(this.peutAcheterRoute()) {
				this.acheterRoute();
			}
			rand = r.nextInt(9);
		}
		while(rand == 2) {
			while(this.peutAcheterVille()) {
				this.acheterVille();
			}
			rand = r.nextInt(9);
		}
		while(rand == 3) {
			while(!p.coloniePleine() && this.possedeColonie()) {
				this.poserColonie(p);
			}
			rand = r.nextInt(9);
		}
		while(rand == 4) {
			while(!p.routePleine(this) && this.possedeRoute()) {
				this.poserRoute(p);
			}
			rand = r.nextInt(9);
		}
		while(rand == 5) {
			while(!p.villePleine(this) && this.possedeVille()) {
				this.poserVille(p);
			}
			rand = r.nextInt(9);
		}
		if(rand == 6) {
			this.echangerRessource(p);
			rand = r.nextInt(9);
		}
		while(rand == 7) {
			while(!p.coloniePleine() && this.possedeColonie()) {
				this.poserColonie(p);
			}
			rand = r.nextInt(9);
		}
		while(rand == 8) {
			while(this.peutAcheterColonie()) {
				this.acheterColonie();
			}
			rand = r.nextInt(9);
		}
	}
	
	public void voirInventaire() {
		System.out.println("Inventaire de "+this.nom+" :");
		for(Map.Entry<String, Integer> inv : this.inventaire.getBatiment().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
		for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
	}
}
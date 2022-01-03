package joueur;

import java.awt.Color;
import java.util.*;

import colors.ConsoleColors;
import inventaire.*;
import plateau.Plateau;

public abstract class Joueur {
	protected int score = 2;
	protected int cptChevalier = 0;
	protected String nom;
	protected Inventaire inventaire;
	protected Color couleur;
	protected Developpement dev;
	
	public int getCptChevalier() {
		return cptChevalier;
	}

	public Joueur(String nom, Color couleur) {
		this.nom = nom;
		this.couleur = couleur;
		dev = new Developpement(new LinkedList<Developpement>());
		this.inventaire = new Inventaire();
	}
	
	public String toString() {
		if(this.couleur.getRGB() == Color.BLUE.getRGB()) {
			return ConsoleColors.BLUE+this.nom+ConsoleColors.RESET;
		}
		if(this.couleur.getRGB() == Color.RED.getRGB()) {
			return ConsoleColors.RED+this.nom+ConsoleColors.RESET;
		}
		if(this.couleur.getRGB() == Color.GREEN.getRGB()) {
			return ConsoleColors.GREEN+this.nom+ConsoleColors.RESET;
		}
		return ConsoleColors.YELLOW+this.nom+ConsoleColors.RESET;
		}
		
		public int getNbArgile() {
			return this.inventaire.getRessource().get("ARGILE");
		}
		
		public int getNbBois() {
			return this.inventaire.getRessource().get("BOIS");
		}
		
		public int getNbBle() {
			return this.inventaire.getRessource().get("BLE");
		}
		
		public int getNbLaine() {
			return this.inventaire.getRessource().get("LAINE");
		}
		
		public int getNbMinerai() {
			return this.inventaire.getRessource().get("MINERAI");
		}
		
		public int getNbColonie() {
			return this.inventaire.getBatiment().get("COLONIE");
		}
		
		public int getNbRoute() {
			return this.inventaire.getBatiment().get("ROUTE");
		}
		
		public int getNbVille() {
			return this.inventaire.getBatiment().get("VILLE");
		}
		
		public boolean possedeColonie() {
			if(this.inventaire.getBatiment().get("COLONIE") > 0) {
				return true;
			}
			return false;
		}
		
		public boolean possedeRoute() {
			if(this.inventaire.getBatiment().get("ROUTE") > 0) {
				return true;
			}
			return false;
		}
		
		public boolean possedeVille() {
			if(this.inventaire.getBatiment().get("VILLE") > 0) {
				return true;
			}
			return false;
		}
		
		public void utiliserColonie() {
			this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")-1);
		}
		
		public void utiliserRoute() {
			this.inventaire.getBatiment().replace("ROUTE", this.inventaire.getBatiment().get("ROUTE")-1);
		}
		
		public void utiliserVille() {
			this.inventaire.getBatiment().replace("VILLE", this.inventaire.getBatiment().get("VILLE")-1);
			this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")+1);
		}
		
		public boolean peutAcheterColonie() {
			if(this.inventaire.getRessource().get("ARGILE") < 1) {
				return false;
			}
			if(this.inventaire.getRessource().get("BOIS") < 1) {
				return false;
			}
			if(this.inventaire.getRessource().get("LAINE") < 1) {
				return false;
			}
			if(this.inventaire.getRessource().get("BLE") < 1) {
				return false;
			}
			return true;
		}
		
		public boolean peutAcheterRoute() {
			if(this.inventaire.getRessource().get("ARGILE") < 1) {
				return false;
			}
			if(this.inventaire.getRessource().get("BOIS") < 1) {
				return false;
			}
			return true;
		}
		
		public boolean peutAcheterVille() {
			if(this.inventaire.getRessource().get("MINERAI") < 3) {
				return false;
			}
			if(this.inventaire.getRessource().get("BLE") < 2) {
				return false;
			}
			return true;
		}
		
		public void acheterColonie() {
			this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")+1);
			this.inventaire.getRessource().replace("ARGILE", this.inventaire.getRessource().get("ARGILE")-1);
			this.inventaire.getRessource().replace("BOIS", this.inventaire.getRessource().get("BOIS")-1);
			this.inventaire.getRessource().replace("LAINE", this.inventaire.getRessource().get("LAINE")-1);
			this.inventaire.getRessource().replace("BLE", this.inventaire.getRessource().get("BLE")-1);
			this.score += 1;
			System.out.println("Joueur ["+this.toString()+"] a gagné 1 points de victoire !");
		}
		
		public void acheterRoute() {
			this.inventaire.getBatiment().replace("ROUTE", this.inventaire.getBatiment().get("ROUTE")+1);
			this.inventaire.getRessource().replace("ARGILE", this.inventaire.getRessource().get("ARGILE")-1);
			this.inventaire.getRessource().replace("BOIS", this.inventaire.getRessource().get("BOIS")-1);
		}
		
		public void acheterVille() {
			this.inventaire.getBatiment().replace("VILLE", this.inventaire.getBatiment().get("VILLE")+1);
			this.inventaire.getRessource().replace("MINERAI", this.inventaire.getRessource().get("MINERAI")-3);
			this.inventaire.getRessource().replace("BLE", this.inventaire.getRessource().get("BLE")-2);
			this.score += 2;
			System.out.println("Joueur ["+this.toString()+"] a gagné 2 points de victoire !");
		}
		
		public int sommeDesRessources() { // Pour l'implémentation du Voleur
			int somme = 0;
			for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
				somme += inv.getValue();
			}
			return somme;
		}
		
		public void ressourceAleatoire(String typeDeRessource, boolean estVille) { // Compare le type de la tuile à la ressource associé. Donne 2 ressources pour les villes et 1 pour les colonies
			for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
				if(inv.getKey().equals(typeDeRessource)) {
					if(estVille) {
						this.inventaire.getRessource().replace(inv.getKey(), this.inventaire.getRessource().get(inv.getKey())+2);
					}else {
						this.inventaire.getRessource().replace(inv.getKey(), this.inventaire.getRessource().get(inv.getKey())+1);
					}
					return;
				}
			}
		}
		
		public void recupRessourceDonnee(ArrayList<String> s){
			for(String r : s) {
				if(this.inventaire.getRessource().containsKey(r)) {
					this.inventaire.getRessource().replace(r, this.inventaire.getRessource().get(r)+1);
				}
			}
		}
		
		public int lancerDees() {
			Random rand = new Random();
			return rand.nextInt(11)+2;
		}
		
		public boolean peutCreeCarteDev(){
			if(inventaire.getRessource().get("MINERAI") > 1 
			&& inventaire.getRessource().get("LAINE") > 1
			&& inventaire.getRessource().get("BLE") > 1)
			return true;

			return false;
		}

		public void CreeCarteDev(){
			if(peutCreeCarteDev()){
				this.inventaire.getRessource().replace("MINERAI", this.inventaire.getRessource().get("MINERAI")-1);
				this.inventaire.getRessource().replace("MINERAI", this.inventaire.getRessource().get("LAINE")-1);
				this.inventaire.getRessource().replace("BLE", this.inventaire.getRessource().get("BLE")-1);
				dev.creationCarteDev(dev.getCarteDev());
			}
		}

		public void UtiliserChevalier(Plateau p){
			if(dev.peutUtiliserChevalier()){
				deplacerVoleur(p);
				this.cptChevalier++;
			}
		}

		public void UtiliserConstructionDeRoute(){
			if(dev.peutUtiliserConstructionDeRoute()){
				inventaire.getBatiment().replace("ROUTE", this.inventaire.getBatiment().get("ROUTE")+2);
				dev.supprimer("Construction de route");
			}
		}

		public void UtiliserInvention(String r1, String r2){
			if(dev.peutUtiliserInvention()){
				choisirRessource(r1, r2);
				dev.supprimer("Invention");
			}
		}

		public void choisirRessource(String r1, String r2){
			if(r1.equals("BOIS") || r1.equals("ARGILE") ||r1.equals("LAINE") || r1.equals("MINERAI")|| r1.equals("BLE")
			&& r2.equals("BOIS") || r2.equals("ARGILE") ||r2.equals("LAINE") || r2.equals("MINERAI")|| r2.equals("BLE")){
				inventaire.getRessource().replace(r1, inventaire.getRessource().get(r1)+1);
				inventaire.getRessource().replace(r2, inventaire.getRessource().get(r2)+1);
			}
		}

		public void UtiliserMonopole(String r1,ArrayList<Joueur> j){
			if(r1.equals("BOIS") || r1.equals("ARGILE") ||r1.equals("LAINE") || r1.equals("MINERAI")|| r1.equals("BLE")
			&& dev.peutUtiliserMonopole()){
				for(int i = 0 ; i < j.size() ; i++){
					if(j.get(i).nom.equals(this.nom) == false){
						if(r1.equals("BOIS")){
							inventaire.getRessource().replace(r1,inventaire.getRessource().get(r1)+j.get(i).getNbBois());
							j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbBois());
						}
						
						if(r1.equals("ARGILE")){
							inventaire.getRessource().replace(r1,inventaire.getRessource().get(r1)+j.get(i).getNbArgile());
							j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbArgile());
						}
						if(r1.equals("LAINE")){
							inventaire.getRessource().replace(r1,inventaire.getRessource().get(r1)+j.get(i).getNbLaine());
							j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbLaine());
						}
						
						if(r1.equals("MINERAI")){
							inventaire.getRessource().replace(r1,inventaire.getRessource().get(r1)+j.get(i).getNbMinerai());
							j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbMinerai());
						}
						if(r1.equals("BLE")){
							inventaire.getRessource().replace(r1,inventaire.getRessource().get(r1)+j.get(i).getNbBle());
							j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbBle());
						}
					}
				}
			}
		}

		public int UtiliserPointDeVictoire(){
			if(dev.peutUtiliserPDV())
				return dev.compterPtsDeVictoire();
			return 0;
		}

		public abstract void poserRoute(Plateau p);
		public abstract void poserColonie(Plateau p);
		public abstract void poserVille(Plateau p);
		public abstract void deplacerVoleur(Plateau p);
		public abstract void jeterSesRessources();
		public abstract String donnerRessource();
		public abstract void faireChoix(Plateau p);
		
		public Color getCouleur() {
			return couleur;
		}
		
		public int getScore() {
			return score;
		}
		
		public void setScore(int score) {
			this.score = score;
		}

		public Inventaire getInventaire() {
			return inventaire;
		}

		public void setInventaire(Inventaire inventaire) {
			this.inventaire = inventaire;
		}
}

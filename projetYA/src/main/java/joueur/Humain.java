package joueur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import plateau.Plateau;

public class Humain extends Joueur {
	private Scanner sc;
	
	public Humain(String nom, Color couleur) {
		super(nom, couleur);
		this.sc = new Scanner(System.in);
	}

	@Override
	public void poserRoute(Plateau p) { //TODO: route la plus longue
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserRoute(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserRoute();
		System.out.println();
		p.affiche();
	}

	@Override
	public void poserColonie(Plateau p) { // Permet de poser une colonie sur les intersections des tuiles
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc.nextInt();
		while(!p.poserColonie(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserColonie();
		System.out.println();
		p.affiche();
	}

	@Override
	public void poserVille(Plateau p) { // Permet de poser une ville par dessus une colonie
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserVille(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserVille();
		System.out.println();
		p.affiche();
	}
	
	@Override
	public void jeterSesRessources() { // Quand un joueur fait 7 : permet de jetter la moitié de ses ressources si on en a plus de 7
		int x=-1, moitie;
		String ressource = "";
		if(this.sommeDesRessources() > 7) {
			if(this.sommeDesRessources() % 2 == 0) {
				moitie = this.sommeDesRessources()/2;
			} else {
				moitie = this.sommeDesRessources()/2+1;
			}
			while(this.sommeDesRessources() > moitie) {
				System.out.println("Il vous reste encore "+(this.sommeDesRessources()-moitie)+" à jeter.");
				System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jeter ? \n"
						+ "- Blé (Entrez BLE) \n"
						+ "- Bois (Entrez BOIS) \n"
						+ "- Minerai (Entrez MINERAI) \n"
						+ "- Argile (Entrez ARGILE) \n"
						+ "- Laine (Entrez LAINE)");
				ressource = sc.next().toUpperCase();
				while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
					System.out.println("Vous n'avez pas de ressources de ce type !");
					System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jeter ? \n"
							+ "- Blé (Entrez BLE) \n"
							+ "- Bois (Entrez BOIS) \n"
							+ "- Minerai (Entrez MINERAI) \n"
							+ "- Argile (Entrez ARGILE) \n"
							+ "- Laine (Entrez LAINE)");
					ressource = sc.next().toUpperCase();
				}
				System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jeter ? (Entrée un entier)");
				x = sc.nextInt(); //TO FIX: si la personne met autre chose qu'un entier le programme s'arrête
				while( this.inventaire.getRessource().get(ressource) < x || x < 0) {
					System.out.println("Vous n'avez pas assez de ressources de ce type pour en jeter autant !");
					System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jeter ? (Entrée un entier) /n"
							+ "Ou revenez en arrière (Entrée 0)");
					x = sc.nextInt();
				}
				if(x == 0) {
					this.jeterSesRessources();
					return;
				}
				this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)-x);
				System.out.println("Joueur ["+super.toString()+"] a jeté "+x+" "+ressource);
			}
		}
		System.out.println();
	}
	
	@Override
	public void deplacerVoleur(Plateau p) { // deplace le voleur
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.deplacerVoleur(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		System.out.println();
		p.affiche();
	}
	
	@Override
	public String donnerRessource() { // Quand un joueur se fait voler une ressource il donne une ressource de son choix
		String ressource = "";
		System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous donner ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		ressource = sc.next().toUpperCase();
		while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
			System.out.println("Ce n'est pas une ressource valable !");
			System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous donner ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			ressource = sc.next().toUpperCase();
		}
		this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)-1);
		System.out.println("Joueur ["+super.toString()+"] a donné 1 "+ressource);
		System.out.println();
		return ressource;
	}
	
	public void echangerRessource(Plateau p) { // commerce avec le port
		String ressource = "", echange = "";
		int x = 0;
		if(p.estProcheDePort(this)) {
			x = 2;
		} else {
			x = 4;
		}
		System.out.println("Joueur ["+super.toString()+"] : Vous pouvez échanger "+x+"ressources pour 1 ressource");
		System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous avoir ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		ressource = sc.next().toUpperCase();
		while(this.inventaire.getRessource().get(ressource) == null) {
			System.out.println("Ce n'est pas une ressource valable !");
			System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous avoir ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			ressource = sc.next().toUpperCase();
		}
		System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous échanger ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		echange = sc.next().toUpperCase();
		while(this.inventaire.getRessource().get(echange) == null || this.inventaire.getRessource().get(echange) < x || echange.equals(ressource)) {
			System.out.println("Ce n'est pas une ressource valable ! (vous n'en avez pas assez)");
			System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous échanger ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			echange = sc.next().toUpperCase();
		}
		this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)+1);
		this.inventaire.getRessource().replace(echange, this.inventaire.getRessource().get(echange)-x);
		System.out.println("Joueur ["+super.toString()+"] a échangé "+x+" "+echange+" pour 1 "+ressource);
		System.out.println();
	}

	@Override
	public void faireChoix(Plateau p,ArrayList<Joueur> j) {
		String reponse = null;
		System.out.println("Joueur ["+this.toString()+"] que voulez vous faire :");
		
		if(!p.coloniePleine() && this.possedeColonie()) { // peut poser Colonie
			System.out.println("- poser une Colonie (Entrée pc)");
		}
		if(!p.routePleine(this) && this.possedeRoute()) { // peut poser Colonie
			System.out.println("- poser une Route (Entrée pr)");
		}	
		if(!p.villePleine(this) && this.possedeVille()) { // peut poser Colonie
			System.out.println("- poser une Ville (Entrée pv)");
		}
		if(this.peutAcheterColonie()) {
			System.out.println("- construire une Colonie (Entrée c)");
		}
		if(this.peutAcheterRoute()) {
			System.out.println("- construire une Route (Entrée r)");
		}
		if(this.peutAcheterVille()) {
			System.out.println("- construire une Ville (Entrée v)");
		}
		if(this.sommeDesRessources() > 4 || (p.estProcheDePort(this) && this.sommeDesRessources() > 2)) {
			System.out.println("- faire du commerce (Entrée a)");
		}
		if(this.peutCreeCarteDev()) {
			System.out.println("- acheter une carte de Développement (Entrée d)");
		}
		if(this.getDev().peutUtiliserChevalier()) {
			System.out.println("- utiliser une carte Chevalier (Entrée ch)");
		}
		if(this.getDev().peutUtiliserConstructionDeRoute()) {
			System.out.println("- utiliser une carte Construction de Route (Entrée cdr)");
		}
		if(this.getDev().peutUtiliserInvention()) {
			System.out.println("- utiliser une carte Invention (Entrée inv)");
		}
		if(this.getDev().peutUtiliserMonopole()) {
			System.out.println("- utiliser une carte Monopole (Entrée m)");
		}
		if(this.getDev().peutUtiliserPDV()) {
			System.out.println("- utiliser une carte Point de Victoire (Entrée pdv)");
		}
		System.out.println("- consulter vos ressources (Entrée i)");
		System.out.println("- passez votre tour (Entrée q)");
		reponse = sc.next().toUpperCase();
		
		if(reponse.equals("I")) {
			this.voirInventaire();
			while(!reponse.equals("R")) {
				System.out.println("- Revenez en arrière (Entrée r)");
				reponse = sc.next().toUpperCase();
			}
			this.faireChoix(p,j);
			return;
		}
		while(reponse.equals("PDV") && !this.getDev().peutUtiliserPDV()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("M") && !this.getDev().peutUtiliserMonopole()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("INV") && !this.getDev().peutUtiliserInvention()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("CDR") && !this.getDev().peutUtiliserConstructionDeRoute()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("CH") && !this.getDev().peutUtiliserChevalier()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("D") && !this.peutCreeCarteDev()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("A") && !(this.sommeDesRessources() > 4 || (p.estProcheDePort(this) && this.sommeDesRessources() > 2))) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("PC") && (!this.possedeColonie() || p.coloniePleine())) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("PR") && (!this.possedeRoute() || p.routePleine(this))) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("PV") && (!this.possedeVille() || p.villePleine(this))) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("C") && !this.peutAcheterColonie()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("R") && !this.peutAcheterRoute()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		while(reponse.equals("V") && !this.peutAcheterVille()) {
			System.out.println("Cette action n'est pas possible si elle existe !");
			reponse = sc.next().toUpperCase();
		}
		if(reponse.equals("PC")) {
			this.poserColonie(p);
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("PR")) {
			this.poserRoute(p);
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("PV")) {
			this.poserVille(p);
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("C")) {
			this.acheterColonie();
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("R")) {
			this.acheterRoute();
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("V")) {
			this.acheterVille();
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("A")) {
			this.echangerRessource(p);
			this.faireChoix(p,j);
			return;
		}
		if(reponse.equals("D")) {
			this.CreeCarteDev();
			return;
		}
		if(reponse.equals("CH")) {
			this.UtiliserChevalier(p);
			return;
		}
		if(reponse.equals("CDR")) {
			this.UtiliserConstructionDeRoute();
			return;
		}
		if(reponse.equals("INV")) {
			this.UtiliserInvention();
			return;
		}
		if(reponse.equals("M")) {
			this.UtiliserMonopole(j);
			return;
		}
		if(reponse.equals("PDV")) {
			this.UtiliserPointDeVictoire();
			return;
		}
		if(reponse.equals("Q")) {
			System.out.println();
			return;
		} else {
			this.faireChoix(p,j);
		}
		System.out.println();
	}
	
	public void voirInventaire() {
		System.out.println("Batiments : ");
		System.out.println("Inventaire de "+this.nom+" :");
		for(Map.Entry<String, Integer> inv : this.inventaire.getBatiment().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
		System.out.println("Ressources : ");
		for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
		System.out.println("Carte de Développement : ");
		this.getDev().afficheCarteDev();
	}
	
	public void UtiliserMonopole(ArrayList<Joueur> j){
		String r1 = "";
		while(!r1.equals("BOIS") && !r1.equals("BLE") && !r1.equals("ARGILE") && !r1.equals("MINERAI") && !r1.equals("LAINE")) {
			System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous avoir ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			r1 = sc.next().toUpperCase();
		}
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
			dev.supprimer("Monopole");
		}
	}
	
	public void UtiliserInvention(){
		String r1 = "", r2 = "";
		while(!r2.equals("BOIS") && !r2.equals("BLE") && !r2.equals("ARGILE") && !r2.equals("MINERAI") && !r2.equals("LAINE")) {
			System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous avoir ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			r2 = sc.next().toUpperCase();
		}
		while(!r1.equals("BOIS") && !r1.equals("BLE") && !r1.equals("ARGILE") && !r1.equals("MINERAI") && !r1.equals("LAINE")) {
			System.out.println("Joueur ["+super.toString()+"] : Quelle ressource voulez-vous échanger à la place ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			r1 = sc.next().toUpperCase();
		}
		if(dev.peutUtiliserInvention()){
			choisirRessource(r1, r2);
			System.out.println("Joueur ["+this.toString()+"] a reçu 1 "+r2+" et a perdu 1 "+r1);
			dev.supprimer("Invention");
		}
	}
}
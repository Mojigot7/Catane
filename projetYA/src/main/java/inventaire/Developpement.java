package inventaire;

import java.util.LinkedList;

public class Developpement {

    private String nom;
    private LinkedList<Developpement> stock;

    public Developpement(LinkedList<Developpement> stock){ // Constructeur pour une liste vide 
        this.stock = stock;
    }

    public Developpement(String nom,LinkedList<Developpement> stock){ // Constructeur lors d'un ajout d'une carte developpement
        this.nom = nom;
        this.stock = stock;
    }

    public void creationCarteDev(LinkedList<Developpement>stock){
        int aleatoire = (int)(Math.random()*3); // Notion d'aleatoire Entre les 3 types de developpmement
        if(aleatoire == 0){ // On choisit arbitrairement le chiffre tire au sort 
            Developpement tmp = new Developpement("Point de Victoire",stock); // Le premier cree une carte point de victoire
            stock.add(tmp);
            System.out.println("Vous avez reçu la carte Point de Victoire !");
        }
        if(aleatoire == 1){
            Developpement tmp = new Developpement("Chevalier",stock); // Le deuxieme cree une carte chevalier
            stock.add(tmp);
            System.out.println("Vous avez reçu la carte Chevalier !");
        }
        if(aleatoire == 2){ // Ici on cree les cartes progres
            int aleaprogres = (int)(Math.random()*3); // On recree un objet aleatoire pour que ca corresponde mieux au probabilite
            if(aleaprogres == 0){
                Developpement tmp = new Developpement("Construction de route",stock);  // Le premier cree une carte Construction de route
                stock.add(tmp);
                System.out.println("Vous avez reçu la carte Construction de route !");
            }
            if(aleaprogres == 1){
                Developpement tmp = new Developpement("Invention",stock); // Le deuxieme une carte Invention
                stock.add(tmp);
                System.out.println("Vous avez reçu la carte Invention !");
            }
            if(aleaprogres == 2){
                Developpement tmp = new Developpement("Monopole",stock); // Le troisieme une carte Monopole
                stock.add(tmp);
                System.out.println("Vous avez reçu la carte Monopole !");
            }
        }else{
           // System.out.println("BUG Developpement constructor !"); // Cas pour detecter les erreur qui ne devrait pas arriver en temps normal
        }
    }

    public String getNom(){
        return this.nom;
    }

    public LinkedList<Developpement> getCarteDev(){
        return this.stock;
    }

    public boolean peutUtiliserChevalier(){
        for(int i = 0 ; i < stock.size(); i++){
            if(stock.get(i).nom.equals("Chevalier"))
                return true;
        }
        return false;
    }

    public boolean peutUtiliserPDV(){
        for(int i = 0 ; i < stock.size(); i++){
            if(stock.get(i).nom.equals("Point de Victoire"))
                return true;
        }
        return false;
    }

    public boolean peutUtiliserConstructionDeRoute(){
        for(int i = 0 ; i < stock.size(); i++){
            if(stock.get(i).nom.equals("Construction de route"))
                return true;
        }
        return false;
    }

    public boolean peutUtiliserInvention(){
        for(int i = 0 ; i < stock.size(); i++){
            if(stock.get(i).nom.equals("Invention"))
                return true;
        }
        return false;
    }

    public boolean peutUtiliserMonopole(){
        for(int i = 0 ; i < stock.size(); i++){
            if(stock.get(i).nom.equals("Monopole"))
                return true;
        }
        return false;
    }

    public int compterPtsDeVictoire(){
        int res = 0;
        for(int i = 0 ; i < stock.size() ; i++){
            if((stock.get(i).nom).equals("Point de Victoire"))
                res++;
        }
        return res;
    }
    public void supprimer(String nom){
        for(int i = 0 ; i < stock.size()-1 ; i++){
            if((stock.get(i).nom).equals(nom)){
                stock.remove(i);
            }
        }
    }

    public void afficheCarteDev(){
        for(int i = 0 ; i < stock.size() ; i++){
            System.out.println(stock.get(i).nom);
        }
    }

	public LinkedList<Developpement> getStock() {
		return stock;
	}
}



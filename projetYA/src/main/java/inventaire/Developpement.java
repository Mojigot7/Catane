package inventaire;

import java.util.LinkedList;

public class Developpement {

    private String nom;
    private LinkedList<Developpement> stock;

    public Developpement(LinkedList<Developpement> stock){
        this.stock = stock;
    }

    public Developpement(String nom,LinkedList<Developpement> stock){
        this.nom = nom;
        this.stock = stock;
    }

    public void creationCarteDev(LinkedList<Developpement>stock){
        int aleatoire = (int)(Math.random()*2);
        if(aleatoire == 0){
            Developpement tmp = new Developpement("Point de Victoire",stock);
            stock.add(tmp);
        }
        if(aleatoire == 1){
            Developpement tmp = new Developpement("Chevalier",stock);
            stock.add(tmp);
        }
        if(aleatoire == 2){
            int aleaprogres = (int)(Math.random()*2);
            if(aleaprogres == 0){
                Developpement tmp = new Developpement("Construction de route",stock);
                stock.add(tmp);
            }
            if(aleaprogres == 1){
                Developpement tmp = new Developpement("Invention",stock);
                stock.add(tmp);
            }
            if(aleaprogres == 2){
                Developpement tmp = new Developpement("Monopole",stock);
                stock.add(tmp);
            }
        }
        else{
            System.out.println("BUG Developpement constructor !");
        }
    }

    public String getNom(){
        return this.nom;
    }

    public LinkedList<Developpement> getCarteDev(){
        return this.stock;
    }

    public void afficheCarteDev(){
        for(int i = 0 ; i < stock.size() ; i++){
            System.out.println(stock.get(i).nom);
        }
    }
    public static void main(String [] agrs){
        LinkedList<Developpement> test = new LinkedList<>();
        Developpement tmp = new Developpement(test);
        tmp.creationCarteDev(test);
        tmp.afficheCarteDev();
    }
}



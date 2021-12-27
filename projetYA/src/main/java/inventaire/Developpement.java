/*package inventaire;

import java.util.LinkedList;

public class Developpement {
    LinkedList stock = new LinkedList<Developpement>();

    public Developpement(){
        int aleatoire;
        aleatoire = (int)(Math.random()*2);
        if(aleatoire == 0){
            PdVictoire tmp = new PdVictoire();
            this.add(tmp);
        }
        if(aleatoire == 1){
            int aleatoirerprogres;
            aleatoirerprogres = (int)(Math.random()*2);
            addprogres(aleatoirerprogres);
        }
        if(aleatoire == 2){
            Chevalier tmp = new Chevalier();
            this.add(tmp);
        }
        else{
            System.out.println("BUG Developpement constructor !");
        }
    }

    public void addprogres(int a){
        if(a == 0){
            Construction tmp = new Construction();
            this.add(tmp);
        }
        if(a == 1){
            Invention tmp = new Invention();
            this.add(tmp);
        }
        if(a == 2){
            Monopole tmp = new Monopole();
            this.add(tmp);
        }
        else{
            System.out.println("Bug on addprogres method !");
        }
    }

    public void add(Object e){
        if(e instanceof PdVictoire || e instanceof Construction || e instanceof Chevalier || e instanceof Invention || e instanceof Monopole){
            stock.add(e);
        }
        else{
            System.out.println("BUG on add(In Developpement class) !");
        }
    }

    public class PdVictoire {
        
        private int points = 1;
        
        public PdVictoire(){}

        public int getPoints(){
            return points;
        }
    }

    public class Construction{
        //private int quantite; // Il doit y avoir maximun 2 carte de construction

    }

    public class Invention{
        //private int quantite; // Max 2 carte Invention
    }

    public class Monopole{
        //private int quantite; // Max 2 carte Monpole
    }


    public class Chevalier{

        public Chevalier(){}

    }
}
*/
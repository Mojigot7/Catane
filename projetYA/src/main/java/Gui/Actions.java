package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joueur.Joueur;


public class Actions extends JFrame{

    private JPanel main = new JPanel();
    
    private ArrayList<Joueur> listjoueur;
    private Joueur courant;

    private JPanel deeconteneur;
    private boolean creationunique = true;
    private Poser boutonposer;
    private ChoixActions choixActions;

    private Gui principale;

    public Actions(ArrayList<Joueur> list,Gui principale,Joueur c){
        listjoueur = list;
        this.principale = principale;
        courant = c;

        main.setLayout(new BorderLayout());

        JLabel dee = new JLabel();
        dee.setText(" Dée obtenu : " + courant.lancerDees() );
        deeconteneur = new JPanel();
        deeconteneur.setVisible(false);
        deeconteneur.add(dee);

        main.add(new Debut().getContent(),BorderLayout.CENTER);
        main.add(deeconteneur,BorderLayout.WEST);

    }

    private class Debut{

        private JPanel content;

        public Debut(){
            content = new JPanel();
            content.setLayout(new FlowLayout());
            JButton lanceeDee = new JButton(" Lancee Les Dees ");
            JButton finDeTour = new JButton(" Fin De Tour ");
            content.add(lanceeDee);
            content.add(finDeTour);
            lanceeDee.addActionListener( event -> {
                deeconteneur.setVisible(true);
                main.removeAll();
                choixActions = new ChoixActions();
                main.add(choixActions.getChoixActionsContent());
                main.revalidate();
            });
        }

        public JPanel getContent(){
            return content;
        }
    }

    public class ChoixActions{

        private JPanel content = new JPanel();
        private JButton poser = new JButton(" Poser Batiment ");
        private JButton construire = new JButton(" Construire Batiment ");
        private JButton developpement = new JButton(" Developpement ");
        private JButton findeTour = new JButton(" Fin De Tour ");
        

        public ChoixActions(){
            poser.setEnabled(courant.possedeColonie() || courant.possedeRoute() || courant.possedeVille());
            construire.setEnabled(courant.peutAcheterColonie() || courant.peutAcheterRoute() || courant.peutAcheterVille());
            developpement.setEnabled(courant.peutCreeCarteDev() || courant.getDev().getStock().size()> 0);
            poser.addActionListener(event -> {
                main.removeAll();
                boutonposer = new Poser();
                main.add(boutonposer.getContent());
                main.revalidate();
            });
            construire.addActionListener(event ->{
                main.removeAll();
                main.add(new Construire().getContent());
                main.revalidate();
            });
            developpement.addActionListener(event ->{
                main.removeAll();
                main.add(new Developpement().getContent());
                main.revalidate();
            });
            content.add(poser);
            content.add(construire);
            content.add(developpement);
            content.add(findeTour);
        }

        public JPanel getChoixActionsContent(){
            return content;
        }
    }

    public class Poser{

        private JPanel content = new JPanel();
        private JButton route = new JButton(" Poser Route ");
        private JButton colonie = new JButton(" Poser Colonie ");
        private JButton ville = new JButton(" Poser Ville ");
        private JButton retour = new JButton(" Retour ");

        public Poser(){
            route.setEnabled(courant.possedeRoute());
            route.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("ROUTE", courant.getInventaire().getBatiment().get("ROUTE")-1);
                colonie.setEnabled(false);
                ville.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("route", courant.getNbRoute());
            });
            colonie.setEnabled(courant.possedeColonie());
            colonie.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("COLONIE", courant.getInventaire().getBatiment().get("COLONIE")-1);
                route.setEnabled(false);
                ville.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", courant.getNbColonie());
            });
            ville.setEnabled(courant.possedeVille());
            ville.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("VILLE", courant.getInventaire().getBatiment().get("VILLE")-1);
                courant.getInventaire().getBatiment().replace("COLONIE", courant.getInventaire().getBatiment().get("COLONIE")+1);
                route.setEnabled(false);
                colonie.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("ville", courant.getNbVille());
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", courant.getNbColonie());
            });
            retour.addActionListener(event -> {
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
            content.add(route);
            content.add(colonie);
            content.add(ville);
            content.add(retour);
        }

        public JPanel getContent(){
            return content;
        }

        public JButton getPoserRoute(){
            return route;
        }

        public JButton getPoserColonie(){
            return colonie;
        }

        public JButton getPoserVille(){
            return ville;
        }
    }

    public class Construire{

        private JPanel content = new JPanel();
        private JButton route = new JButton(" Cree Route ");
        private JButton colonie = new JButton(" Cree Colonie ");
        private JButton ville = new JButton(" Cree Ville ");
        private JButton retour = new JButton(" Retour ");
        
        public Construire(){
            route.setEnabled(courant.peutAcheterRoute());
            content.add(route);
            route.addActionListener(event ->  {
                courant.getInventaire().getBatiment().replace("ROUTE", courant.getInventaire().getBatiment().get("ROUTE")+1);
                courant.getInventaire().getRessource().replace("ARGILE", courant.getInventaire().getRessource().get("ARGILE")-1);
                courant.getInventaire().getRessource().replace("BOIS", courant.getInventaire().getRessource().get("BOIS")-1);
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("route", courant.getNbRoute());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", courant.getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", courant.getNbBois());
            });
            colonie.setEnabled(courant.peutAcheterColonie());
            content.add(colonie);
            colonie.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("COLONIE", courant.getInventaire().getBatiment().get("COLONIE")+1);
                courant.getInventaire().getRessource().replace("ARGILE", courant.getInventaire().getRessource().get("ARGILE")-1);
                courant.getInventaire().getRessource().replace("BOIS", courant.getInventaire().getRessource().get("BOIS")-1);
                courant.getInventaire().getRessource().replace("LAINE", courant.getInventaire().getRessource().get("LAINE")-1);
                principale.getInformationJoueur().getRessource().setQuantité("BLE", courant.getNbBle());
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", courant.getNbColonie());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", courant.getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", courant.getNbBois());
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", courant.getNbLaine());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", courant.getNbBle());
            });
            ville.setEnabled(courant.peutAcheterVille());
            content.add(ville);
            ville.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("VILLE", courant.getInventaire().getBatiment().get("VILLE")+1);
                courant.getInventaire().getRessource().replace("MINERAI", courant.getInventaire().getRessource().get("MINERAI")-3);
                courant.getInventaire().getRessource().replace("BLE", courant.getInventaire().getRessource().get("BLE")-2);
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("ville", courant.getNbVille());
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", courant.getNbMinerai());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", courant.getNbBle());
            });
            content.add(retour);
            retour.addActionListener(event -> {
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });

        }
        public JPanel getContent(){
            return content;
        }
    }

    public class Developpement{

        private JPanel content = new JPanel();
        private JButton utiliser = new JButton(" Utiliser Carte Dev ");
        private JButton cree = new JButton(" Creer Carte Dev ");
        private JButton retour = new JButton(" Retour ");
        
        public Developpement(){
            utiliser.setEnabled(courant.getDev().getStock().size() >= 0);
            content.add(utiliser);
            utiliser.addActionListener(event -> {
                main.removeAll();
                main.add(new CarteDev().getContent());
                main.revalidate();
            });
            cree.setEnabled(courant.peutCreeCarteDev() && creationunique == true);
            content.add(cree);
            cree.addActionListener(event ->{
                courant.getInventaire().getRessource().replace("MINERAI", courant.getInventaire().getRessource().get("MINERAI")-1);
				courant.getInventaire().getRessource().replace("LAINE", courant.getInventaire().getRessource().get("LAINE")-1);
				courant.getInventaire().getRessource().replace("BLE", courant.getInventaire().getRessource().get("BLE")-1);
				courant.getDev().creationCarteDev(courant.getDev().getCarteDev());
                creationunique = false;
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", courant.getInventaire().getRessource().get("MINERAI"));
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", courant.getInventaire().getRessource().get("LAINE"));
                principale.getInformationJoueur().getRessource().setQuantité("BLE", courant.getInventaire().getRessource().get("BLE"));
                principale.getInformationJoueur().getDeveloppement().setQuantité("chevalier", courant.getDev().getNbChevalier());
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", courant.getDev().getNbInvention());
                principale.getInformationJoueur().getDeveloppement().setQuantité("monopole", courant.getDev().getNbMonopole());
                principale.getInformationJoueur().getDeveloppement().setQuantité("pdv", courant.getDev().compterPtsDeVictoire());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", courant.getDev().getNbConstructiondeRoute());
            });
            content.add(retour);
            retour.addActionListener(event -> {
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
        }
        public JPanel getContent(){
            return content;
        }
    }

    public JPanel getContent(){
        return main;
    }

    public class CarteDev{

        private JPanel content;

        public CarteDev(){
            content = new JPanel();
            JButton chevalier = new JButton(" Utiliser Chevalier ");
            JButton invention = new JButton(" Utiliser Invention ");
            JButton monopole = new JButton(" Utiliser Monopole");
            JButton consRoute = new JButton(" Utiliser Construction De Route ");
            JButton retour = new JButton(" Retour ");

            chevalier.setEnabled(courant.getDev().getNbChevalier() > 0);
            invention.setEnabled(courant.getDev().getNbInvention() > 0);
            invention.addActionListener(event -> {
                main.removeAll();
                main.add(new InventionPanel().getcontent());
                main.revalidate();
            });
            monopole.setEnabled(courant.getDev().getNbMonopole() > 0);
            consRoute.setEnabled(courant.getDev().getNbConstructiondeRoute() > 0);
            consRoute.addActionListener(event -> {
                courant.getInventaire().getBatiment().replace("ROUTE",  courant.getInventaire().getBatiment().get("ROUTE")+2);
                courant.getDev().supprimer("Construction de route");
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("route", courant.getNbRoute());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", courant.getDev().getNbConstructiondeRoute());
            });
            retour.addActionListener(event -> {
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
            content.add(chevalier);
            content.add(invention);
            content.add(monopole);
            content.add(consRoute);
            content.add(retour);
        }

        public JPanel getContent(){
            return content;
        }
    }

    public class InventionPanel{

        private JPanel content;
        private int count = 2;

        public InventionPanel(){
            content = new JPanel();
            JButton minerai = new JButton(" Minerai ");
            JButton laine = new JButton (" Laine ");
            JButton bois = new JButton (" Bois ");
            JButton ble = new JButton (" Ble ");
            JButton argile = new JButton(" Argile ");
            minerai.addActionListener(event -> {
                this.choixRessrouces("MINERAI");
            });
            laine.addActionListener(event -> {
                this.choixRessrouces("LAINE");
            });
            bois.addActionListener(event -> {
                this.choixRessrouces("BOIS");
            });
            ble.addActionListener(event -> {
                this.choixRessrouces("BLE");
            });
            argile.addActionListener(event -> {
                this.choixRessrouces("ARGILE");
            });
            content.add(minerai);
            content.add(laine);
            content.add(ble);
            content.add(bois);
            content.add(argile);
        }


        public void choixRessrouces(String s){
            if(count == 1){
                courant.getInventaire().getRessource().replace(s,  courant.getInventaire().getRessource().get(s)+1);
                principale.getInformationJoueur().getRessource().setQuantité(s, courant.getInventaire().getRessource().get(s));
                courant.getDev().supprimer("Invention");
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", courant.getDev().getNbInvention());
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            }
            else{
                courant.getInventaire().getRessource().replace(s,  courant.getInventaire().getRessource().get(s)+1);
                principale.getInformationJoueur().getRessource().setQuantité(s, courant.getInventaire().getRessource().get(s));
                count--;
            }
        }
        
        public JPanel getcontent(){
            return content;
        }
    }

    public void setJoueurcourant(Joueur courant){
        this.courant = courant;
    }

    public Joueur getSuivant(Joueur courant, ArrayList<Joueur> listjoueur){
        for(int i = 0 ; i < listjoueur.size() ;i++){
            if(courant.equals(listjoueur.get(i)) && i + 1 < listjoueur.size())
                return listjoueur.get(i+1);
        }
        return listjoueur.get(0);
    }
    
    public Poser getPoser(){
        return boutonposer;
    }

    public JPanel getMain(){
        return main;
    }

    public ChoixActions getChoixActions(){
        return choixActions;
    }
}

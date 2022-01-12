package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import joueur.Joueur;


public class Actions extends JFrame{

    private JPanel main = new JPanel();
    
    private ArrayList<Joueur> listjoueur;

    private boolean creationunique = true;
    private Poser boutonposer;
    private ChoixActions choixActions;

    private Gui principale;

    public Actions(ArrayList<Joueur> list,Gui principale){
        listjoueur = list;
        this.principale = principale;

        main.setLayout(new BorderLayout());

        main.add(new Debut().getContent(),BorderLayout.CENTER);

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
                principale.getInformationJoueur().setDee(" Dée obtenu : " + principale.getJoueurCourant().lancerDees());

                main.removeAll();
                choixActions = new ChoixActions();
                main.add(choixActions.getChoixActionsContent());
                main.revalidate();
            });
            finDeTour.addActionListener(event -> {
                Joueur suivant = this.getSuivant(principale.getJoueurCourant(),principale.getlistjoueur());
                principale.setJoueurSuivant(suivant);
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", suivant.getNbBois());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", suivant.getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", suivant.getNbBle());
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", suivant.getNbMinerai());
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", suivant.getNbLaine());
                principale.getInformationJoueur().getBatiment().setQuantité("route", suivant.getNbRoute());
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", suivant.getNbColonie());
                principale.getInformationJoueur().getBatiment().setQuantité("ville", suivant.getNbVille());
                principale.getInformationJoueur().getDeveloppement().setQuantité("chevalier", suivant.getDev().getNbChevalier());
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", suivant.getDev().getNbInvention());
                principale.getInformationJoueur().getDeveloppement().setQuantité("monopole", suivant.getDev().getNbMonopole());
                principale.getInformationJoueur().getDeveloppement().setQuantité("pdv", suivant.getDev().compterPtsDeVictoire());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", suivant.getDev().getNbConstructiondeRoute());
                principale.getInformationJoueur().getJoueurplateau().setnom(suivant.getNom(),suivant.getCouleur());
                main.removeAll();
                main.add(new Debut().getContent());
                main.revalidate();
            });
        }

        public JPanel getContent(){
            return content;
        }
        public Joueur getSuivant(Joueur courant, ArrayList<Joueur> listjoueur){
            for(int i = 0 ; i < listjoueur.size() ;i++){
                if(principale.getJoueurCourant().equals(listjoueur.get(i)) && i + 1 < listjoueur.size())
                    return listjoueur.get(i+1);
            }
            return listjoueur.get(0);
        }
        
    }

    public class ChoixActions{

        private JPanel content = new JPanel();
        private JButton poser = new JButton(" Poser Batiment ");
        private JButton construire = new JButton(" Construire Batiment ");
        private JButton developpement = new JButton(" Developpement ");
        private JButton findeTour = new JButton(" Fin De Tour ");
        

        public ChoixActions(){
            poser.setEnabled(principale.getJoueurCourant().possedeColonie() || principale.getJoueurCourant().possedeRoute() || principale.getJoueurCourant().possedeVille());
            poser.revalidate();
            construire.setEnabled(principale.getJoueurCourant().peutAcheterColonie() || principale.getJoueurCourant().peutAcheterRoute() || principale.getJoueurCourant().peutAcheterVille());
            developpement.setEnabled(principale.getJoueurCourant().peutCreeCarteDev() || principale.getJoueurCourant().getDev().getStock().size()> 0);
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
            findeTour.addActionListener(event -> {
                Joueur suivant = this.getSuivant(principale.getJoueurCourant(),principale.getlistjoueur());
                principale.setJoueurSuivant(suivant);
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", suivant.getNbBois());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", suivant.getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", suivant.getNbBle());
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", suivant.getNbMinerai());
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", suivant.getNbLaine());
                principale.getInformationJoueur().getBatiment().setQuantité("route", suivant.getNbRoute());
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", suivant.getNbColonie());
                principale.getInformationJoueur().getBatiment().setQuantité("ville", suivant.getNbVille());
                principale.getInformationJoueur().getDeveloppement().setQuantité("chevalier", suivant.getDev().getNbChevalier());
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", suivant.getDev().getNbInvention());
                principale.getInformationJoueur().getDeveloppement().setQuantité("monopole", suivant.getDev().getNbMonopole());
                principale.getInformationJoueur().getDeveloppement().setQuantité("pdv", suivant.getDev().compterPtsDeVictoire());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", suivant.getDev().getNbConstructiondeRoute());
                principale.getInformationJoueur().getJoueurplateau().setnom(suivant.getNom(),suivant.getCouleur());
                main.removeAll();
                main.add(new Debut().getContent());
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

        public Joueur getSuivant(Joueur courant, ArrayList<Joueur> listjoueur){
            for(int i = 0 ; i < listjoueur.size() ;i++){
                if(principale.getJoueurCourant().equals(listjoueur.get(i)) && i + 1 < listjoueur.size())
                    return listjoueur.get(i+1);
            }
            return listjoueur.get(0);
        }
    }

    public class Poser{

        private JPanel content = new JPanel();
        private JButton route = new JButton(" Poser Route ");
        private JButton colonie = new JButton(" Poser Colonie ");
        private JButton ville = new JButton(" Poser Ville ");
        private JButton retour = new JButton(" Retour ");

        public Poser(){
            route.setEnabled(principale.getJoueurCourant().possedeRoute());
            route.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("ROUTE", principale.getJoueurCourant().getInventaire().getBatiment().get("ROUTE")-1);
                colonie.setEnabled(false);
                ville.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("route", principale.getJoueurCourant().getNbRoute());
            });
            colonie.setEnabled(principale.getJoueurCourant().possedeColonie());
            colonie.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("COLONIE", principale.getJoueurCourant().getInventaire().getBatiment().get("COLONIE")-1);
                route.setEnabled(false);
                ville.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", principale.getJoueurCourant().getNbColonie());
            });
            ville.setEnabled(principale.getJoueurCourant().possedeVille());
            ville.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("VILLE", principale.getJoueurCourant().getInventaire().getBatiment().get("VILLE")-1);
                principale.getJoueurCourant().getInventaire().getBatiment().replace("COLONIE", principale.getJoueurCourant().getInventaire().getBatiment().get("COLONIE")+1);
                route.setEnabled(false);
                colonie.setEnabled(false);
                retour.setEnabled(false);
                principale.getInformationJoueur().getBatiment().setQuantité("ville", principale.getJoueurCourant().getNbVille());
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", principale.getJoueurCourant().getNbColonie());
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
            route.setEnabled(principale.getJoueurCourant().peutAcheterRoute());
            content.add(route);
            route.addActionListener(event ->  {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("ROUTE", principale.getJoueurCourant().getInventaire().getBatiment().get("ROUTE")+1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("ARGILE", principale.getJoueurCourant().getInventaire().getRessource().get("ARGILE")-1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("BOIS", principale.getJoueurCourant().getInventaire().getRessource().get("BOIS")-1);
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("route", principale.getJoueurCourant().getNbRoute());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", principale.getJoueurCourant().getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", principale.getJoueurCourant().getNbBois());
            });
            colonie.setEnabled(principale.getJoueurCourant().peutAcheterColonie());
            content.add(colonie);
            colonie.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("COLONIE", principale.getJoueurCourant().getInventaire().getBatiment().get("COLONIE")+1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("ARGILE", principale.getJoueurCourant().getInventaire().getRessource().get("ARGILE")-1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("BOIS", principale.getJoueurCourant().getInventaire().getRessource().get("BOIS")-1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("LAINE", principale.getJoueurCourant().getInventaire().getRessource().get("LAINE")-1);
                principale.getInformationJoueur().getRessource().setQuantité("BLE", principale.getJoueurCourant().getNbBle());
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("colonie", principale.getJoueurCourant().getNbColonie());
                principale.getInformationJoueur().getRessource().setQuantité("ARGILE", principale.getJoueurCourant().getNbArgile());
                principale.getInformationJoueur().getRessource().setQuantité("BOIS", principale.getJoueurCourant().getNbBois());
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", principale.getJoueurCourant().getNbLaine());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", principale.getJoueurCourant().getNbBle());
            });
            ville.setEnabled(principale.getJoueurCourant().peutAcheterVille());
            content.add(ville);
            ville.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("VILLE", principale.getJoueurCourant().getInventaire().getBatiment().get("VILLE")+1);
                principale.getJoueurCourant().getInventaire().getRessource().replace("MINERAI", principale.getJoueurCourant().getInventaire().getRessource().get("MINERAI")-3);
                principale.getJoueurCourant().getInventaire().getRessource().replace("BLE", principale.getJoueurCourant().getInventaire().getRessource().get("BLE")-2);
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("ville", principale.getJoueurCourant().getNbVille());
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", principale.getJoueurCourant().getNbMinerai());
                principale.getInformationJoueur().getRessource().setQuantité("BLE", principale.getJoueurCourant().getNbBle());
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
            utiliser.setEnabled(principale.getJoueurCourant().getDev().getStock().size() >= 0);
            content.add(utiliser);
            utiliser.addActionListener(event -> {
                main.removeAll();
                main.add(new CarteDev().getContent());
                main.revalidate();
            });
            cree.setEnabled(principale.getJoueurCourant().peutCreeCarteDev() && creationunique == true);
            content.add(cree);
            cree.addActionListener(event ->{
                principale.getJoueurCourant().getInventaire().getRessource().replace("MINERAI", principale.getJoueurCourant().getInventaire().getRessource().get("MINERAI")-1);
				principale.getJoueurCourant().getInventaire().getRessource().replace("LAINE", principale.getJoueurCourant().getInventaire().getRessource().get("LAINE")-1);
				principale.getJoueurCourant().getInventaire().getRessource().replace("BLE", principale.getJoueurCourant().getInventaire().getRessource().get("BLE")-1);
				principale.getJoueurCourant().getDev().creationCarteDev(principale.getJoueurCourant().getDev().getCarteDev());
                creationunique = false;
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getRessource().setQuantité("MINERAI", principale.getJoueurCourant().getInventaire().getRessource().get("MINERAI"));
                principale.getInformationJoueur().getRessource().setQuantité("LAINE", principale.getJoueurCourant().getInventaire().getRessource().get("LAINE"));
                principale.getInformationJoueur().getRessource().setQuantité("BLE", principale.getJoueurCourant().getInventaire().getRessource().get("BLE"));
                principale.getInformationJoueur().getDeveloppement().setQuantité("chevalier", principale.getJoueurCourant().getDev().getNbChevalier());
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", principale.getJoueurCourant().getDev().getNbInvention());
                principale.getInformationJoueur().getDeveloppement().setQuantité("monopole", principale.getJoueurCourant().getDev().getNbMonopole());
                principale.getInformationJoueur().getDeveloppement().setQuantité("pdv", principale.getJoueurCourant().getDev().compterPtsDeVictoire());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", principale.getJoueurCourant().getDev().getNbConstructiondeRoute());
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
            JButton pdv = new JButton(" Utiliser Point de Victoire ");
            JButton consRoute = new JButton(" Utiliser Construction De Route ");
            JButton retour = new JButton(" Retour ");

            chevalier.setEnabled(principale.getJoueurCourant().getDev().getNbChevalier() > 0);
            invention.setEnabled(principale.getJoueurCourant().getDev().getNbInvention() > 0);
            invention.addActionListener(event -> {
                main.removeAll();
                main.add(new InventionPanel().getcontent());
                main.revalidate();
            });
            pdv.setEnabled(principale.getJoueurCourant().getDev().compterPtsDeVictoire() > 0);
            pdv.addActionListener(event -> {
                principale.getJoueurCourant().setScore(principale.getJoueurCourant().getScore()+1);
                principale.getInformationJoueur().getJoueurplateau().setpdv(principale.getJoueurCourant().getScore());
                principale.getJoueurCourant().getDev().supprimer("Point de Victoire");
                principale.getInformationJoueur().getDeveloppement().setQuantité("pdv", principale.getJoueurCourant().getDev().compterPtsDeVictoire());
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
            monopole.setEnabled(principale.getJoueurCourant().getDev().getNbMonopole() > 0);
            monopole.addActionListener(event -> {
                main.removeAll();
                main.add(new MonopolePanel().getcontent());
                main.revalidate();
            });
            consRoute.setEnabled(principale.getJoueurCourant().getDev().getNbConstructiondeRoute() > 0);
            consRoute.addActionListener(event -> {
                principale.getJoueurCourant().getInventaire().getBatiment().replace("ROUTE",  principale.getJoueurCourant().getInventaire().getBatiment().get("ROUTE")+2);
                principale.getJoueurCourant().getDev().supprimer("Construction de route");
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
                principale.getInformationJoueur().getBatiment().setQuantité("route", principale.getJoueurCourant().getNbRoute());
                principale.getInformationJoueur().getDeveloppement().setQuantité("construction", principale.getJoueurCourant().getDev().getNbConstructiondeRoute());
            });
            retour.addActionListener(event -> {
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
            content.add(chevalier);
            content.add(invention);
            content.add(monopole);
            content.add(pdv);
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
                principale.getJoueurCourant().getInventaire().getRessource().replace(s,  principale.getJoueurCourant().getInventaire().getRessource().get(s)+1);
                principale.getInformationJoueur().getRessource().setQuantité(s, principale.getJoueurCourant().getInventaire().getRessource().get(s));
                principale.getJoueurCourant().getDev().supprimer("Invention");
                principale.getInformationJoueur().getDeveloppement().setQuantité("invention", principale.getJoueurCourant().getDev().getNbInvention());
                main.removeAll();
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            }
            else{
                principale.getJoueurCourant().getInventaire().getRessource().replace(s,  principale.getJoueurCourant().getInventaire().getRessource().get(s)+1);
                principale.getInformationJoueur().getRessource().setQuantité(s, principale.getJoueurCourant().getInventaire().getRessource().get(s));
                count--;
            }
        }
        
        public JPanel getcontent(){
            return content;
        }
    }

    public class MonopolePanel{

        private JPanel content;
        private String ressource;

        public MonopolePanel(){

            JButton minerai = new JButton(" Minerai ");
            JButton laine = new JButton (" Laine ");
            JButton bois = new JButton (" Bois ");
            JButton ble = new JButton (" Ble ");
            JButton argile = new JButton(" Argile ");
            minerai.addActionListener(event -> {
                ressource = "MINERAI";
                monopole(principale.getlistjoueur(), ressource);
                principale.getJoueurCourant().getDev().supprimer("Monopole");
            });
            laine.addActionListener(event -> {
                ressource = "LAINE";
                monopole(principale.getlistjoueur(), ressource);
                principale.getJoueurCourant().getDev().supprimer("Monopole");
            });
            bois.addActionListener(event -> {
                ressource = "BOIS";
                monopole(principale.getlistjoueur(), ressource);
                principale.getJoueurCourant().getDev().supprimer("Monopole");
            });
            ble.addActionListener(event -> {
                ressource = "BLE";
                monopole(principale.getlistjoueur(), ressource);
                principale.getJoueurCourant().getDev().supprimer("Monopole");
            });
            argile.addActionListener(event -> {
                ressource = "ARGILE";
                monopole(principale.getlistjoueur(), ressource);
                principale.getJoueurCourant().getDev().supprimer("Monopole");
            });
            content.add(minerai);
            content.add(laine);
            content.add(ble);
            content.add(bois);
            content.add(argile);

        }

        public void monopole(ArrayList<Joueur>j , String r1){
            for(int i = 0 ; i < j.size() ; i++){
				if(j.get(i).getNom().equals(principale.getJoueurCourant().getNom())==false){
					if(r1.equals("BOIS")){
						principale.getJoueurCourant().getInventaire().getRessource().replace(r1,principale.getJoueurCourant().getInventaire().getRessource().get(r1)+j.get(i).getNbBois());
						j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbBois());
					}
					
					if(r1.equals("ARGILE")){
						principale.getJoueurCourant().getInventaire().getRessource().replace(r1,principale.getJoueurCourant().getInventaire().getRessource().get(r1)+j.get(i).getNbArgile());
						j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbArgile());
					}
					if(r1.equals("LAINE")){
						principale.getJoueurCourant().getInventaire().getRessource().replace(r1,principale.getJoueurCourant().getInventaire().getRessource().get(r1)+j.get(i).getNbLaine());
						j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbLaine());
					}
					
					if(r1.equals("MINERAI")){
						principale.getJoueurCourant().getInventaire().getRessource().replace(r1,principale.getJoueurCourant().getInventaire().getRessource().get(r1)+j.get(i).getNbMinerai());
						j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbMinerai());
					}
					if(r1.equals("BLE")){
						principale.getJoueurCourant().getInventaire().getRessource().replace(r1,principale.getJoueurCourant().getInventaire().getRessource().get(r1)+j.get(i).getNbBle());
						j.get(i).getInventaire().getRessource().replace(r1,j.get(i).getInventaire().getRessource().get(r1)-j.get(i).getNbBle());
					}
				}
            }
            main.removeAll();
            main.add(new ChoixActions().getChoixActionsContent());
            main.revalidate();
        }

        public JPanel getcontent(){
            return content;
        }
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

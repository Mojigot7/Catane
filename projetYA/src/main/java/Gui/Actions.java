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
    private Debut debut;
    private ArrayList<Joueur> listjoueur;
    private Joueur courant;
    private int tour;
    private JPanel deeconteneur;
    private JPanel suivantconteneur;

    public Actions(ArrayList<Joueur> list){
        courant = list.get(tour);
        listjoueur = list;
        main.setLayout(new BorderLayout());
        debut = new Debut();

        JLabel actions = new JLabel();
        actions.setText("ACTIONS POSSBILES");
        JPanel actionsconteneur = new JPanel();
        actionsconteneur.add(actions);

        JLabel dee = new JLabel();
        dee.setText(" Dée obtenu : "+courant.lancerDees());
        deeconteneur = new JPanel();
        deeconteneur.setVisible(false);
        deeconteneur.add(dee);

        main.add(actionsconteneur,BorderLayout.NORTH);
        main.add(debut.getContent(),BorderLayout.CENTER);
        main.add(deeconteneur,BorderLayout.WEST);

    }

    private class Debut extends JPanel{

        private JPanel content;

        public Debut(){
            content = new JPanel();
            content.setLayout(new FlowLayout());
            JButton lanceeDee = new JButton("Lancee Les Dees");
            JButton finDeTour = new JButton("Fin De Tour");
            content.add(lanceeDee);
            content.add(finDeTour);
            lanceeDee.addActionListener( event -> {
                deeconteneur.setVisible(true);
                main.remove(1);
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });
        }

        public JPanel getContent(){
            return content;
        }
    }

    private class ChoixActions extends JPanel{

        private JPanel content = new JPanel();
        private JButton poser = new JButton(" Poser Batiment ");
        private JButton construire = new JButton(" Construire Batiment ");
        private JButton developpement = new JButton(" Developpement ");
        private JButton findeTour = new JButton(" Fin De Tour ");
        

        public ChoixActions(){
            poser.setEnabled(courant.possedeColonie() || courant.possedeRoute() || courant.possedeVille());
            content.add(poser);
            construire.setEnabled(courant.peutAcheterColonie() || courant.peutAcheterRoute() || courant.peutAcheterVille());
            content.add(construire);
            developpement.setEnabled(courant.peutCreeCarteDev() || courant.getDev().getStock().size()> 0);
            content.add(developpement);
            content.add(findeTour);
            poser.addActionListener(event -> {
                main.remove(2);
                main.add(new Poser().getContent());
                main.revalidate();
            });
            construire.addActionListener(event ->{
                main.remove(2);
                main.add(new Construire().getContent());
                main.revalidate();
            });
            developpement.addActionListener(event ->{
                main.remove(2);
                main.add(new Developpement().getContent());
                main.revalidate();
            });
        }

        public JPanel getChoixActionsContent(){
            return content;
        }
    }

    private class Poser extends JPanel{

        private JPanel content = new JPanel();
        private JButton route = new JButton(" Poser Route ");
        private JButton colonie = new JButton(" Poser Colonie ");
        private JButton ville = new JButton(" Poser Ville ");
        private JButton retour = new JButton(" Retour ");

        public Poser(){
            route.setEnabled(courant.possedeRoute());
            route.addActionListener(event -> {});
            colonie.setEnabled(courant.possedeColonie());
            colonie.addActionListener(event -> {});
            ville.setEnabled(courant.possedeVille());
            ville.addActionListener(event -> {});
            retour.addActionListener(event -> {
                main.remove(2);
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

    private class Construire extends JPanel{

        private JPanel content = new JPanel();
        private JButton route = new JButton(" Cree Route ");
        private JButton colonie = new JButton(" Cree Colonie ");
        private JButton ville = new JButton(" Cree Ville ");
        private JButton retour = new JButton(" Retour ");
        
        public Construire(){
            route.setEnabled(courant.peutAcheterRoute());
            content.add(route);
            colonie.setEnabled(courant.peutAcheterColonie());
            content.add(colonie);
            ville.setEnabled(courant.peutAcheterVille());
            content.add(ville);
            content.add(retour);
            retour.addActionListener(event -> {
                main.remove(1);
                main.add(new ChoixActions().getChoixActionsContent());
                main.revalidate();
            });

        }
        public JPanel getContent(){
            return content;
        }


    }

    private class Developpement extends JPanel{

        private JPanel content = new JPanel();
        private JButton utiliser = new JButton(" Utiliser Carte Dev ");
        private JButton cree = new JButton(" Creer Carte Dev ");
        private JButton retour = new JButton(" Retour ");
        
        public Developpement(){

            content.add(utiliser);
            content.add(cree);
            content.add(retour);
            retour.addActionListener(event -> {
                main.remove(1);
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
}

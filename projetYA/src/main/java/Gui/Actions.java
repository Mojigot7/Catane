package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import joueur.Joueur;


public class Actions extends JFrame{

    private JPanel main = new JPanel();
    private Debut debut;
    private ArrayList<Joueur> listjoueur;
    private Joueur courant;
    private JPanel deeconteneur;
    private JPanel suivantconteneur;

    public Actions(ArrayList<Joueur> list){
        courant = list.get(0);
        listjoueur = list;
        main.setLayout(new BorderLayout());
        debut = new Debut();

        JLabel actions = new JLabel();
        actions.setText("ACTIONS POSSBILES");
        JPanel actionsconteneur = new JPanel();

        JLabel dee = new JLabel();
        dee.setText(courant.lancerDees()+"");
        deeconteneur = new JPanel();
        deeconteneur.setVisible(false);

        JLabel suivant = new JLabel();
        suivant.setText(listjoueur.get(1).getNom()+"");
        suivantconteneur = new JPanel();

        main.add(actionsconteneur,BorderLayout.NORTH);
        main.add(debut.getContent(),BorderLayout.CENTER);
        main.add(deeconteneur,BorderLayout.WEST);
        main.add(suivantconteneur,BorderLayout.EAST);

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
                /*JLabel dee = new JLabel();
                dee.setText(courant.lancerDees()+"");
                main.add(dee,BorderLayout.WEST);
                */
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
        private JButton poser = new JButton("Poser Batiment");
        private JButton construire = new JButton("Construire Batiment");
        private JButton developpement = new JButton("Developpement");
        private JButton findeTour = new JButton("Fin De Tour");
        

        public ChoixActions(){
            content.add(poser);
            content.add(construire);
            content.add(developpement);
            content.add(findeTour);
            poser.addActionListener(event -> {
                main.removeAll();
                main.add(new Poser().getContent());
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
        }

        public JPanel getChoixActionsContent(){
            return content;
        }
    }

    private class Poser extends JPanel{

        private JPanel content = new JPanel();
        private JButton route = new JButton("Route");
        private JButton colonie = new JButton("Colonie");
        private JButton ville = new JButton("Ville");
        private JButton retour = new JButton("Retour");

        public Poser(){
            route.addActionListener(event -> {});
            colonie.addActionListener(event -> {});
            ville.addActionListener(event -> {});
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

    private class Construire extends JPanel{

        private JPanel content = new JPanel();
        private JButton route = new JButton("Route");
        private JButton colonie = new JButton("Colonie");
        private JButton ville = new JButton("Ville");
        private JButton retour = new JButton("Retour");
        
        public Construire(){
            
            content.add(route);
            content.add(colonie);
            content.add(ville);
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

    private class Developpement extends JPanel{

        private JPanel content = new JPanel();
        private JButton utiliser = new JButton("Utiliser");
        private JButton cree = new JButton("Creer");
        private JButton retour = new JButton("Retour");
        
        public Developpement(){

            content.add(utiliser);
            content.add(cree);
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
}

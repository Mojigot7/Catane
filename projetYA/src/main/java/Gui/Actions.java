package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Actions extends JFrame{

    private JPanel main = new JPanel();
    private Debut debut;

    public Actions(){
        main.setLayout(new BorderLayout());
        debut = new Debut();
        main.add(debut.getContent(),BorderLayout.CENTER);

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
                System.out.println("JLabel avec nombres obtenu");
                main.removeAll();
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

    /*
    main.setLayout(new GridLayout(2,1));

        JLabel Tour = new JLabel();

        JPanel temp1 = new JPanel();

        temp1.setLayout(new GridLayout(1,3));
        Tour.setText("Tour");
        temp1.add(Tour);

        JLabel vide1 = new JLabel();
        temp1.add(vide1);

        JLabel suivant = new JLabel();
        suivant.setText("Joueur Suivant : Joueur 2");
        temp1.add(suivant);

        main.add(temp1);

        JPanel temp = new JPanel();

        JButton dee = new JButton("Lancee les dees");
        dee.setSize(200,200);
        dee.addActionListener(null);
        temp.add(dee);

        JButton fin = new JButton("Fin de tour");
        fin.setSize(200,200);
        temp.add(fin);
        fin.addActionListener(null);
        main.add(temp);
*/
}

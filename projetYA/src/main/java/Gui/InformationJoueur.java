package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationJoueur extends JFrame{

    private static final long serialVersionUID = 1L;

    private JPanel content;
    private Joueur j;
    private Ressource ressource;
    private Batiment batiment;
    private Developpement dev;
    private Legende leg;

    public class Joueur{
        private JPanel content;
        private JLabel nom;
        private JLabel pdv;

        public Joueur() {
            content = new JPanel();
            content.setLayout(new GridLayout(2,1));
            nom = new JLabel();
            pdv = new JLabel();

            nom.setText(" Joueur 1");
            content.add(nom);

            pdv.setText(" Point de Victoire : 0");
            content.add(pdv);

        }

        public JPanel getcontent() {
            return this.content;
        }

        public void setpdv(int pdv) {
            this.pdv.setText("Point de Victoire : " + pdv);
        }
    }

    public class Ressource{
private JPanel content;
        private JLabel minerai;
        private JLabel argile;
        private JLabel bois;
        private JLabel ble;
        private JLabel laine;

        public Ressource() {
            content = new JPanel();
            content.setLayout(new GridLayout(5,1));

            minerai = new JLabel();
            minerai.setText("Minerai : 0");
            content.add(minerai);

            argile = new JLabel();
            argile.setText("Argile : 0");
            content.add(argile);

            bois = new JLabel();
            bois.setText("Bois : 0");
            content.add(bois);

            ble = new JLabel();
            ble.setText("Ble : 0");
            content.add(ble);

            laine = new JLabel();
            laine.setText("Laine : 0");
            content.add(laine);

        }

        public JPanel getcontent() {
            return this.content;
        }

        public void setQuantité(String ressource,int quantite) {
            if(ressource.equals("MINERAI")) {
                minerai.setText("Minerai : " + quantite);
            }
            if(ressource.equals("ARGILE")) {
                argile.setText("Argile : " + quantite);
            }
            if(ressource.equals("BOIS")) {
                bois.setText("Bois : " + quantite);
            }
            if(ressource.equals("BLE")) {
                ble.setText("Ble : " + quantite);
            }
            if(ressource.equals("LAINE")) {
                laine.setText("Laine : " + quantite);
            }
            else {
                System.out.println("Erreur setQuantite dans la classe ressource");
            }
        }
    }
private class Batiment{

        private JPanel content;
        private JLabel route;
        private JLabel colonie;
        private JLabel ville;

        public Batiment() {
            content = new JPanel();
            content.setLayout(new GridLayout(3,1));

            route = new JLabel();
            route.setText("Route : 2");
            content.add(route);

            colonie = new JLabel();
            colonie.setText("Colonie : 2");
            content.add(colonie);

            ville = new JLabel();
            ville.setText("Ville : 0");
            content.add(ville);
        }

        public JPanel getcontent() {
            return this.content;
        }

        @SuppressWarnings("unused")
        public void setQuantité(String ressource,int quantite) {
            if(ressource.equals("route")) {
                route.setText("route : " + quantite);
            }
            if(ressource.equals("colonie")) {
                colonie.setText(ressource + " : " + quantite);
            }
            if(ressource.equals("ville")) {
                ville.setText(ressource + " : " + quantite);
            }
            else {
                System.out.println("Erreur setQuantite dans la classe batiment");
            }
        }

    }
private class Developpement{
        private JPanel content;
        private JLabel chevalier;
        private JLabel monopole;
        private JLabel invention;
        private JLabel construction;
        private JLabel pdv;

        public Developpement() {

            content = new JPanel();
            content.setLayout(new GridLayout(5,1));

            chevalier = new JLabel();
            chevalier.setText("Chevalier : 0");
            content.add(chevalier);

            invention = new JLabel();
            invention.setText("Invention : 0");
            content.add(invention);

            monopole = new JLabel();
            monopole.setText("Monopole : 0");
            content.add(monopole);

            pdv = new JLabel();
            pdv.setText("PdV : 0");
            content.add(pdv);

            construction = new JLabel();
            construction.setText("Construction de route : 0");
            content.add(construction);
        }

        public JPanel getcontent() {
            return this.content;
        }

        public void setQuantité(String ressource,int quantite) {
            if(ressource.equals("chevalier")) {
                chevalier.setText(ressource + " : " + quantite);
            }
            if(ressource.equals("invention")) {
                invention.setText(ressource + " : " + quantite);
            }
            if(ressource.equals("monopole")) {
                monopole.setText(ressource + " : " + quantite);
            }
            if(ressource.equals("pdv")) {
                pdv.setText(ressource + " : " + quantite);
            }
            if(ressource.equals("construction")) {
                construction.setText(ressource + " : " + quantite);
            }
            else {
                System.out.println("Erreur setQuantite dans la classe developpment");
            }
        }
    }
public class Legende{
        private JPanel content;
        private JLabel nom;


        public Legende() {
            content = new JPanel();
            content.setLayout(new GridLayout(6,1));

            JLabel legend = new JLabel();
            legend.setText("Legende : ");
            content.add(legend);

            JPanel colline = new JPanel();
            colline.setBackground(new Color(215,100,0));
            nom = new JLabel();
            nom.setText("ARGILE");
            colline.add(nom);
            content.add(colline);


            JPanel champs = new JPanel();
            champs.setBackground(new Color(255,255,0));
            nom = new JLabel();
            nom.setText("BLE");
            champs.add(nom);
            content.add(champs);

            JPanel foret = new JPanel();
            foret.setBackground(new Color(0,172,62));
            nom = new JLabel();
            nom.setText("BOIS");
            foret.add(nom);
            content.add(foret);

            JPanel pre = new JPanel();
            pre.setBackground(new Color(0,215,78));
            nom = new JLabel();
            nom.setText("LAINE");
            pre.add(nom);
            content.add(pre);

            JPanel montagne = new JPanel();
            montagne.setBackground(new Color(167,167,167));
            nom = new JLabel();
            nom.setText("MINERAI");
            montagne.add(nom);
            content.add(montagne);
        }

        public JPanel getcontent() {
            return this.content;
        }

    }

    public InformationJoueur() {
        this.setSize(1000,600);
        content = new JPanel();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        j = new Joueur();
        ressource = new Ressource();
        batiment = new Batiment();
        dev = new Developpement();
        leg = new Legende();
        content.setLayout(new GridLayout(1,6));

        content.add(j.getcontent());
        content.add(ressource.getcontent());
        content.add(batiment.getcontent());
        content.add(dev.getcontent());
        JLabel vide = new JLabel();
        content.add(vide);
        content.add(leg.getcontent());

        this.getContentPane().add(content,BorderLayout.NORTH);
    }

    public Batiment getBatiment() {
        return this.batiment;
    }

    public static void main(String []agrs) {
        InformationJoueur test = new InformationJoueur();
        test.setVisible(true);
        test.getBatiment().setQuantité("route",5);
    }
}
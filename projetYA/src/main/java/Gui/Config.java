package Gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import joueur.*;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Config extends JFrame {

    private JPanel content;
    private ArrayList<Joueur> listjoueur;

    public Config() {

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        content = new JPanel();
        listjoueur = new ArrayList<Joueur>();
        content.setLayout(new BorderLayout());
        JLabel config = new JLabel();
        config.setText("CONFIGURATION");
        JPanel config1 = new JPanel();
        config1.add(config);
        content.add(config1, BorderLayout.NORTH);

        JButton nombredejoueur = new JButton("Choisir le nombre de joueur");

        nombredejoueur.addActionListener(event -> {
            content.remove(1);
            content.add(new NombreJoueur(), BorderLayout.CENTER);
            content.revalidate();
        });
        content.add(nombredejoueur);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(content);
        this.pack();
        this.setSize(400, 200);

    }

    public class NombreJoueur extends JPanel {

        private JButton choix1 = new JButton("3");
        private JButton choix2 = new JButton("4");
        private int nombredejoueurs;

        public NombreJoueur() {
            this.add(choix1);
            this.add(choix2);
            choix1.addActionListener(event -> {
                nombredejoueurs = 3;
                content.remove(1);
                content.add(new ChoixTypeJoueur(nombredejoueurs));
                content.revalidate();
            });
            choix2.addActionListener(event -> {
                nombredejoueurs = 4;
                content.remove(1);
                content.add(new ChoixTypeJoueur(nombredejoueurs));
                content.revalidate();
            });
        }

        public int getNbJoueur() {
            return nombredejoueurs;
        }
    }

    public class ChoixTypeJoueur extends JPanel {

        public ChoixTypeJoueur(int x) {
            this.setLayout(new GridLayout(x, 4));
            JButton choixJ11 = new JButton("IA");
            JButton choixJ12 = new JButton("Humain");
            JTextArea nom1 = new JTextArea("Nom du joueur1");
            JButton confirmButton1 = new JButton("Confirmer");
            nom1.setVisible(false);
            confirmButton1.setVisible(false);
            this.add(choixJ11);
            this.add(choixJ12);
            this.add(nom1);
            this.add(confirmButton1);

            choixJ11.addActionListener(event -> {
                listjoueur.add(new IA("BOT1", Color.BLUE));
                choixJ11.setEnabled(false);
                choixJ12.setEnabled(false);

            });
            choixJ12.addActionListener(event -> {
                choixJ11.setEnabled(false);
                choixJ12.setEnabled(false);
                nom1.setVisible(true);
                confirmButton1.setVisible(true);
            });
            confirmButton1.addActionListener(event -> {
                /*
                 * listjoueur.add(new Humain(nom1.getText(),Color.BLUE));
                 * confirmButton1.setEnabled(false);
                 */
                Humain tempo = new Humain(nom1.getText(), Color.BLUE);
                tempo.getInventaire().getRessource().replace("MINERAI",
                        tempo.getInventaire().getRessource().get("MINERAI") + 50);
                tempo.getInventaire().getRessource().replace("ARGILE",
                        tempo.getInventaire().getRessource().get("ARGILE") + 50);
                tempo.getInventaire().getRessource().replace("LAINE",
                        tempo.getInventaire().getRessource().get("LAINE") + 50);
                tempo.getInventaire().getRessource().replace("BLE",
                        tempo.getInventaire().getRessource().get("BLE") + 50);
                tempo.getInventaire().getRessource().replace("BOIS",
                        tempo.getInventaire().getRessource().get("BOIS") + 50);
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                tempo.CreeCarteDev();
                System.out.println(tempo.getNbMinerai());
                listjoueur.add(tempo);
                confirmButton1.setEnabled(false);
            });

            JButton choixJ21 = new JButton("IA");
            JButton choixJ22 = new JButton("Humain");
            JTextArea nom2 = new JTextArea("Nom du joueur2");
            JButton confirmButton2 = new JButton("Confirmer");
            nom2.setVisible(false);
            confirmButton2.setVisible(false);
            this.add(choixJ21);
            this.add(choixJ22);
            this.add(nom2);
            this.add(confirmButton2);

            choixJ21.addActionListener(event -> {
                listjoueur.add(new IA("BOT2", Color.RED));
                choixJ21.setEnabled(false);
                choixJ22.setEnabled(false);

            });
            choixJ22.addActionListener(event -> {
                choixJ21.setEnabled(false);
                choixJ22.setEnabled(false);
                nom2.setVisible(true);
                confirmButton2.setVisible(true);
            });
            confirmButton2.addActionListener(event -> {
                listjoueur.add(new Humain(nom2.getText(), Color.RED));
                confirmButton2.setEnabled(false);
            });

            JButton choixJ31 = new JButton("IA");
            JButton choixJ32 = new JButton("Humain");
            JTextArea nom3 = new JTextArea("Nom du joueur3");
            JButton confirmButton3 = new JButton("Confirmer");
            nom3.setVisible(false);
            confirmButton3.setVisible(false);
            this.add(choixJ31);
            this.add(choixJ32);
            this.add(nom3);
            this.add(confirmButton3);

            choixJ31.addActionListener(event -> {
                listjoueur.add(new IA("BOT3", Color.GREEN));
                choixJ31.setEnabled(false);
                choixJ32.setEnabled(false);
                if (x == 3 && listjoueur.size() == 3 && choixJ11.isEnabled() == false && choixJ12.isEnabled() == false
                        && choixJ21.isEnabled() == false && choixJ22.isEnabled() == false) {
                    Gui jeu = new Gui(listjoueur, listjoueur.get(0));
                }

            });
            choixJ32.addActionListener(event -> {
                choixJ31.setEnabled(false);
                choixJ32.setEnabled(false);
                nom3.setVisible(true);
                confirmButton3.setVisible(true);
            });
            confirmButton3.addActionListener(event -> {
                listjoueur.add(new Humain(nom3.getText(), Color.GREEN));
                confirmButton3.setEnabled(false);
                if (x == 3 && listjoueur.size() == 3 && choixJ11.isEnabled() == false && choixJ12.isEnabled() == false
                        && choixJ21.isEnabled() == false && choixJ22.isEnabled() == false) {
                    Gui jeu = new Gui(listjoueur, listjoueur.get(0));
                }
            });

            if (x == 4) {
                JButton choixJ41 = new JButton("IA");
                JButton choixJ42 = new JButton("Humain");
                JTextArea nom4 = new JTextArea("Nom du joueur4");
                JButton confirmButton4 = new JButton("Confirmer");
                nom4.setVisible(false);
                confirmButton4.setVisible(false);
                this.add(choixJ41);
                this.add(choixJ42);
                this.add(nom4);
                this.add(confirmButton4);

                choixJ41.addActionListener(event -> {
                    listjoueur.add(new IA("BOT4", Color.YELLOW));
                    choixJ41.setEnabled(false);
                    choixJ42.setEnabled(false);
                    if (x == 4 && listjoueur.size() == 4 && choixJ11.isEnabled() == false
                            && choixJ12.isEnabled() == false && choixJ21.isEnabled() == false
                            && choixJ22.isEnabled() == false && choixJ31.isEnabled() == false
                            && choixJ32.isEnabled() == false) {
                        System.out.println("passe IA4");
                        Gui temp = new Gui(listjoueur, listjoueur.get(0));
                    }
                });
                choixJ42.addActionListener(event -> {
                    choixJ41.setEnabled(false);
                    choixJ42.setEnabled(false);
                    nom4.setVisible(true);
                    confirmButton4.setVisible(true);
                });
                confirmButton4.addActionListener(event -> {
                    listjoueur.add(new Humain(nom4.getText(), Color.YELLOW));
                    confirmButton4.setEnabled(false);
                    if (x == 4 && listjoueur.size() == 4 && choixJ11.isEnabled() == false
                            && choixJ12.isEnabled() == false && choixJ21.isEnabled() == false
                            && choixJ22.isEnabled() == false && choixJ31.isEnabled() == false
                            && choixJ32.isEnabled() == false) {
                        System.out.println("passe confirm 4");
                        Gui temp = new Gui(listjoueur, listjoueur.get(0));
                    }
                });
            }
        }
    }

    public static void main(String args[]) {
        Config temp = new Config();
        temp.setVisible(true);
    }
}

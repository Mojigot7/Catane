package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import plateau.*;

public class Gui extends JFrame implements MouseListener {
    private InformationJoueur top;
    private JPanel p;
    private Plateau plateau;

    public Gui() {
        plateau = new Plateau();
        setTitle("Jeu");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,600);
        this.setLocationRelativeTo(null);
        top = new InformationJoueur();
        


        this.getContentPane().add(top.getContentPane(),BorderLayout.NORTH);
        p = new JPanel();

        GridLayout size = new GridLayout(9,11);
        p.setLayout(size);
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 11 ; j++) {
                JPanel temp = new JPanel();
                JLabel temp2 = new JLabel(BorderLayout.CENTER);
                
                if(plateau.getPlateau()[i][j] == null){
                    temp.setBackground(new Color(0,0,0));
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Colline")){
                    temp.setBackground(new Color(215,100,0));
                    temp2.setText("Colline " + plateau.getPlateau()[i][j].getNumero());                
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Champs")){
                    temp.setBackground(new Color(255,255,0));
                    temp2.setText("Champs " + plateau.getPlateau()[i][j].getNumero());
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Foret")){
                    temp.setBackground(new Color(0,172,62));
                    temp2.setText("Foret " + plateau.getPlateau()[i][j].getNumero());
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Pre")){
                    temp.setBackground(new Color(0,215,78));
                    temp2.setText("Pre " + plateau.getPlateau()[i][j].getNumero());
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Montagne")){
                    temp.setBackground(new Color(167,167,167));
                    temp2.setText("Montagne " + plateau.getPlateau()[i][j].getNumero());
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Port")){
                    temp.setBackground(new Color(0,0,225));
                    temp2.setText("Port");
                    temp.addMouseListener(this);
                    temp.add(temp2);
                }
                else if(plateau.getPlateau()[i][j].getClass().getName().equals("tuiles.Desert")){
                    temp.setBackground(new Color(255,255,225));
                    temp2.setText("Desert 7");
                    temp.addMouseListener(this);
                    temp.add(temp2);
                }
                else{
                    temp.setBackground(new Color(255,127,0));
                    temp.addMouseListener(this);
                }
                p.add(temp);
            
            }
        }

        this.getContentPane().add(p,BorderLayout.CENTER);

        JPanel action = new JPanel();
        action.setLayout(new GridLayout(2,1));
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

        action.add(temp1);

        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout());

        JButton dee = new JButton("Lancee les dees");
        dee.setSize(200,200);
        dee.addActionListener(null);
        temp.add(dee);

        JButton fin = new JButton("Fin de tour");
        fin.setSize(200,200);
        temp.add(fin);
        fin.addActionListener(null);
        action.add(temp);
        this.getContentPane().add(action,BorderLayout.SOUTH);

    }

    public static void main(String []agrs) {
        Gui test = new Gui();
        test.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
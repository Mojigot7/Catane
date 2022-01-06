package Gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Actions extends JFrame{

    private JPanel content;

    public Actions(){
        content = new JPanel();
        content.setLayout(new GridLayout(2,1));

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

        content.add(temp1);

        JPanel temp = new JPanel();

        JButton dee = new JButton("Lancee les dees");
        dee.setSize(200,200);
        dee.addActionListener(null);
        temp.add(dee);

        JButton fin = new JButton("Fin de tour");
        fin.setSize(200,200);
        temp.add(fin);
        fin.addActionListener(null);
        content.add(temp);

    }

    public JPanel getContent(){
        return content;
    }
}

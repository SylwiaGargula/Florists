/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwiaciarnia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Kubuniu
 */
public class Dodaj_Rosline extends JFrame implements ActionListener{
     JTextField Nazwa,Cena;
    JLabel lNazwa,lCena;
    JButton Ok;
    BazaDanych baza;
    
    
    Dodaj_Rosline(BazaDanych Baza) {
          try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo4.png")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
        baza=Baza;
        lNazwa=new JLabel("Nazwa Rosliny");
       lNazwa.setBounds(300,275,100,20);
       add(lNazwa);
       
        Nazwa=new JTextField();
        Nazwa.setBounds(450,275,100,20);
        add(Nazwa);
        
       lCena=new JLabel("Cena za sztuke");
       lCena.setBounds(300,350,100,20);
       add(lCena);
       
        Cena=new JTextField();
        Cena.setBounds(450,350,100,20);
        add(Cena);
        
        
      
                
        
        
    Ok=new JButton("Zaakceptuj");
    Ok.setBounds(420,450,100,20);
    add(Ok);
    Ok.addActionListener(this);
        setSize(600,600);
        setLayout(null);
        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        
        String aa=Nazwa.getText();
        String bb=Cena.getText();
       
        
        try {
            baza.RejestrujRosline(aa,bb);
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    dispose();    
    }
    
}

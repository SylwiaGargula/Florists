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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Dodaj_Dostawe extends JFrame implements ActionListener {
    
    JTextField Indeks,Ilosc;
    JLabel lIndeks,lIlosc,lHurtownia,lKwiat;
    JComboBox hurtownia,kwiat;
    ArrayList<String> Hurtownie,Kwiat;
    JButton Ok;
    BazaDanych baza;
    Dodaj_Dostawe(BazaDanych Baza)
    {
          try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo1.jpg")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
        lIndeks=new JLabel("Indeks dostawy");
        lIndeks.setBounds(100, 100, 100, 20);
        add(lIndeks);
        
        baza=Baza;
        Indeks=new JTextField();
        Indeks.setBounds(250,100,100,20);
        add(Indeks);
        
       lIlosc=new JLabel("Podaj ilość");
       lIlosc.setBounds(100,200,100,20);
       add(lIlosc);
       
        Ilosc=new JTextField();
        Ilosc.setBounds(250,200,100,20);
        add(Ilosc);
       
        try {
            Hurtownie=Baza.WybierzHurtownie();
            Kwiat=Baza.WybierzKwiat();
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lHurtownia=new JLabel("Wybierz hurtownię");
       lHurtownia.setBounds(100,300,120,20);
       add(lHurtownia);
        
        hurtownia=new JComboBox(Hurtownie.toArray());
        hurtownia.setBounds(250, 300, 100, 20);
        add(hurtownia);
        
        lKwiat=new JLabel("Wybierz roślinę");
        lKwiat.setBounds(100, 400, 120, 20);
        add(lKwiat);
        
        kwiat=new JComboBox(Kwiat.toArray());
        kwiat.setBounds(250, 400, 100, 20);
        add(kwiat);
        
        setSize(600,600);
        setLayout(null);
        setVisible(true);
        
    Ok=new JButton("Zaakceptuj");
    Ok.setBounds(420,450,100,20);
    add(Ok);
    Ok.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String aa=Indeks.getText();
        int b=hurtownia.getSelectedIndex()+1;
        String bb=Integer.toString(b);
        int c=kwiat.getSelectedIndex()+1;
        String cc=Integer.toString(c);
        String dd=Ilosc.getText();
        try {
            baza.RejestrujDostawe(dd,bb,cc,aa);
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          dispose();    
    }
    
    
    
}

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

/**
 *
 * @author Kubuniu
 */
public class Dodaj_Klienta extends JFrame implements ActionListener {
   
    
    JTextField Imie,Nazwisko,Miejscowosc,Adres,Telefon;
    JLabel lImie,lNazwisko,lMiejscowosc,lAdres,lTelefon;
  
    JButton Ok;
    BazaDanych baza;
    
    
    Dodaj_Klienta(BazaDanych Baza)
    {
          try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo3.jpg")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
      lImie=new JLabel("Imie");
        lImie.setBounds(300, 200, 100, 20);
        add(lImie);
        
        baza=Baza;
        Imie=new JTextField();
        Imie.setBounds(450,200,100,20);
        add(Imie);
        
       lNazwisko=new JLabel("Nazwisko");
       lNazwisko.setBounds(300,275,100,20);
       add(lNazwisko);
       
        Nazwisko=new JTextField();
        Nazwisko.setBounds(450,275,100,20);
        add(Nazwisko);
        
       lMiejscowosc=new JLabel("Miejscowosc");
       lMiejscowosc.setBounds(300,350,100,20);
       add(lMiejscowosc);
       
        Miejscowosc=new JTextField();
        Miejscowosc.setBounds(450,350,100,20);
        add(Miejscowosc);
        
        
       lAdres=new JLabel("Adres");
       lAdres.setBounds(300,425,100,20);
       add(lAdres);
       
        Adres=new JTextField();
        Adres.setBounds(450,425,100,20);
        add(Adres);
        
          
       lTelefon=new JLabel("Telefon");
      lTelefon.setBounds(300,475,120,20);
       add(lTelefon);
       
        Telefon=new JTextField();
        Telefon.setBounds(450,475,100,20);
        add(Telefon);
       
  
        
    Ok=new JButton("Zaakceptuj");
    Ok.setBounds(420,525,100,20);
    add(Ok);
    Ok.addActionListener(this);
        setSize(600,600);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String aa=Imie.getText();
        String bb=Nazwisko.getText();
        String cc=Miejscowosc.getText();
       String dd=Adres.getText();
       String ee=Telefon.getText();
        
        try {
            baza.RejestrujKlienta(aa,bb,cc,dd,ee);
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    dispose();    
    }
    
    
    
}

    


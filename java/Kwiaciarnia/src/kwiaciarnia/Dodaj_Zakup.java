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


public class Dodaj_Zakup extends JFrame implements ActionListener {
    
    JTextField Indeks,Ilosc;
    JLabel lIndeks,lIlosc,lPracownik,lKlienci,lKwiat,lSposobZ,lSposobD;
    JComboBox pracownicy,klienci,kwiaty,sposob_zakupu,sposob_dostawy;
    ArrayList<String> Pracownicy,Klienci,Kwiaty,Sposob_zakupu,Sposob_dostawy;
    JButton Ok;
    BazaDanych baza;
    Dodaj_Zakup(BazaDanych Baza)
    {
          try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo5.png")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
        lIndeks=new JLabel("Indeks Zakupu");
        lIndeks.setBounds(300, 275, 100, 20);
        add(lIndeks);
        
        baza=Baza;
        Indeks=new JTextField();
        Indeks.setBounds(450,275,100,20);
        add(Indeks);
        
       lIlosc=new JLabel("Podaj ilość");
       lIlosc.setBounds(300,325,100,20);
       add(lIlosc);
       
        Ilosc=new JTextField();
        Ilosc.setBounds(450,325,100,20);
        add(Ilosc);
       
        try {
            Pracownicy=Baza.WybierzPracownikow();
            Klienci=Baza.WybierzKlientow();
            Kwiaty=Baza.WybierzKwiat();
            Sposob_zakupu=Baza.WybierzSposobZakupu();
            Sposob_dostawy=Baza.WybierzSposobDostawy();
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lPracownik=new JLabel("Wybierz Pracownika");
       lPracownik.setBounds(300,375,120,20);
       add(lPracownik);
        
        pracownicy=new JComboBox(Pracownicy.toArray());
        pracownicy.setBounds(450, 375, 100, 20);
        add(pracownicy);
        
        lKlienci=new JLabel("Wybierz klienta");
        lKlienci.setBounds(300, 425, 120, 20);
        add(lKlienci);
        
        klienci=new JComboBox(Klienci.toArray());
        klienci.setBounds(450, 425, 100, 20);
        add(klienci);
        
         lSposobZ=new JLabel("Wybierz Sposob Zakupu");
      lSposobZ.setBounds(300,525,120,20);
       add(lSposobZ);
        
        sposob_zakupu=new JComboBox(Sposob_zakupu.toArray());
       sposob_zakupu.setBounds(450, 525, 100, 20);
        add(sposob_zakupu);
        
        lSposobD=new JLabel("Wybierz Sposob Dostawy");
        lSposobD.setBounds(300, 575, 120, 20);
        add(lSposobD);
        
        sposob_dostawy=new JComboBox(Sposob_dostawy.toArray());
        sposob_dostawy.setBounds(450, 575, 100, 20);
        add(sposob_dostawy);
        
        
        
        lKwiat=new JLabel("Wybierz roślinę");
        lKwiat.setBounds(300, 475, 120, 20);
        add(lKwiat);
        
        kwiaty=new JComboBox(Kwiaty.toArray());
        kwiaty.setBounds(450, 475, 100, 20);
        add(kwiaty);
        
        setSize(600,700);
        setLayout(null);
        setVisible(true);
        
    Ok=new JButton("Zaakceptuj");
    Ok.setBounds(420,625,100,20);
    add(Ok);
    Ok.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String aa=Indeks.getText();
        int b=pracownicy.getSelectedIndex()+1;
        String bb=Integer.toString(b);
        int c=klienci.getSelectedIndex()+1;
        String cc=Integer.toString(c);
        int f=kwiaty.getSelectedIndex()+1;
        String ff=Integer.toString(f);
        int g=sposob_zakupu.getSelectedIndex()+1;
        String gg=Integer.toString(g);
        int h=sposob_dostawy.getSelectedIndex()+1;
        String hh=Integer.toString(h);
        String dd=Ilosc.getText();
        try {
            baza.RejestrujZakup(dd,bb,cc,hh,gg,ff,aa);
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          dispose();    
    }
    
    
    
}

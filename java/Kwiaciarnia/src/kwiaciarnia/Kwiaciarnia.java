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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Kwiaciarnia extends JFrame implements ActionListener{
BazaDanych Baza;
JButton Transakcja,NowyPracownik,NowaHurtownia,NowaDostawa,NowyKlient,NowaRoslina;
JButton ZakupyWyswietl,Pracownicy,Hurtownie,Dostawy,Klienci,Rosliny;

    ImageIcon obrazek;
public Kwiaciarnia()
{
    Baza=new BazaDanych();
    
    setLocation(300,200);
        setSize(876,504);
        setResizable(false);
        setLayout(null);
    try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo.jpg")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
   try {
            obrazek=  new ImageIcon(ImageIO.read(new File("transakcja.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Transakcja = new JButton(obrazek);
        Transakcja.setBounds(550, 25, 100, 45);
        add(Transakcja);
        Transakcja.addActionListener(this);



        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("pracownik.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NowyPracownik = new JButton(obrazek);
        NowyPracownik.setBounds(550, 75, 100, 45);
        add(NowyPracownik);
        NowyPracownik.addActionListener(this);


        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("hurtownia.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NowaHurtownia = new JButton(obrazek);
        NowaHurtownia.setBounds(550, 125, 100, 45);
        add(NowaHurtownia);
        NowaHurtownia.addActionListener(this);


        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("dostawa_ludzik.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NowaDostawa = new JButton(obrazek);
        NowaDostawa.setBounds(550, 175, 100, 45);
        add(NowaDostawa);
        NowaDostawa.addActionListener(this);



        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("nowy_klient.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NowyKlient = new JButton(obrazek);
        NowyKlient.setBounds(550, 225, 100, 45);
        add(NowyKlient);
        NowyKlient.addActionListener(this);

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("kwiat.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        NowaRoslina = new JButton(obrazek);
        NowaRoslina.setBounds(550, 275, 100, 45);
        add(NowaRoslina);
        NowaRoslina.addActionListener(this);



        //wyswietlanie

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("zakupy.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ZakupyWyswietl = new JButton(obrazek);
        ZakupyWyswietl.setBounds(700, 25, 100, 45);
        add(ZakupyWyswietl);
        ZakupyWyswietl.addActionListener(this);


        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("pracownicy.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pracownicy = new JButton(obrazek);
        Pracownicy.setBounds(700, 75, 100, 45);
        add(Pracownicy);
        Pracownicy.addActionListener(this);

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("hurtownie.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Hurtownie = new JButton(obrazek);
        Hurtownie.setBounds(700, 125, 100, 45);
        add(Hurtownie);
        Hurtownie.addActionListener(this);

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("dostawy.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dostawy = new JButton(obrazek);
        Dostawy.setBounds(700, 175, 100, 45);
        add(Dostawy);
        Dostawy.addActionListener(this);

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("klienci.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Klienci = new JButton(obrazek);
        Klienci.setBounds(700, 225, 100, 45);
        add(Klienci);
        Klienci.addActionListener(this);

        try {
            obrazek=  new ImageIcon(ImageIO.read(new File("rosliny.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rosliny = new JButton(obrazek);
        Rosliny.setBounds(700, 275, 100, 45);
        add(Rosliny);
        Rosliny.addActionListener(this);
    }  
    
  
        
    public static void main(String[] args) {
        Kwiaciarnia app=new Kwiaciarnia();
        app.setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        Object źródło=e.getSource();
        if(źródło==Transakcja)
        {
    Dodaj_Zakup nowy=new Dodaj_Zakup(Baza);
            
        }

        else if(źródło==NowyPracownik)
        {
         Dodaj_Pracownika nowy=new Dodaj_Pracownika(Baza);
        }

        else if(źródło==NowaHurtownia)
        {

            Dodaj_Hurtownie nowy=new Dodaj_Hurtownie(Baza);
        }

        else if(źródło==NowaDostawa)
        {

        Dodaj_Dostawe Dodaj_Dostawa=new Dodaj_Dostawe(Baza);
        
        }

        else if(źródło==NowyKlient)
        {
    Dodaj_Klienta Dodaj=new Dodaj_Klienta(Baza);

        }
        else if(źródło==NowaRoslina)
        {
         Dodaj_Rosline Dodaj=new Dodaj_Rosline(Baza);
        }

        else if(źródło==ZakupyWyswietl)
        {
        Raport_Zakupy nowy=new Raport_Zakupy(Baza);

        }

        else if(źródło==Pracownicy)
        {
            Raport_Pracownicy nowy=new Raport_Pracownicy(Baza);

        }

        else if(źródło==Hurtownie)
        {
            Raport_Hurtownie nowy=new Raport_Hurtownie(Baza);
        }

        else if(źródło==Dostawy)
        {
         Dostawa dost=new Dostawa(new Kwiaciarnia(),Baza);

        }

        else if(źródło==Klienci)
        {
        
            Raport_Klient nowy=new Raport_Klient(Baza);

        }
        else if(źródło==Rosliny)
        {

        Raport_Kwiat nowy=new Raport_Kwiat(Baza);
        }
    }
}

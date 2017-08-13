
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
public class Dodaj_Hurtownie extends JFrame implements ActionListener {
    
    JTextField Imie,Nazwisko,Miejscowosc,Adres;
    JLabel lImie,lNazwisko,lMiejscowosc,lAdres,lStanowisko;
    JComboBox cbStanowisko;
    ArrayList<String> Stanowisko;
    JButton Ok;
    BazaDanych baza;
    
    
    Dodaj_Hurtownie(BazaDanych Baza)
    {
          try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("tlo2.jpg")))));
    } catch (IOException ex) {
        Logger.getLogger(Kwiaciarnia.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
        lImie=new JLabel("Nazwa Hurtowni");
        lImie.setBounds(300, 200, 100, 20);
        add(lImie);
        
        baza=Baza;
        Imie=new JTextField();
        Imie.setBounds(450,200,100,20);
        add(Imie);
        
       lNazwisko=new JLabel("Miejscowosc");
       lNazwisko.setBounds(300,275,100,20);
       add(lNazwisko);
       
        Nazwisko=new JTextField();
        Nazwisko.setBounds(450,275,100,20);
        add(Nazwisko);
        
       lMiejscowosc=new JLabel("Adres");
       lMiejscowosc.setBounds(300,350,100,20);
       add(lMiejscowosc);
       
        Miejscowosc=new JTextField();
        Miejscowosc.setBounds(450,350,100,20);
        add(Miejscowosc);
        
        
      
                
        
        
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
        
        String aa=Imie.getText();
        String bb=Nazwisko.getText();
        String cc=Miejscowosc.getText();
       
        
        try {
            baza.RejestrujHurtownie(aa,bb,cc);
        } catch (SQLException ex) {
            Logger.getLogger(Dodaj_Dostawe.class.getName()).log(Level.SEVERE, null, ex);
        }
         dispose();    
        
    }
    
    
    
}



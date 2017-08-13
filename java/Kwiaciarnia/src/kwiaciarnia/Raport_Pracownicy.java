package kwiaciarnia;

import java.awt.BorderLayout;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Kubuniu
 */
class Raport_Pracownicy extends JFrame{

    
    
    Raport_Pracownicy(BazaDanych Baza)
    {
        
        
       LinkedList<Pracownik> dostawy= Baza.WybierzPracownika();
        
        
        setTitle("Wykaz pracownikow Kwiaciarni");
        setSize(1000, 50*dostawy.size());
        setVisible(true);
         Object rowData[][]=new Object[dostawy.size()][7];
         for(int i=0;i<dostawy.size();i++)
         {
             rowData[i][0]=dostawy.get(i).indeks;
             rowData[i][1]=dostawy.get(i).imie;
             rowData[i][2]=dostawy.get(i).nazwisko;
             rowData[i][3]=dostawy.get(i).miejscowosc;
             rowData[i][4]=dostawy.get(i).adres;
             rowData[i][5]=dostawy.get(i).stanowisko;
             rowData[i][6]=dostawy.get(i).placa;
            
             
         }
    Object columnNames[] = { "Indeks","Imie", "Nazwisko", "Miejscowosc","Adres","Stanowisko","Placa"};
    JTable table = new JTable(rowData, columnNames);
     JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane,BorderLayout.CENTER);
    

    
    
    }
}

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
public class Raport_Kwiat extends JFrame{
    
    Raport_Kwiat(BazaDanych Baza)
    {
         LinkedList<Kwiat> dostawy= Baza.WybierzKwiaty();
         LinkedList<Magazyn> zakupy=Baza.WybierzMagazynZ();
         LinkedList<Magazyn> dostawy1=Baza.WybierzMagazynD();
         
         for(int i=0;i<zakupy.size();i++)
         {
             for(int j=0;j<dostawy.size();j++)
             {
                 if(zakupy.get(i).ID.equals(dostawy.get(j).Indeks))
                 {
                     dostawy.get(j).ilosc-=zakupy.get(i).Ilosc;
                     
                 }
             }
         }
         
           for(int i=0;i<dostawy1.size();i++)
         {
             for(int j=0;j<dostawy.size();j++)
             {
                 if(dostawy1.get(i).ID.equals(dostawy.get(j).Indeks))
                 {
                     dostawy.get(j).ilosc+=dostawy1.get(i).Ilosc;
                     
                 }
             }
         }
         
           for(int i=0;i<dostawy.size();i++)
           {
               dostawy.get(i).wartosc= dostawy.get(i).ilosc* dostawy.get(i).cena;
           }
         
         
         
         
        
        setTitle("Wykaz dostawcow Kwiaciarni");
        setSize(1000, 50*dostawy.size());
        setVisible(true);
         Object rowData[][]=new Object[dostawy.size()][5];
         for(int i=0;i<dostawy.size();i++)
         {
             rowData[i][0]=dostawy.get(i).Indeks;
             rowData[i][1]=dostawy.get(i).Nazwa;
             rowData[i][2]=dostawy.get(i).cena;
             rowData[i][3]=dostawy.get(i).ilosc;
             rowData[i][4]=dostawy.get(i).wartosc;
            
             
            
             
         }
    Object columnNames[] = { "Indeks","Nazwa","Cena","Ilosc","Wartosc"};
    JTable table = new JTable(rowData, columnNames);
     JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane,BorderLayout.CENTER);
    

    }
}

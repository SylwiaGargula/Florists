/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Raport_Zakupy extends JFrame{
    
    Raport_Zakupy(BazaDanych Baza)
    {
         LinkedList<Zakup> dostawy= Baza.WybierzZakupy();
        for(int i=0;i<dostawy.size();i++)
        {
            dostawy.get(i).wartosc= dostawy.get(i).ilosc* dostawy.get(i).cena;
        }
        
        setTitle("Wykaz dostawcow Kwiaciarni");
        setSize(1000, 50*dostawy.size());
        setVisible(true);
         Object rowData[][]=new Object[dostawy.size()][12];
         for(int i=0;i<dostawy.size();i++)
         {
             
             String Indeks,Id_zakupu,ImieP,NazwiskoP,ImieK,NazwiskoK,sZakupu,sDostawy,Nazwa;
    int cena,ilosc,wartosc;
             rowData[i][0]=dostawy.get(i).Indeks;
             rowData[i][1]=dostawy.get(i).Id_zakupu;
             rowData[i][2]=dostawy.get(i).ImieP;
             rowData[i][3]=dostawy.get(i).NazwiskoP;
             rowData[i][4]=dostawy.get(i).ImieK;
             rowData[i][5]=dostawy.get(i).NazwiskoK;
             rowData[i][6]=dostawy.get(i).sZakupu;
             rowData[i][7]=dostawy.get(i).sDostawy;
             rowData[i][8]=dostawy.get(i).Nazwa;
             rowData[i][9]=dostawy.get(i).cena;
             rowData[i][10]=dostawy.get(i).ilosc;
             rowData[i][11]=dostawy.get(i).wartosc;
             
            
             
            
             
         }
    Object columnNames[] = { "Indeks","Id Zakupu","Imie Pracownika","Nazwisko Pracownika","Imie Klienta","Nazwisko Klienta","Sposob Zakupu","Sposob Dostawy","Nazwa Kwiatu","Cena","Ilosc","Wartosc"};
    JTable table = new JTable(rowData, columnNames);
     JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane,BorderLayout.CENTER);
    

    }
}

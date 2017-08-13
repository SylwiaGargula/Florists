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
class Dostawa extends JFrame{
JFrame owner1;
    
    
    Dostawa(JFrame owner, BazaDanych Baza)
    {
        
        owner1=owner;
       LinkedList<Dostawy> dostawy= Baza.WybierzDostawy();
        
        
        setTitle("Wykaz dostaw w Kwiaciarni");
        setSize(1000, 50*dostawy.size());
        setVisible(true);
         Object rowData[][]=new Object[dostawy.size()][7];
         for(int i=0;i<dostawy.size();i++)
         {
             rowData[i][0]=dostawy.get(i).Indeks;
             rowData[i][1]=dostawy.get(i).Id_Dostawy;
             rowData[i][2]=dostawy.get(i).Nazwa_hurtowni;
             rowData[i][3]=dostawy.get(i).Nazwa_kwiatu;
             rowData[i][4]=dostawy.get(i).Cena_jednostkowa;
             rowData[i][5]=dostawy.get(i).Ilosc;
             rowData[i][6]=dostawy.get(i).Koszty;
             
         }
    Object columnNames[] = { "Indeks", "Id Dostawy", "Nazwa Hurtowni","Nazwa Kwiatu","Cena Jednostkowa","Ilosc","Koszt"};
    JTable table = new JTable(rowData, columnNames);
     JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane,BorderLayout.CENTER);
    

    
    
    }
}

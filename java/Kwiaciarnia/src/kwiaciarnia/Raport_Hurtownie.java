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
public class Raport_Hurtownie extends JFrame{
    
    Raport_Hurtownie(BazaDanych Baza)
    {
         LinkedList<Hurtownia> dostawy= Baza.WybierzHurtownia();
        
        
        setTitle("Wykaz dostawcow Kwiaciarni");
        setSize(1000, 100*dostawy.size());
        setVisible(true);
         Object rowData[][]=new Object[dostawy.size()][4];
         for(int i=0;i<dostawy.size();i++)
         {
             rowData[i][0]=dostawy.get(i).indeks;
             rowData[i][1]=dostawy.get(i).nazwa;
             rowData[i][2]=dostawy.get(i).miejscowosc;
             rowData[i][3]=dostawy.get(i).ulica;
            
             
            
             
         }
    Object columnNames[] = { "Indeks","Nazwa","Miejscowosc","Ulica"};
    JTable table = new JTable(rowData, columnNames);
     JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane,BorderLayout.CENTER);
    

    }
}

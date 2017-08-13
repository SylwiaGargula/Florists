/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwiaciarnia;

/**
 *
 * @author Kubuniu
 */
public class Dostawy {
    
    public String Indeks,Id_Dostawy,Nazwa_hurtowni,Nazwa_kwiatu,Cena_jednostkowa,Ilosc,Koszty;
    
    public Dostawy()
    {
        Indeks="";
        Id_Dostawy="";
        Nazwa_hurtowni="";
        Nazwa_kwiatu="";
        Cena_jednostkowa="";
        Ilosc="";
        Koszty="";
    }

   

    Dostawy(String aIndeks, String aId_Dostawy, String aNazwa_hurtowni, String aNazwa_kwiatu, String aCena_jednostkowa, String aIlosc, String aKoszty)
    {
     Indeks=aIndeks;
        Id_Dostawy=aId_Dostawy;
        Nazwa_hurtowni=aNazwa_hurtowni;
        Nazwa_kwiatu=aNazwa_kwiatu;
        Cena_jednostkowa=aCena_jednostkowa;
        Ilosc=aIlosc;
        Koszty=aKoszty;
    }
    
}

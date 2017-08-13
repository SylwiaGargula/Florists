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
public class Klient {
    String imie,nazwisko,miejscowosc,adres,indeks,telefon;
    
    
    Klient()
    {
        imie="";
        nazwisko="";
        miejscowosc="";
        adres="";
        indeks="";
        telefon="";
    }
    
     Klient(String g,String a,String b,String c,String d,String e)
    {
        imie=a;
        nazwisko=b;
        miejscowosc=c;
        adres=d;
        telefon=e;
        indeks=g;
    }
}

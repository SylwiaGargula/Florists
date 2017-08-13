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
public class Pracownik {
    String imie,nazwisko,miejscowosc,adres,stanowisko,placa,indeks;
    
    Pracownik()
    {
        imie="";
        nazwisko="";
        miejscowosc="";
        adres="";
        stanowisko="";
        placa="";
        indeks="";
    }
    
     Pracownik(String a,String b,String c,String d,String e,String f,String g)
    {
        imie=a;
        nazwisko=b;
        miejscowosc=c;
        adres=d;
        stanowisko=e;
        placa=f;
        indeks=g;
    }
}

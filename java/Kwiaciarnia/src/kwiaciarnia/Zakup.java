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
public class Zakup {
    String Indeks,Id_zakupu,ImieP,NazwiskoP,ImieK,NazwiskoK,sZakupu,sDostawy,Nazwa;
    int cena,ilosc,wartosc;
    
    Zakup(String a,String b,String c,String d,String e,String f,String g,String h,String i,int j,int k)
    {
        Indeks=a;
        Id_zakupu=b;
        ImieP=c;
        NazwiskoP=d;
        ImieK=e;
        NazwiskoK=f;
        sZakupu=g;
        sDostawy=h;
        Nazwa=i;
        cena=j;
        ilosc=k;
        
    }
    
    
}

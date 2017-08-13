/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwiaciarnia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kubuniu
 */
public class BazaDanych{
    private Connection con = null;
    private Statement stat = null;
    BazaDanych(){
        connectDatabase();
    }

    public void connectDatabase(){
        try{
            String host = "jdbc:mysql://localhost:3306/kwiaciarnia";
            String user = "root";
            String passwd = "madafaka1";
            con = DriverManager.getConnection( host, user, passwd );
            stat = con.createStatement();
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage()+" nie mozna sie polaczyc z baza danych");
        }
    }
    public LinkedList<Dostawy> WybierzDostawy() {
        LinkedList<Dostawy> dostawy = new LinkedList<Dostawy>();
        try {
            ResultSet result = stat.executeQuery("SELECT a.Indeks,a.Id_Dostawy,c.Nazwa_hurtowni,b.Nazwa_kwiatu,b.Cena_jednostkowa,a.Ilosc,b.Cena_jednostkowa*a.Ilosc AS Koszt FROM kwiaciarnia.dostawa AS a LEFT JOIN kwiaciarnia.kwiat AS b on a.Id_Rosliny=b.Id_Rosliny LEFT JOIN kwiaciarnia.hurtownia AS c on a.Id_Hurtowni=c.Id_Hurtowni;");
            String Indeks,Id_Dostawy,Nazwa_hurtowni,Nazwa_kwiatu,Cena_jednostkowa,Ilosc,Koszty;
            while(result.next()) {
                Indeks = result.getString("Indeks");
                Id_Dostawy= result.getString("Id_Dostawy");
                Nazwa_hurtowni = result.getString("Nazwa_hurtowni");
                Nazwa_kwiatu = result.getString("Nazwa_kwiatu");
                Cena_jednostkowa = result.getString("Cena_jednostkowa");
                Ilosc=result.getString("Ilosc");
                Koszty= result.getString("Koszt");
                dostawy.add(new Dostawy(Indeks,Id_Dostawy,Nazwa_hurtowni,Nazwa_kwiatu,Cena_jednostkowa,Ilosc,Koszty));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
    
    public ArrayList<String> WybierzHurtownie() throws SQLException
    {
        ArrayList<String> Hurtownie=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwa_hurtowni FROM kwiaciarnia.hurtownia");
        while(result.next())
        {
         
            Hurtownie.add(result.getString("Nazwa_hurtowni"));
        }
        
        return Hurtownie;
    }
 public ArrayList<String> WybierzKwiat() throws SQLException
    {
        ArrayList<String> Hurtownie=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwa_kwiatu FROM kwiaciarnia.kwiat");
        while(result.next())
        {
         
            Hurtownie.add(result.getString("Nazwa_kwiatu"));
        }
        
        return Hurtownie;
    }

    public void RejestrujDostawe(String aa,String bb,String cc,String dd) throws SQLException
    {
        PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.dostawa values (NULL, ?, ?, ?, ?);");
            
            prepStmt.setString(1, aa);
            prepStmt.setString(2, bb);
            prepStmt.setString(3, cc);
            prepStmt.setString(4, dd);
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
            
    }
    public ArrayList<String> WybierzStanowisko() throws SQLException
    {
        ArrayList<String> Stanowisko=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwa_stanowiska FROM kwiaciarnia.stanowisko");
        while(result.next())
        {
         
            Stanowisko.add(result.getString("Nazwa_stanowiska"));
        }
        
        return Stanowisko;
    }

    public void RejestrujPracownika(String aa,String bb,String cc,String dd,String ee) throws SQLException
    {
        PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.pracownik values (NULL, ?, ?, ?, ?,?);");
            
            prepStmt.setString(1, aa);
            prepStmt.setString(2, bb);
            prepStmt.setString(3, cc);
            prepStmt.setString(4, dd);
            prepStmt.setString(5,ee);
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
            
    }

    void RejestrujHurtownie(String aa, String bb, String cc) throws SQLException {
         PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.hurtownia values (NULL, ?, ?, ?);");
            
            prepStmt.setString(1, aa);
            prepStmt.setString(2, bb);
            prepStmt.setString(3, cc);
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
            
    }
     public void RejestrujKlienta(String aa,String bb,String cc,String dd,String ee) throws SQLException
    {
        PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.klient values (NULL, ?, ?, ?, ?,?);");
            
            prepStmt.setString(1, aa);
            prepStmt.setString(2, bb);
            prepStmt.setString(3, cc);
            prepStmt.setString(4, dd);
            prepStmt.setString(5,ee);
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
            
    }
      public void RejestrujRosline(String aa,String bb) throws SQLException
    {
        PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.kwiat values (NULL, ?, ?);");
            
            prepStmt.setString(1, aa);
            prepStmt.setString(2, bb);
            
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
            
    }
      public ArrayList<String> WybierzKlientow() throws SQLException
    {
        ArrayList<String> Stanowisko=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwisko,Imie FROM kwiaciarnia.klient");
        while(result.next())
        {
         
            Stanowisko.add(result.getString("Imie")+" "+result.getString("Nazwisko"));
        }
        
        return Stanowisko;
    }
        public ArrayList<String> WybierzPracownikow() throws SQLException
    {
        ArrayList<String> Stanowisko=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwisko,Imie FROM kwiaciarnia.pracownik");
        while(result.next())
        {
         
            Stanowisko.add(result.getString("Imie")+" "+result.getString("Nazwisko"));
        }
        
        return Stanowisko;
    }
         public ArrayList<String> WybierzSposobZakupu() throws SQLException
    {
        ArrayList<String> Stanowisko=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwa_sposobu_zakupu FROM kwiaciarnia.sposob_zakupu");
        while(result.next())
        {
         
            Stanowisko.add(result.getString("Nazwa_sposobu_zakupu"));
        }
        
        return Stanowisko;
    }
            public ArrayList<String> WybierzSposobDostawy() throws SQLException
    {
        ArrayList<String> Stanowisko=new ArrayList<String>();
        ResultSet result=stat.executeQuery("SELECT Nazwa_sposobu_dostawy FROM kwiaciarnia.sposob_dostawy");
        while(result.next())
        {
         
            Stanowisko.add(result.getString("Nazwa_sposobu_dostawy"));
        }
        
        return Stanowisko;
    }

    void RejestrujZakup(String dd, String bb, String cc, String hh, String gg, String ff, String aa) throws SQLException {
         PreparedStatement prepStmt=null;
        try {
            
            
            
            prepStmt = con.prepareStatement("Insert into kwiaciarnia.zakupy values (NULL, ?,?,?,?,?,?,?);");
            
            prepStmt.setString(1, dd);
            prepStmt.setString(2, bb);
            prepStmt.setString(3, cc);
            prepStmt.setString(4, hh);
            prepStmt.setString(5, gg);
            prepStmt.setString(6, ff);
            prepStmt.setString(7, aa);
           
            
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BazaDanych.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        prepStmt.close();
    }
         
    public LinkedList<Pracownik> WybierzPracownika() {
        LinkedList<Pracownik> dostawy = new LinkedList<Pracownik>();
        try {
            ResultSet result = stat.executeQuery("SELECT a.Id_Pracownika,a.Imie,a.Nazwisko,a.Miejscowosc,a.Ulica,b.Nazwa_stanowiska,b.Placa FROM kwiaciarnia.pracownik AS a LEFT JOIN kwiaciarnia.stanowisko AS b on a.Id_Stanowiska=b.Id_Stanowiska;");
            String indeks,imie,nazwisko,miejscowosc,adres,stanowisko,placa;
            while(result.next()) {
                indeks = result.getString("Id_Pracownika");
                imie= result.getString("Imie");
                nazwisko = result.getString("Nazwisko");
                miejscowosc = result.getString("Miejscowosc");
                adres = result.getString("Ulica");
                stanowisko=result.getString("Nazwa_stanowiska");
                placa= result.getString("Placa");
                dostawy.add(new Pracownik(imie,nazwisko,miejscowosc,adres,stanowisko,placa,indeks));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
    
     public LinkedList<Klient> WybierzKlienta() {
        LinkedList<Klient> dostawy = new LinkedList<Klient>();
        try {
            ResultSet result = stat.executeQuery("SELECT Id_Klienta,Imie,Nazwisko,Miejscowosc,Ulica,Telefon FROM klient");
            String indeks,imie,nazwisko,miejscowosc,adres,telefon;
            while(result.next()) {
                indeks = result.getString("Id_Klienta");
                imie= result.getString("Imie");
                nazwisko = result.getString("Nazwisko");
                miejscowosc = result.getString("Miejscowosc");
                adres = result.getString("Ulica");
                telefon=result.getString("Telefon");
                dostawy.add(new Klient(indeks,imie,nazwisko,miejscowosc,adres,telefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
     public LinkedList<Hurtownia> WybierzHurtownia() {
        LinkedList<Hurtownia> dostawy = new LinkedList<Hurtownia>();
        try {
            ResultSet result = stat.executeQuery("SELECT Id_Hurtowni,Nazwa_hurtowni,Miejscowosc,Ulica FROM hurtownia");
            String indeks,nazwa,miejscowosc,ulica;
            while(result.next()) {
                indeks = result.getString("Id_Hurtowni");
                nazwa= result.getString("Nazwa_hurtowni");
                miejscowosc = result.getString("Miejscowosc");
                ulica = result.getString("Ulica");
               
                dostawy.add(new Hurtownia(indeks,nazwa,miejscowosc,ulica));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
      public LinkedList<Kwiat> WybierzKwiaty() {
        LinkedList<Kwiat> dostawy = new LinkedList<Kwiat>();
        try {
            ResultSet result = stat.executeQuery("SELECT Id_Rosliny,Nazwa_kwiatu,Cena_jednostkowa FROM kwiat");
            String indeks,nazwa;
            int cena;
            while(result.next()) {
                indeks = result.getString("Id_Rosliny");
                nazwa= result.getString("Nazwa_kwiatu");
                cena=result.getInt("Cena_jednostkowa");
               
                dostawy.add(new Kwiat(indeks,nazwa,cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
    
      public LinkedList<Magazyn> WybierzMagazynZ() {
        LinkedList<Magazyn> dostawy = new LinkedList<Magazyn>();
        try {
            ResultSet result = stat.executeQuery("SELECT Id_Rosliny,Ilosc FROM zakupy");
            String indeks;
            int cena;
            while(result.next()) {
                indeks = result.getString("Id_Rosliny");
                
                cena=result.getInt("Ilosc");
               
                dostawy.add(new Magazyn(indeks,cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
     public LinkedList<Magazyn> WybierzMagazynD() {
        LinkedList<Magazyn> dostawy = new LinkedList<Magazyn>();
        try {
            ResultSet result = stat.executeQuery("SELECT Id_Rosliny,Ilosc FROM dostawa");
            String indeks;
            int cena;
            while(result.next()) {
                indeks = result.getString("Id_Rosliny");
                
                cena=result.getInt("Ilosc");
                dostawy.add(new Magazyn(indeks,cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
     
      public LinkedList<Zakup> WybierzZakupy() {
        LinkedList<Zakup> dostawy = new LinkedList<Zakup>();
        try {
            ResultSet result = stat.executeQuery("SELECT a.Id_zakupu,a.Ilosc,a.Indeks,b.Imie,b.Nazwisko,c.Imie,c.Nazwisko,d.Nazwa_sposobu_dostawy,e.Nazwa_sposobu_zakupu,f.Nazwa_kwiatu,f.Cena_jednostkowa FROM kwiaciarnia.zakupy AS a LEFT JOIN kwiaciarnia.pracownik AS b on a.Id_Pracownika=b.Id_Pracownika LEFT JOIN kwiaciarnia.klient AS c on a.Id_Klienta=c.Id_Klienta LEFT JOIN kwiaciarnia.sposob_dostawy AS d on a.Id_Sposobu_Dostawy=d.Id_Sposobu_Dostawy LEFT JOIN kwiaciarnia.sposob_zakupu AS e on a.Id_sposobu_zakupu=e.Id_sposobu_zakupu LEFT JOIN kwiaciarnia.kwiat AS f on a.Id_Rosliny=f.Id_Rosliny;");
             String Indeks,Id_zakupu,ImieP,NazwiskoP,ImieK,NazwiskoK,sZakupu,sDostawy,Nazwa;
    int cena,ilosc;
            while(result.next()) {
                Indeks = result.getString("Indeks");
                Id_zakupu= result.getString("Id_zakupu");
                ImieP=result.getString("b.Imie");
                NazwiskoP=result.getString("b.Nazwisko");
                ImieK= result.getString("c.Imie");
                NazwiskoK= result.getString("c.Nazwisko");
                sZakupu= result.getString("Nazwa_sposobu_zakupu");
                sDostawy= result.getString("Nazwa_sposobu_dostawy");
                Nazwa= result.getString("Nazwa_kwiatu");
                 cena=result.getInt("Cena_jednostkowa");
                 ilosc=result.getInt("Ilosc");
                dostawy.add(new Zakup(Indeks,Id_zakupu,ImieP,NazwiskoP,ImieK,NazwiskoK,sZakupu,sDostawy,Nazwa,cena,ilosc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dostawy;
    }
    
            
}

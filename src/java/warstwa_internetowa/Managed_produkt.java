/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_internetowa;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import warstwa_biznesowa.Fasada_warstwy_biznesowej;

/**
 *
 * @author Paweł L. 6148
 */
@Named(value = "managed_produkt")
@RequestScoped
public class Managed_produkt {

    @EJB
    private Fasada_warstwy_biznesowej fasada;
    private String nazwa;
    private String kategoria;
    private String cena;
    private String promocja;
    private String cena_brutto;

    public Managed_produkt() {   
    }

    public Fasada_warstwy_biznesowej getFasada() {
        return fasada;
    }

    public void setFasada(Fasada_warstwy_biznesowej fasada) {
        this.fasada = fasada;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getPromocja() {
        return promocja;
    }

    public void setPromocja(String promocja) {
        this.promocja = promocja;
    }

    public String getCena_brutto() {
        return cena_brutto;
    }

    public void setCena_brutto(String cena_brutto) {
        this.cena_brutto = cena_brutto;
    }
    
    public String dodaj_produkt(){
        String[] dane = {nazwa, kategoria, cena, promocja};
        fasada.utworz_produkt(dane);
        dane_produktu();
        return "rezultat1";
    }
    
    public void dane_produktu(){
        String dane[] = fasada.dane_produktu();
        nazwa=dane[0];
        kategoria = dane[1];
        cena=dane[2];
        promocja=dane[3];
        cena_brutto=dane[4];
    }
}
